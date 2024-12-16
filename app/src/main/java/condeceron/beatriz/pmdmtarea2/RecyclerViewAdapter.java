package condeceron.beatriz.pmdmtarea2;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.GameCharacterViewHolder> {

    public static class GameCharacterViewHolder extends RecyclerView.ViewHolder {

        CardView card;
        TextView characterName;
        ImageView characterImage;

        GameCharacterViewHolder(View characterView) {
            super(characterView);
            card = (CardView) characterView.findViewById(R.id.characterCardView);
            characterName = (TextView) characterView.findViewById(R.id.character_name);
            characterImage = (ImageView) characterView.findViewById(R.id.character_image);
        }
    }

    List<GameCharacter> characters;

    RecyclerViewAdapter(List<GameCharacter> characters){
        this.characters = characters;
    }

    @Override
    public GameCharacterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.activity_cardview, viewGroup, false);
        return new GameCharacterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GameCharacterViewHolder gameCharacterViewHolder, int i) {
        GameCharacter character = characters.get(i);
        gameCharacterViewHolder.characterName.setText(character.getName());
        gameCharacterViewHolder.characterImage.setImageResource(character.getImageId());

        Bundle characterBundle = new Bundle();

        characterBundle.putString("name", character.getName());
        characterBundle.putString("description", character.getDescription());
        characterBundle.putString("ability", character.getAbility());
        characterBundle.putInt("image", character.getImageId());

        gameCharacterViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), CharacterDetailActivity.class);
                intent.putExtras(characterBundle);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

}
