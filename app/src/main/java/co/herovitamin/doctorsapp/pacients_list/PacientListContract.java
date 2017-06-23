package co.herovitamin.doctorsapp.pacients_list;

/**
 * Created by kerry on 23/06/17.
 */

public interface PacientListContract {

    interface View{
        void setList();
        void showLoader();
        void hideLoader();
        void showList();
        void hideList();
        void showNewPacientButton();
        void hideNewPacientButton();
    }

    interface Presenter{
        void start();
        void loadPacientsData();
    }

}
