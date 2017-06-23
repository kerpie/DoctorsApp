package co.herovitamin.doctorsapp.pacients_list;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.herovitamin.doctorsapp.R;

public class PacientsListFragment extends Fragment implements PacientListContract.View {

    @BindView(R.id.pacients_list)
    private RecyclerView pacientsList;

    @BindView(R.id.pacients_loader)
    private ProgressBar pacientsLoader;

    @BindView(R.id.new_pacient_button)
    private FloatingActionButton newPacientButton;

    PacientListContract.Presenter presenter;

    private OnFragmentInteractionListener mListener;

    public PacientsListFragment() {}

    public static PacientsListFragment newInstance() {
        PacientsListFragment fragment = new PacientsListFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new PacientPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pacients_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.start();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void setList() {

    }

    @Override
    public void showLoader() {
        pacientsLoader.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        pacientsLoader.setVisibility(View.GONE);
    }

    @Override
    public void showList() {
        pacientsList.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideList() {
        pacientsList.setVisibility(View.GONE);
    }

    @Override
    public void showNewPacientButton() {
        newPacientButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideNewPacientButton() {
        newPacientButton.setVisibility(View.GONE);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
