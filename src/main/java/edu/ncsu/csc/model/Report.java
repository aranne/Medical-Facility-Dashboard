package edu.ncsu.csc.model;

import java.util.Date;

public class Report {
  private Date time;
  private Date dob;
  private String name;
  private String dischargeStatus;
  private String treatment;
  private int facilityId;
  private int employeeId;

  public Report() {
  }

  public Report(Date time, Date dob, String name, String dischargeStatus, String treatment, int facilityId, int employeeId) {
    this.time = time;
    this.dob = dob;
    this.name = name;
    this.dischargeStatus = dischargeStatus;
    this.treatment = treatment;
    this.facilityId = facilityId;
    this.employeeId = employeeId;
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

  public String getDischargeStatus() {
    return dischargeStatus;
  }

  public void setDischargeStatus(String dischargeStatus) {
    this.dischargeStatus = dischargeStatus;
  }

  public String getTreatment() {
    return treatment;
  }

  public void setTreatment(String treatment) {
    this.treatment = treatment;
  }

  public int getFacilityId() {
    return facilityId;
  }

  public void setFacilityId(int facilityId) {
    this.facilityId = facilityId;
  }

  public int getEmployeeId() {
    return employeeId;
  }

  public void setEmployeeId(int employeeId) {
    this.employeeId = employeeId;
  }
}
