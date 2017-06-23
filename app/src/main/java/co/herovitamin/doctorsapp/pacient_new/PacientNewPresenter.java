package co.herovitamin.doctorsapp.pacient_new;

import android.content.Context;

import co.herovitamin.doctorsapp.R;
import co.herovitamin.doctorsapp.model.Pacient;

/**
 * Created by kerry on 23/06/17.
 */

public class PacientNewPresenter implements PacientNewContract.Presenter, PacientNewContract.Interactor.OnDataSavedListener{

    PacientNewContract.View view;
    PacientNewContract.Interactor interactor;

    public PacientNewPresenter(PacientNewContract.View view, Context context) {
        this.view = view;
        interactor = new PacientNewInteractor(context, this);
    }

    @Override
    public void savePacientData(String name, String age, boolean isMale, boolean hasMigraine, boolean doesDrugs) {
        view.showLoader();
        Pacient pacient;
        int intAge;
        try {
            intAge = Integer.parseInt(age);
        }catch (Exception ex){
            intAge = -1;
        }
        pacient = new Pacient(name, intAge, isMale, hasMigraine, doesDrugs);
        if(pacient.isValid())
            interactor.performSave(pacient);
        else {
            view.showErrors(pacient);
            view.hideLoader();
        }
    }

    @Override
    public void onDataSaveSuccess() {
        view.hideLoader();
        view.showList();
    }

    @Override
    public void onDataSaveFail(Pacient pacient) {
        view.hideLoader();
        view.showList();
        view.showMessage(R.string.error_db_message);
    }
}
