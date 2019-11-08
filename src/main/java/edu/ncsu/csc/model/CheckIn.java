package edu.ncsu.csc.model;

public class CheckIn {
    private String name;
    private Date dob;
    private Date startTime;
    private Date endTime;

    public CheckIn(){

    }

    public CheckIn(String name, Date dob, Date startTime, Date endTime) {
        this.name = name;
        this.dob = dob;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

