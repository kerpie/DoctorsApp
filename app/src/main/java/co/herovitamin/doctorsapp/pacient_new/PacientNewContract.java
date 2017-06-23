package co.herovitamin.doctorsapp.pacient_new;

import co.herovitamin.doctorsapp.model.Pacient;

/**
 * Created by kerry on 23/06/17.
 */

public interface PacientNewContract {

    interface View{
        void showLoader();
        void hideLoader();
        void showNameError(Pacient pacient);
        void showAgeError(Pacient pacient);
        void showErrors(Pacient pacient);
        void showList();
        void showMessage(int id);
    }

    interface Presenter{
        void savePacientData(String name, String age, boolean isMale, boolean hasMigraine, boolean doesDrugs);
    }

    interface Interactor{

        interface OnDataSavedListener{
            void onDataSaveSuccess();
            void onDataSaveFail(Pacient pacient);
        }

        void performSave(Pacient pacient);
    }
}
