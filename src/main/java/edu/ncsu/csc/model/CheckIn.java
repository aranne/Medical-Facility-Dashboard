package edu.ncsu.csc.model;

import java.util.Date;

public class CheckIn {
    private Integer id;
    private String lastName;
    private Date dob;
    private Date startTime;
    private Date endTime;

    public CheckIn(){

    }

    public CheckIn(Integer id, String lastName, Date dob, Date startTime, Date endTime) {
        this.id = id;
        this.lastName = lastName;
        this.dob = dob;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}