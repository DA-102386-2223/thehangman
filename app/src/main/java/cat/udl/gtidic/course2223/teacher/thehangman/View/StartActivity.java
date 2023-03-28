package cat.udl.gtidic.course2223.teacher.thehangman.View;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import cat.udl.gtidic.course2223.teacher.thehangman.R;

public class StartActivity extends AppCompatActivity {


    EditText et_name;
    Button btnStart;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_activity);

        et_name = findViewById(R.id.et_nom);
        btnStart = findViewById(R.id.btn_start);


        btnStart.setOnClickListener(view -> startGame());

    }

    private void startGame() {
        if(et_name.getText().toString().isEmpty()){
            et_name.setError("Introduce tu nombre.");
            et_name.requestFocus();
            return;
        }
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

}
