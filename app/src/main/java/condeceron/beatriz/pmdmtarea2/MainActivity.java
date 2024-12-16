package condeceron.beatriz.pmdmtarea2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<GameCharacter> characters;
    private RecyclerView recyclerCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        recyclerCharacters=(RecyclerView)findViewById(R.id.recyclerCharacters);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerCharacters.setLayoutManager(layoutManager);
        recyclerCharacters.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

        Snackbar.make(findViewById(R.id.main), getString(R.string.welcome), Snackbar.LENGTH_LONG).show();
    }

    private void initializeData(){
        characters = new ArrayList<>();
        characters.add(new GameCharacter(getString(R.string.mario), getString(R.string.mario_description), getString(R.string.mario_ability), R.drawable.mario));
        characters.add(new GameCharacter(getString(R.string.luigi), getString(R.string.luigi_description), getString(R.string.luigi_ability), R.drawable.luigi));
        characters.add(new GameCharacter(getString(R.string.peach), getString(R.string.peach_description), getString(R.string.peach_ability), R.drawable.peach));
        characters.add(new GameCharacter(getString(R.string.toad), getString(R.string.toad_description), getString(R.string.toad_ability), R.drawable.toad));
    }

    private void initializeAdapter(){
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(characters);
        recyclerCharacters.setAdapter(adapter);
    }
}