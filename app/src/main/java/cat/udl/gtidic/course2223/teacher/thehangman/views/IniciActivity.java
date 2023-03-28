package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import cat.udl.gtidic.course2223.teacher.thehangman.R;

public class IniciActivity extends AppCompatActivity {

    Button startGameButton;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inici);

        startGameButton = findViewById(R.id.startGameButton);
        startGameButton.setOnClickListener(v -> startGameActivity());
        editTextName = findViewById(R.id.editTextName);
    }

    public void startGameActivity(){
        if (!editTextName.getText().toString().equals("")) {
            String name = editTextName.getText().toString();
            Intent i = new Intent(this, MainActivity.class);
            i.putExtra("DATA_NAME", name);
            startActivity(i);
        } else {
            editTextName.setText("Name");
        }
    }
}