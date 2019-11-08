package edu.ncsu.csc.model;

import java.util.Date;

public class Reason {
  private String reasonCode;
  private String description;
  private String serviceCode;
  private Date time;
  private Date dob;
  private String name;

  public Reason() {
  }

  public Reason(String reasonCode, String description, String serviceCode, Date time, Date dob, String name) {
    this.reasonCode = reasonCode;
    this.description = description;
    this.serviceCode = serviceCode;
    this.time = time;
    this.dob = dob;
    this.name = name;
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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
