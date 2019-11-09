package edu.ncsu.csc.model;

import java.util.Date;

public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String phone;
    private String addrCountry;
    private String addrState;
    private int addrZip;
    private String priorityStatus;
    private Date treatmentDate;

    public Patient() {
    }

    public Patient(int id, String firstName, String lastName, Date dob, String phone, String addrCountry, String addrState, int addrZip, String priorityStatus, Date treatmentDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phone = phone;
        this.addrCountry = addrCountry;
        this.addrState = addrState;
        this.addrZip = addrZip;
        this.priorityStatus = priorityStatus;
        this.treatmentDate = treatmentDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddrCountry() {
        return addrCountry;
    }

    public void setAddrCountry(String addrCountry) {
        this.addrCountry = addrCountry;
    }

    public String getAddrState() {
        return addrState;
    }

    public void setAddrState(String addrState) {
        this.addrState = addrState;
    }

    public int getAddrZip() {
        return addrZip;
    }

    public void setAddrZip(int addrZip) {
        this.addrZip = addrZip;
    }

    public String getPriorityStatus() {
        return priorityStatus;
    }

    public void setPriorityStatus(String priorityStatus) {
        this.priorityStatus = priorityStatus;
    }

    public Date getTreatmentDate() {
        return treatmentDate;
    }

    public void setTreatmentDate(Date treatmentDate) {
        this.treatmentDate = treatmentDate;
    }
}
