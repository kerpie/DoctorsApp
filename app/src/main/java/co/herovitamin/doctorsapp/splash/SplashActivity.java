package co.herovitamin.doctorsapp.splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.herovitamin.doctorsapp.MainActivity;
import co.herovitamin.doctorsapp.R;

public class SplashActivity extends AppCompatActivity implements SplashContract.View{

    SplashPresenter splashPresenter;

    @BindView(R.id.splash_loader)
    ProgressBar splashLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashPresenter = new SplashPresenter(this);

        ButterKnife.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        splashPresenter.start();
    }

    @Override
    public void showLoader() {
        splashLoader.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoader() {
        splashLoader.setVisibility(View.INVISIBLE);
    }

    @Override
    public void changeToMainScreen(Intent intent) {
        startActivity(intent);
        finish();
    }
}
