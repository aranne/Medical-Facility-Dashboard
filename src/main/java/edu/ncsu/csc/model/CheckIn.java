package edu.ncsu.csc.model;

import java.util.Date;

public class CheckIn implements Comparable<CheckIn> {
    private Integer id;
    private String lastName;
    private Date dob;
    private Date startTime;
    private Date endTime;
    private Integer facilityId;
    private Integer priority;

    public CheckIn() {

    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public CheckIn(Integer id, String lastName, Date dob, Date startTime, Date endTime, Integer facilityId, Integer priority) {
        this.id = id;
        this.lastName = lastName;
        this.dob = dob;
        this.startTime = startTime;
        this.endTime = endTime;
        this.facilityId = facilityId;
        this.priority = priority;
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

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    @Override
    public int compareTo(CheckIn checkIn) {
        long thisDuration = this.endTime.getTime() - this.startTime.getTime();
        long thatDuration = checkIn.endTime.getTime() - checkIn.startTime.getTime();
        return (int) thisDuration - (int) thatDuration;
    }
}