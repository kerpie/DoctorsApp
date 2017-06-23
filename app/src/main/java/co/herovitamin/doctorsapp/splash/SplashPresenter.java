package co.herovitamin.doctorsapp.splash;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;

import co.herovitamin.doctorsapp.MainActivity;

/**
 * Created by kerry on 22/06/17.
 */

class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View mView;

    SplashPresenter(SplashContract.View mView) {
        this.mView = mView;
    }

    @Override
    public void start() {
        mView.showLoader();

        // simulate loading of data
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               showMainScreen();
            }
        }, 3000);
    }

    @Override
    public void showMainScreen() {
        mView.hideLoader();
        Intent intent = new Intent((AppCompatActivity)mView, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        mView.changeToMainScreen(intent);
    }

}













