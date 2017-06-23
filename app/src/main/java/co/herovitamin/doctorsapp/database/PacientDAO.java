package co.herovitamin.doctorsapp.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import co.herovitamin.doctorsapp.model.Pacient;

/**
 * Created by kerry on 23/06/17.
 */

@Dao
public interface PacientDAO {

    @Query("SELECT * FROM pacient")
    List<Pacient> getAll();

    @Insert
    long insert(Pacient pacient);
}
