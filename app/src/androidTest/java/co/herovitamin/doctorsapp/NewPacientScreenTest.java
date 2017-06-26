package co.herovitamin.doctorsapp;

import android.arch.persistence.room.Room;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import co.herovitamin.doctorsapp.database.PacientDAO;
import co.herovitamin.doctorsapp.database.PacientDatabase;
import co.herovitamin.doctorsapp.matcher.ErrorMatcher;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by kerry on 25/06/17.
 */

@RunWith(AndroidJUnit4.class)
public class NewPacientScreenTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);
    private PacientDatabase db;
    private PacientDAO pacientDAO;

    @Before
    public void init(){
        db = Room.databaseBuilder(mMainActivityActivityTestRule.getActivity(), PacientDatabase.class, "database-name").build();
        pacientDAO = db.pacientDAO();
    }

    @Before
    public void changeToNewScreen(){
        onView(withId(R.id.new_pacient_button)).perform(click());

    }

    @Test
    public void whenSavingValuetoDatabaseThenListIsShown(){
        onView(withId(R.id.pacient_new_name)).perform(click());
        onView(withId(R.id.pacient_new_name)).perform(typeText("Foo Bar"));
        onView(withId(R.id.pacient_new_age)).perform(click());
        onView(withId(R.id.pacient_new_age)).perform(typeText("10"));
        onView(withId(R.id.pacient_new_age)).perform(closeSoftKeyboard());
        onView(withId(R.id.new_pacient_save)).perform(click());
        onView(withId(R.id.pacients_list)).check(matches(isDisplayed()));
    }

    @Test
    public void whenNameIsInvalidThenShowError(){
        onView(withId(R.id.pacient_new_name)).perform(click());
        onView(withId(R.id.pacient_new_name)).perform(typeText(""));
        onView(withId(R.id.pacient_new_name)).perform(closeSoftKeyboard());
        onView(withId(R.id.new_pacient_save)).perform(click());
        onView(withId(R.id.name_container)).check(matches(
                ErrorMatcher.TextInputLayoutErrorMatcher.withErrorName(equalTo(mMainActivityActivityTestRule.getActivity().getString(R.string.error_name_message))))
        );
    }

    @Test
    public void whenAgeIsInvalidThenShowError(){
        onView(withId(R.id.pacient_new_age)).perform(click());
        onView(withId(R.id.pacient_new_age)).perform(typeText(""));
        onView(withId(R.id.pacient_new_age)).perform(closeSoftKeyboard());
        onView(withId(R.id.new_pacient_save)).perform(click());
        onView(withId(R.id.age_container)).check(matches(
                ErrorMatcher.TextInputLayoutErrorMatcher.withErrorName(equalTo(mMainActivityActivityTestRule.getActivity().getString(R.string.error_age_message))))
        );
    }

}