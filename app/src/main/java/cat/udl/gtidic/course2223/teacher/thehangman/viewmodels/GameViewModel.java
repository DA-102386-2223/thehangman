package cat.udl.gtidic.course2223.teacher.thehangman.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import cat.udl.gtidic.course2223.teacher.thehangman.models.Game;

public class GameViewModel extends ViewModel {

    private Game game;

    public GameViewModel() {
        game = new Game();
    }

    public Game getGame() {
        return game;
    }

    public LiveData<String> getVisibleWordLD() {
        return game.getVisibleWordLD();
    }

}
