package cat.udl.gtidic.course2223.teacher.thehangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity extends AppCompatActivity {

    Button btnStart;
    EditText NomJugador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);

        NomJugador = findViewById(R.id.NomJugador);
        btnStart = findViewById(R.id.button);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String playerName = NomJugador.getText().toString();
                if (TextUtils.isEmpty(playerName)) {
                    Toast.makeText(Activity.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(Activity.this, MainActivity.class);
                    intent.putExtra("playerName", playerName);
                    startActivity(intent);
                }
            }
        });
    }
}


