package edu.ncsu.csc.model;
import java.util.Date;

public class NegativeExperience {
    private String negativeCode;
    private String description;
    private Date time;
    private Date dob;
    private String lastName;

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
