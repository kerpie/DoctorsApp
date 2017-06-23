package co.herovitamin.doctorsapp.database;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.RoomDatabase;

import co.herovitamin.doctorsapp.model.Pacient;

/**
 * Created by kerry on 23/06/17.
 */

@Database(entities =  {Pacient.class}, version = 1)
public abstract class PacientDatabase extends RoomDatabase{
    public abstract PacientDAO pacientDAO();
}
