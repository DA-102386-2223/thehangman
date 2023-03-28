package cat.udl.gtidic.course2223.teacher.thehangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PantallaPrincipal extends AppCompatActivity {

    Button StartGameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);




            StartGameButton = (Button) findViewById(R.id.StartGameButton);

            StartGameButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(PantallaPrincipal.this, MainActivity.class);
                    startActivity(i);
                    finish();

                }
            });
            //guarda el nombre del jugador y lo imprime en la pantalla de juego



        }
    }