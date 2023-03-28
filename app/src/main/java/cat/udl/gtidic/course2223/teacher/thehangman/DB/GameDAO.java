package cat.udl.gtidic.course2223.teacher.thehangman.DB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import cat.udl.gtidic.course2223.teacher.thehangman.models.Game;

@Dao
public interface GameDAO {
    @Insert
    long[] insertAll(Game... games);

    @Insert
    long insert(Game game);

    @Query("SELECT * FROM game")
    List<Game> getAll();

    @Delete
    void deleteOne(Game game);

    @Query("DELETE FROM game")
    void deleteAll();

    @Update
    void update(Game game);
}
