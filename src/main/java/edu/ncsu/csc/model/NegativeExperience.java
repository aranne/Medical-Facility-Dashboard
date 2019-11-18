package edu.ncsu.csc.model;

import java.util.Date;

public class NegativeExperience {
    private int id;
    private String negativeCode;
    private String description;
    private Date time;
    private Date dob;
    private String lastName;

    public NegativeExperience(int id, String negativeCode, String description, Date time, Date dob, String lastName) {
        this.id = id;
        this.negativeCode = negativeCode;
        this.description = description;
        this.time = time;
        this.dob = dob;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNegativeCode() {
        return negativeCode;
    }

    public void setNegativeCode(String negativeCode) {
        this.negativeCode = negativeCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
