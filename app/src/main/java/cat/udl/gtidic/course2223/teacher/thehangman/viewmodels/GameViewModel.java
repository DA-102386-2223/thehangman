package cat.udl.gtidic.course2223.teacher.thehangman.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cat.udl.gtidic.course2223.teacher.thehangman.models.Game;

public class GameViewModel extends ViewModel {

    private Game internalGame;
    private MutableLiveData<Game> game = new MutableLiveData<>();

    public GameViewModel(){
        internalGame = new Game();
        game.setValue(internalGame);
    }

    public LiveData<Game> getGame(){
        return game;
    }

    public Game GetGameI()
    {
        return internalGame;
    }

    public void newLetterVM() {
        Game myGame = game.getValue();
        game.setValue(myGame);
    }

}
