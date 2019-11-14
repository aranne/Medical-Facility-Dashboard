package edu.ncsu.csc.model;

import java.util.Date;

public class Vital {
    private int id;
    private String lastName;
    private Date dob;
    private float temperature;
    private float bloodPressureSystolic;
    private float bloodPressureDiastolic;

    public Vital() {
    }

    public Vital(int id, String lastName, Date dob, float temperature, float bloodPressureSystolic, float bloodPressureDiastolic) {
        this.id = id;
        this.lastName = lastName;
        this.dob = dob;
        this.temperature = temperature;
        this.bloodPressureSystolic = bloodPressureSystolic;
        this.bloodPressureDiastolic = bloodPressureDiastolic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getBloodPressureSystolic() {
        return bloodPressureSystolic;
    }

    public void setBloodPressureSystolic(float bloodPressureSystolic) {
        this.bloodPressureSystolic = bloodPressureSystolic;
    }

    public float getBloodPressureDiastolic() {
        return bloodPressureDiastolic;
    }

    public void setBloodPressureDiastolic(float bloodPressureDiastolic) {
        this.bloodPressureDiastolic = bloodPressureDiastolic;
    }
}
