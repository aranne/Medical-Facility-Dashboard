package edu.ncsu.csc.model;

import java.util.Objects;

public class MedicalFacility {
  private Integer facilityId;
  private String name;
  private String classification;
  private String address;
  private String capacity;

  public MedicalFacility(){


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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    MedicalFacility that = (MedicalFacility) o;
    return facilityId.equals(that.facilityId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(facilityId);
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