package co.herovitamin.doctorsapp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by kerry on 22/06/17.
 */

@Entity
public class Pacient {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "age")
    private int age;
    @ColumnInfo(name = "gender")
    private boolean gender;
    @ColumnInfo(name = "isHavingMigraine")
    private boolean isHavingMigraine;
    @ColumnInfo(name = "isDoingDrugs")
    private boolean isDoingDrugs;

    @Ignore
    public Pacient() {
        name = "-";
        age = 0;
        gender = false;
        isHavingMigraine = false;
        isDoingDrugs = false;
    }

    public Pacient(String name, int age, boolean gender, boolean isHavingMigraine, boolean isDoingDrugs) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.isHavingMigraine = isHavingMigraine;
        this.isDoingDrugs = isDoingDrugs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean isValid(){
        if(getName().length() > 0 && getAge() > 0)
            return true;
        return false;
    }
}