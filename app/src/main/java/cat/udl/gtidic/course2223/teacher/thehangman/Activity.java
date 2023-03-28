package cat.udl.gtidic.course2223.teacher.thehangman;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

import android.os.Bundle;

public class Activity extends AppCompatActivity {

    Button startgame;
    private EditText editText;



    @Override
    protected void onResume() {
        super.onResume();

        boolean gameOver = false;
        if (gameOver) {
            gameOver = false;
            Intent intent = new Intent(this, Game.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        startgame = (Button) findViewById(R.id.startgame);
        startgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = editText.getText().toString();
                if(nombre.trim().equals("")) {
                    Toast.makeText(Activity.this, "Por favor ingresa un nombre válido", Toast.LENGTH_SHORT).show();
                } else {
                Intent i = new Intent(Activity.this, Game.class);
                startActivity(i);
                finish();
            }
        }
        });
    }
}