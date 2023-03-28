package cat.udl.gtidic.course2223.teacher.thehangman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import cat.udl.gtidic.course2223.teacher.thehangman.view.MainActivity;

public class pantallaprincipal extends AppCompatActivity {

    EditText userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantallaprincipal);
        findViewById(R.id.buttonStart).setOnClickListener(v-> startGame());
        userName = findViewById(R.id.editTextTextPersonName);
    }
    private void startGame(){
        Intent intent = new Intent(pantallaprincipal.this, MainActivity.class);
        String name = userName.getText().toString().trim();
        if(name.isEmpty()){
            userName.setError("El nom és requerit.");
            userName.requestFocus();
            return;
        }
        intent.putExtra("nomdelJugador", name);
        startActivity(intent);
    }

}