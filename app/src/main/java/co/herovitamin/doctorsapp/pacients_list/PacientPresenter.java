package co.herovitamin.doctorsapp.pacients_list;

/**
 * Created by kerry on 23/06/17.
 */

public class PacientPresenter implements PacientListContract.Presenter {

    PacientListContract.View view;

    public PacientPresenter(PacientListContract.View view) {
        this.view = view;
    }

    @Override
    public void start() {
        view.showLoader();
        view.hideList();
        loadPacientsData();
    }

    @Override
    public void loadPacientsData() {

    }
}
