package edu.ncsu.csc.model;

import java.sql.Timestamp;
import java.util.Date;

public class Reason {
    private int id;
    private String reasonCode;
    private String description;
    private String serviceCode;
    private Date time;
    private Date dob;
    private String lastName;

    public Reason() {
    }

    public Reason(int id, String reasonCode, String description, String serviceCode, Date time, Date dob, String lastName) {
        this.id = id;
        this.reasonCode = reasonCode;
        this.description = description;
        this.serviceCode = serviceCode;
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

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
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
