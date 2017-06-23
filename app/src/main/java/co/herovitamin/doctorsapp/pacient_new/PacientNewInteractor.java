package co.herovitamin.doctorsapp.pacient_new;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import co.herovitamin.doctorsapp.database.PacientDAO;
import co.herovitamin.doctorsapp.database.PacientDatabase;
import co.herovitamin.doctorsapp.model.Pacient;

/**
 * Created by kerry on 23/06/17.
 */

public class PacientNewInteractor implements PacientNewContract.Interactor {

    OnDataSavedListener listener;

    // for local storage
    PacientDatabase db;
    PacientDAO pacientDAO;

    public PacientNewInteractor(Context context, OnDataSavedListener listener) {
        this.listener = listener;
        db = Room.databaseBuilder(context, PacientDatabase.class, "database-name").build();
        pacientDAO = db.pacientDAO();
    }

    @Override
    public void performSave(final Pacient pacient) {
        new SaveToDB().execute(pacient);
    }

    public class SaveToDB extends AsyncTask<Pacient, Long, Void>{
        long result;
        Pacient pacient;
        @Override
        protected Void doInBackground(Pacient... params) {
            pacient = params[0];
            result = pacientDAO.insert(pacient);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(result != -1){
                listener.onDataSaveSuccess();
            }
            else
                listener.onDataSaveFail(pacient);
        }
    }
}
