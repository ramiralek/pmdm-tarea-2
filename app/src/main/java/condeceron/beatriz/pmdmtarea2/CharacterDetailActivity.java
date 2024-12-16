package condeceron.beatriz.pmdmtarea2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CharacterDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_characterdetail);

        TextView characterNameTextView = findViewById(R.id.character_detail_name);
        TextView characterDescriptionTextView = findViewById(R.id.character_detail_description);
        TextView characterAbilityTextView = findViewById(R.id.character_detail_ability);
        ImageView characterImageView = findViewById(R.id.character_detail_image);

        Bundle characterBundle = getIntent().getExtras();

        if (characterBundle != null) {
            String name = characterBundle.getString("name");
            String description = characterBundle.getString("description");
            String ability = characterBundle.getString("ability");
            int imageId = characterBundle.getInt("image");

            characterNameTextView.setText(name);
            characterDescriptionTextView.setText(description);
            characterAbilityTextView.setText(ability);
            characterImageView.setImageResource(imageId);

            Toast.makeText(this, getString(R.string.character_selected) + " " + name, Toast.LENGTH_LONG).show();
        }


    }
}