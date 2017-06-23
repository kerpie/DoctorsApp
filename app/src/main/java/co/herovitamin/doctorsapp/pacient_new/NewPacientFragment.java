package co.herovitamin.doctorsapp.pacient_new;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.herovitamin.doctorsapp.MainActivity;
import co.herovitamin.doctorsapp.R;
import co.herovitamin.doctorsapp.model.Pacient;
import co.herovitamin.doctorsapp.pacients_list.PacientsListFragment;

public class NewPacientFragment extends Fragment implements PacientNewContract.View{

    @BindView(R.id.new_pacient_fragment_container)
    ConstraintLayout fragmentContainer;

    @BindView(R.id.name_container)
    TextInputLayout nameContainer;
    @BindView(R.id.pacient_new_name)
    EditText pacientName;
    @BindView(R.id.age_container)
    TextInputLayout ageContainer;
    @BindView(R.id.pacient_new_age)
    EditText pacientAge;

    @BindView(R.id.gender_options_container)
    RadioGroup genderOptionsContainer;
    @BindView(R.id.radio_option_one)
    RadioButton radioOptionMale;
    @BindView(R.id.radio_option_two)
    RadioButton radioOptionFemale;

    @BindView(R.id.new_pacient_has_migraine)
    SwitchCompat hasMigraine;
    @BindView(R.id.new_pacient_does_drugs)
    SwitchCompat doesDrugs;
    @BindView(R.id.new_pacient_save)
    Button saveButton;
    @BindView(R.id.progress_container)
    FrameLayout progressContainer;

    PacientNewContract.Presenter presenter;

    public NewPacientFragment() {}

    public static NewPacientFragment newInstance(String param1, String param2) {
        NewPacientFragment fragment = new NewPacientFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PacientNewPresenter(this, getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_pacient, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void showLoader() {
        progressContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        progressContainer.setVisibility(View.GONE);
    }

    @OnClick(R.id.new_pacient_save)
    public void savePacient(View view){
        boolean genderIsMale = genderOptionsContainer.getCheckedRadioButtonId() == radioOptionMale.getId() ? true : false;
        presenter.savePacientData(
                pacientName.getText().toString(),
                pacientAge.getText().toString(),
                genderIsMale,
                hasMigraine.isActivated(),
                doesDrugs.isActivated()
        );
    }

    @Override
    public void showErrors(Pacient pacient) {
        if(pacient.getName().isEmpty() || pacient.getName().length() == 0)
            showNameError(pacient);
        if(pacient.getAge() <=0)
            showAgeError(pacient);
    }

    @Override
    public void showList() {
        ((MainActivity) getActivity()).replaceFragment(new PacientsListFragment(), false);
    }

    @Override
    public void showNameError(Pacient pacient) {
        nameContainer.setErrorEnabled(true);
        nameContainer.setError(getString(R.string.error_name_message));
    }

    @Override
    public void showAgeError(Pacient pacient) {
        ageContainer.setErrorEnabled(true);
        ageContainer.setError(getString(R.string.error_age_message));
    }

    @Override
    public void showMessage(int id) {
        Toast.makeText(getActivity(), id, Toast.LENGTH_SHORT).show();
    }
}
