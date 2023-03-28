package cat.udl.gtidic.course2223.teacher.thehangman;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GameViewModel extends ViewModel {

    private MutableLiveData<Game> game = new MutableLiveData<>();

    public GameViewModel(){
        Game internalGame = new Game();
        game.setValue(internalGame);
    }

    public LiveData<Game> getGame(){
        return game;
    }

}
