package cat.udl.gtidic.course2223.teacher.thehangman.ViewModel;

import androidx.lifecycle.MutableLiveData;

import cat.udl.gtidic.course2223.teacher.thehangman.View.Game;

public class ViewModel extends androidx.lifecycle.ViewModel {

    private MutableLiveData<Game> game = new MutableLiveData<>();

    public ViewModel(){
        Game internalGame = new Game();
        game.setValue(internalGame);
    }

    public MutableLiveData<Game> getGame(){
        return game;
    }


}
