package edu.ncsu.csc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String phone;
    private String addrCountry;
    private String addrState;
    private String addrCity;
    private String addrStreet;
    private int addrZip;
    private String priorityStatus;
    private Date treatmentDate;

    /* a patient has many facilities */
    private List<MedicalFacility> facilities;

    public Patient() {
    }
    public Patient(String firstName, String lastName, Date dob, String phone, String addrCountry, String addrState, String addrCity, String addrStreet, int addrZip) {
        this.id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phone = phone;
        this.addrCountry = addrCountry;
        this.addrState = addrState;
        this.addrCity = addrCity;
        this.addrStreet = addrStreet;
        this.addrZip = addrZip;
        this.priorityStatus = null;
        this.treatmentDate = null;
        facilities = new ArrayList<>();
    }
    public Patient(int id, String firstName, String lastName, Date dob, String phone, String addrCountry, String addrState, String addrCity, String addrStreet, int addrZip, String priorityStatus, Date treatmentDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phone = phone;
        this.addrCountry = addrCountry;
        this.addrState = addrState;
        this.addrCity = addrCity;
        this.addrStreet = addrStreet;
        this.addrZip = addrZip;
        this.priorityStatus = priorityStatus;
        this.treatmentDate = treatmentDate;
        facilities = new ArrayList<>();
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

    public String getAddrCity() {
        return addrCity;
    }

    public void setAddrCity(String addrCity) {
        this.addrCity = addrCity;
    }

    public String getAddrStreet() {
        return addrStreet;
    }

    public void setAddrStreet(String addrStreet) {
        this.addrStreet = addrStreet;
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

    public void addFacility(MedicalFacility f) {
        facilities.add(f);
    }

    public List<MedicalFacility> getFacilities() {
        return facilities;
    }

    public String toString() {
        return firstName + lastName;
    }
}
