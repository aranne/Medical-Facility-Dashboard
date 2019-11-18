package edu.ncsu.csc.model;

import java.util.Date;

public class PatientSymMeta {
    private String bodyCode;
    private String symCode;
    private String scale;
    private String lastName;
    private Date dob;
    private String duration;
    private String causeIncident;
    private boolean firstOccurrence;

    public PatientSymMeta(String bodyCode, String symCode, String scale, String lastName, Date dob, String duration, String causeIncident, boolean firstOccurrence) {
        this.bodyCode = bodyCode;
        this.symCode = symCode;
        this.scale = scale;
        this.lastName = lastName;
        this.dob = dob;
        this.duration = duration;
        this.causeIncident = causeIncident;
        this.firstOccurrence = firstOccurrence;
    }

    public String getBodyCode() {
        return bodyCode;
    }

    public void setBodyCode(String bodyCode) {
        this.bodyCode = bodyCode;
    }

    public String getSymCode() {
        return symCode;
    }

    public void setSymCode(String symCode) {
        this.symCode = symCode;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCauseIncident() {
        return causeIncident;
    }

    public void setCauseIncident(String causeIncident) {
        this.causeIncident = causeIncident;
    }

    public boolean isFirstOccurrence() {
        return firstOccurrence;
    }

    public void setFirstOccurrence(boolean firstOccurrence) {
        this.firstOccurrence = firstOccurrence;
    }
}
