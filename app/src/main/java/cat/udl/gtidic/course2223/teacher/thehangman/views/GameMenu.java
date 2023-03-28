package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import cat.udl.gtidic.course2223.teacher.thehangman.R;
import cat.udl.gtidic.course2223.teacher.thehangman.views.MainActivity;

public class GameMenu extends AppCompatActivity {

    EditText usernameInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_menu);

        usernameInput = findViewById(R.id.usernameInput);

        findViewById(R.id.btnStartGame).setOnClickListener(v -> {
            if (usernameInput.getText().toString().isEmpty())
                Toast.makeText(this, getResources().getString(R.string.usernameError), Toast.LENGTH_SHORT).show();
            else {
                Intent intent = new Intent(this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("username", usernameInput.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}