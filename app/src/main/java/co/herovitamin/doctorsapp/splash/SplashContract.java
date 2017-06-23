package co.herovitamin.doctorsapp.splash;

import android.content.Intent;

/**
 * Created by kerry on 22/06/17.
 */

interface SplashContract {

    interface View{
        void changeToMainScreen(Intent intent);
        void showLoader();
        void hideLoader();
    }

    interface Presenter{
        void start();
        void showMainScreen();
    }

}
