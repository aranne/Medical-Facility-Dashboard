package edu.ncsu.csc.model;

public class Patient {
    private String name;
    private Date dob;
    private String phone;
    private String addressCountry;
    private String addressState;
    private String addressCity;
    private String addressStreet;
    private String addressNumber;
    private String priorityStatus;
    private Boolean onList;

    public Patient() {

    }

    public Patient(String name, Date dob, String phone, String addressCountry, String addressState, String addressCity, String addressStreet, String addressNumber, String priorityStatus, Boolean onList) {
        this.name = name;
        this.dob = dob;
        this.phone = phone;
        this.addressCountry = addressCountry;
        this.addressState = addressState;
        this.addressCity = addressCity;
        this.addressStreet = addressStreet;
        this.addressNumber = addressNumber;
        this.priorityStatus = priorityStatus;
        this.onList = onList;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressCountry() {
        return addressCountry;
    }

    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressStreet() {
        return addressStreet;
    }

    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public String getPriorityStatus() {
        return priorityStatus;
    }

    public void setPriorityStatus(String priorityStatus) {
        this.priorityStatus = priorityStatus;
    }

    public Boolean getOnList() {
        return onList;
    }

    public void setOnList(Boolean onList) {
        this.onList = onList;
    }
}