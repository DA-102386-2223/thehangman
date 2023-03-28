package cat.udl.gtidic.course2223.teacher.thehangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class pantallaprincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallaprincipal);
        findViewById(R.id.buttonStart).setOnClickListener(v-> startGame());
       // findViewById(R.id.btLogin).setOnClickListener(v -> login());
    }
    private void startGame(){
        Intent intent = new Intent(pantallaprincipal.this, MainActivity.class);
        startActivity(intent);
    }
}