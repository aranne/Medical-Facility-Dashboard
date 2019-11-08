package edu.ncsu.csc.model;

import java.util.Date;

public class NegativeExperience {
  private String negaCode;
  private String description;
  private Date time;
  private Date dob;
  private String name;

  public NegativeExperience() {
  }

  public NegativeExperience(String negaCode, String description, Date time, Date dob, String name) {
    this.negaCode = negaCode;
    this.description = description;
    this.time = time;
    this.dob = dob;
    this.name = name;
  }

  public String getNegaCode() {
    return negaCode;
  }

  public void setNegaCode(String negaCode) {
    this.negaCode = negaCode;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
