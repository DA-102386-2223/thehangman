package cat.udl.gtidic.course2223.teacher.thehangman.viewmodel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cat.udl.gtidic.course2223.teacher.thehangman.model.Game;

public class GameViewModel extends ViewModel {
    private MutableLiveData<Game> game = new MutableLiveData<>();
    private Context context;
    public GameViewModel(){
        Game internalGame = new Game();
        internalGame.init();
        game.setValue(internalGame);
    }
    public LiveData<Game> getGame(){
        return game;
    }
    public void setContext(Context context){
        this.context = context;
    }
    public void newLetterViewModel(){

    }
}
