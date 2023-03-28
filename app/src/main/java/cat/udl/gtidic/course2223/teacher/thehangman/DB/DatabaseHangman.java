package cat.udl.gtidic.course2223.teacher.thehangman.DB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import cat.udl.gtidic.course2223.teacher.thehangman.models.Game;

@Database(entities = {Game.class}, version = 1,exportSchema = true)
public abstract class DatabaseHangman extends RoomDatabase {
    public abstract GameDAO gameDA0();
}