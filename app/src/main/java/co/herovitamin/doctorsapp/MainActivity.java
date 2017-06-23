package co.herovitamin.doctorsapp;

import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import co.herovitamin.doctorsapp.pacient_new.NewPacientFragment;
import co.herovitamin.doctorsapp.pacients_list.PacientsListFragment;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        replaceFragment(new PacientsListFragment(), true);
    }

    public void replaceFragment(Fragment fragment, boolean addToBackStack){
        if(addToBackStack)
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).addToBackStack("").commit();
        else
            getSupportFragmentManager().beginTransaction().replace(R.id.main_container, fragment).commit();
    }
}
