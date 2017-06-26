package co.herovitamin.doctorsapp.model;

/**
 * Created by kerry on 25/06/17.
 */

public class Predictor {

    public static int predict(int age, boolean isHavingMigraine, boolean isDoingDrugs, boolean gender){
        int tmp = 0;
        if(isHavingMigraine)
            tmp += 25;
        if (age < 15 )
            tmp += 25;
        if(isDoingDrugs)
            tmp += 25;
        if(gender)
            tmp += 25;
        return tmp;
    }

}
