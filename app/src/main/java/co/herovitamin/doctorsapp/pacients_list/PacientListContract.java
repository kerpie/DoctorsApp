package co.herovitamin.doctorsapp.pacients_list;

import java.util.List;

import co.herovitamin.doctorsapp.model.Pacient;

/**
 * Created by kerry on 23/06/17.
 */

public interface PacientListContract {

    interface View{
        void setList(PacientsAdapter adapter);
        void showLoader();
        void hideLoader();
        void showList();
        void hideList();
        void showNewPacientButton();
        void hideNewPacientButton();
        void showMessage(int error_message_id);
    }

    interface Presenter{
        void start();
        void loadPacientsData();
    }

}
