package co.herovitamin.doctorsapp.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kerry on 22/06/17.
 */

public class PacientTest {

    Pacient pacient;

    @Before
    public void setUp(){
        pacient = new Pacient();
    }

    @Test
    public void ifNewNameValueIsEmptyThenDontSetValue(){
        String newNameValue = "";
        pacient.setName(newNameValue);
        assertTrue("Name value was empty", pacient.getName() != newNameValue);
    }

    @Test
    public void ifAgeIsLessThanZeroThenDontSetValue(){
        int newAgeValue = -10;
        pacient.setAge(newAgeValue);
        assertTrue("Age value was less than zero", pacient.getAge() != newAgeValue);
    }

}