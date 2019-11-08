package edu.ncsu.csc.model;

public class MedicalFacility {
    private Integer facilityId;
    private String name;
    private String classification;
    private String addressCountry;
    private String addressState;
    private String addressCity;
    private String addressStreet;
    private String addressNumber;

    public MedicalFacility() {

    }

    public MedicalFacility(Integer facilityId, String name, String classification, String addressCountry, String addressState, String addressCity, String addressStreet, String addressNumber) {
        this.facilityId = facilityId;
        this.name = name;
        this.classification = classification;
        this.addressCountry = addressCountry;
        this.addressState = addressState;
        this.addressCity = addressCity;
        this.addressStreet = addressStreet;
        this.addressNumber = addressNumber;
    }

    public Integer getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(Integer facilityId) {
        this.facilityId = facilityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
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
}



