package cat.udl.gtidic.course2223.teacher.thehangman.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import cat.udl.gtidic.course2223.teacher.thehangman.R;
import cat.udl.gtidic.course2223.teacher.thehangman.models.Game;
import cat.udl.gtidic.course2223.teacher.thehangman.viewmodels.GameViewModel;

public class MainActivity extends AppCompatActivity {

    Button btnNewLetter;
    TextView visibleWord;
    TextView lettersChosen;
    TextView tvUsername;
    EditText etNewLetter;
    ImageView ivState;
    Game game;
    GameViewModel gameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        String username = bundle.getString("username");

//        here is a good place to implement MVVM if someone is interested
        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);

//        initializing views
        btnNewLetter = findViewById(R.id.btnNewLetter);
        btnNewLetter.setOnClickListener(v -> newLetter());
        visibleWord = findViewById(R.id.tvVisibleWord);
        lettersChosen = findViewById(R.id.tvLettersChosen);
        etNewLetter = findViewById(R.id.etNewLetter);
        ivState = findViewById(R.id.ivState);
        tvUsername = findViewById(R.id.tvUsername);

        tvUsername.append(username);

        gameViewModel.getVisibleWordLD().observe(this, val -> {
            visibleWord.setText(val);
        });

//        starting game mechanics
        startGame();
    }

    /**
     * Retorna el Drawable segons l'estat correcte
     */
    private Drawable getDrawableFromState(int state){
        int r_desired = -1;

        switch (state){
            case 0: r_desired = R.drawable.round_0; break;
            case 1: r_desired = R.drawable.round_1; break;
            case 2: r_desired = R.drawable.round_2; break;
            case 3: r_desired = R.drawable.round_3; break;
            case 4: r_desired = R.drawable.round_4; break;
            case 5: r_desired = R.drawable.round_5; break;
            case 6: r_desired = R.drawable.round_6; break;
            case 7: r_desired = R.drawable.round_7; break;
        }
        return ContextCompat.getDrawable(this, r_desired);
    }

    /**
     * Actualitza les views de la pantalla
     */
    private void refreshWords(){
        game.visibleWord();
        lettersChosen.setText(game.lettersChosen());
        ivState.setImageDrawable(getDrawableFromState(game.getCurrentRound()));
    }

    /**
     * Afegeix la lletra al joc
     */
    private void newLetter(){
        String novaLletra = etNewLetter.getText().toString().toUpperCase();
        etNewLetter.setText("");

        int validLetter = game.addLetter(novaLletra);
        if (validLetter == Game.LETTER_VALIDATION_NO_VALID_BECAUSE_SIZE){
            Log.d(Game.TAG, "Lletra no vàlida");
            Toast.makeText(this, "Has introduit més d'una lletra!", Toast.LENGTH_SHORT).show();
        } else if (validLetter == Game.LETTER_VALIDATION_NO_VALID_BECAUSE_ALREADY_SELECTED){
            Log.d(Game.TAG, "Lletra ja escollida");
            Toast.makeText(this, "La lletra ja ha estat escollida!", Toast.LENGTH_SHORT).show();
        } else if (validLetter == Game.LETTER_VALIDATION_OK){
            Log.d(Game.TAG, "Lletra vàlida");
        }
        Log.d(Game.TAG, "Estat actual: " + game.getCurrentRound());

        refreshWords();
        hideKeyboard();
        checkGameOver();
    }

    /**
     * Revisa si el joc ha acabat i informa via Log (de moment)
     */
    private void checkGameOver(){
        if (game.isPlayerTheWinner()){
            Log.d(Game.TAG, "El jugador ha guanyat!");
            finish();
        }

        if (game.isGameOver()){
            Log.d(Game.TAG, "El Joc ha acabat");
            btnNewLetter.setEnabled(false);
            etNewLetter.setEnabled(false);
            finish();
        }
    }

    /**
     * Inicia el joc i actualitza l'activitat
     */
    private void startGame(){
        game = gameViewModel.getGame();
        refreshWords();
    }

    /* -------- METODES AUXILIARS --------- */

    /**
     * Amaga el teclat virtual de la pantalla
     */
    private void hideKeyboard(){
        // Check if no view has focus:
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}