package co.herovitamin.doctorsapp;

import android.arch.persistence.room.Room;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import co.herovitamin.doctorsapp.database.PacientDAO;
import co.herovitamin.doctorsapp.database.PacientDatabase;
import co.herovitamin.doctorsapp.model.Pacient;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by kerry on 25/06/17.
 */

@RunWith(AndroidJUnit4.class)
public class PacientsListScreenTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private PacientDatabase db;
    private PacientDAO pacientDAO;

    @Before
    public void init(){
        db = Room.databaseBuilder(mMainActivityActivityTestRule.getActivity(), PacientDatabase.class, "database-name").build();
        pacientDAO = db.pacientDAO();
    }

    @Test
    public void whenDatabaseIsEmptyThenListIsHidden(){
        List<Pacient> totalPacients = pacientDAO.getAll();
        if(totalPacients.size() == 0)
            onView(withId(R.id.pacients_list)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
    }

    @Test
    public void whenClickingTheNewButtonThenNewPacientScreenIsOpened(){
        onView(withId(R.id.new_pacient_button))
                .perform(click());
        onView(withId(R.id.pacient_new_name))
                .check(matches(isDisplayed()));
    }

}
