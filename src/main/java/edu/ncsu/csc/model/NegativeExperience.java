package edu.ncsu.csc.model;

import java.util.Date;

public class NegativeExperience {
    private int id;
    private String nagativeCode;
    private String discription;
    private Date time;
    private Date dob;
    private String lastName;

    public NegativeExperience(int id, String nagativeCode, String discription, Date time, Date dob, String lastName) {
        this.id = id;
        this.nagativeCode = nagativeCode;
        this.discription = discription;
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

    public String getNagativeCode() {
        return nagativeCode;
    }

    public void setNagativeCode(String nagativeCode) {
        this.nagativeCode = nagativeCode;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
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
