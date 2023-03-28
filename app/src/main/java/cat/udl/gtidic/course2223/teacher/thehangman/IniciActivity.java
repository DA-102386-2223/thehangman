package cat.udl.gtidic.course2223.teacher.thehangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class IniciActivity extends AppCompatActivity {

    Button startGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inici);

        startGameButton = findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(v -> startGame());
    }

    public void startGame(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}