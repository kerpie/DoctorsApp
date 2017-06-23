package co.herovitamin.doctorsapp.pacients_list;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import co.herovitamin.doctorsapp.R;
import co.herovitamin.doctorsapp.database.PacientDAO;
import co.herovitamin.doctorsapp.database.PacientDatabase;
import co.herovitamin.doctorsapp.model.Pacient;

/**
 * Created by kerry on 23/06/17.
 */

public class PacientListPresenter implements PacientListContract.Presenter {

    PacientListContract.View view;
    PacientDatabase db;
    PacientDAO pacientDAO;

    public PacientListPresenter(PacientListContract.View view, Context context) {
        this.view = view;
        db = Room.databaseBuilder(context, PacientDatabase.class, "database-name").build();
        pacientDAO = db.pacientDAO();
    }

    @Override
    public void start() {
        view.showLoader();
        view.hideList();
        view.hideNewPacientButton();
        loadPacientsData();
    }

    @Override
    public void loadPacientsData() {
        new GetAllPacients().execute();
    }

    class GetAllPacients extends AsyncTask<Void, Void, Void>{
        List<Pacient> pacients;
        @Override
        protected Void doInBackground(Void... params) {
            pacients = pacientDAO.getAll();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            if(pacients.size() > 0){
                PacientsAdapter adapter = new PacientsAdapter(pacients);
                view.setList(adapter);
                view.showList();
            }
            else{
                view.showMessage(R.string.error_message_db_empty);
            }
            view.showNewPacientButton();
            view.hideLoader();
        }
    }
}
