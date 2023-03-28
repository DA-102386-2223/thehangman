package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cat.udl.gtidic.course2223.teacher.thehangman.R;

public class Iniciar extends AppCompatActivity {
    String nom = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar);

        EditText nomjugadore = findViewById(R.id.nomjugador);

        Button iniciar = findViewById(R.id.iniciar);

        findViewById(R.id.iniciar).setOnClickListener(v -> iniciar(nomjugadore));

    }

    private void iniciar(EditText nomjugadore)
    {
        nom = nomjugadore.getText().toString();
        System.out.println("Aqui" +  nom);
        if(nom == "")
        {
            Toast.makeText(this, "No has posat cap nom", Toast.LENGTH_SHORT).show();
        }
        else
        {
            jugar(nom);
        }
    }

    private void jugar(String s)
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("EXTRA_NAME_ID", s);
        startActivity(intent);
        finish();
    }
}