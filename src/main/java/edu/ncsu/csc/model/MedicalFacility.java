package edu.ncsu.csc.model;

public class MedicalFacility {
    private Integer facilityId;
    private String name;
    private String classification;
    private String address;
    private String capacity;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public MedicalFacility(Integer facilityId, String name, String classification, String address, String capacity) {
        this.facilityId = facilityId;
        this.name = name;
        this.classification = classification;
        this.address = address;
        this.capacity = capacity;
    }
}