package co.herovitamin.doctorsapp.model;

/**
 * Created by kerry on 22/06/17.
 */

public class Pacient {

    private String name;
    private int age;
    private boolean gender;
    private boolean isHavingMigraine;
    private boolean isDoingDrugs;

    public Pacient() {
        name = "-";
        age = 0;
        gender = false;
        isHavingMigraine = false;
        isDoingDrugs = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name.isEmpty())
            return;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age < 0)
            return;
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public boolean isHavingMigraine() {
        return isHavingMigraine;
    }

    public void setHavingMigraine(boolean havingMigraine) {
        isHavingMigraine = havingMigraine;
    }

    public boolean isDoingDrugs() {
        return isDoingDrugs;
    }

    public void setDoingDrugs(boolean doingDrugs) {
        isDoingDrugs = doingDrugs;
    }
}