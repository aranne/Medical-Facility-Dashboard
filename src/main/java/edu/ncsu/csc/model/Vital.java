package edu.ncsu.csc.model;

import java.util.Date;

public class Vital {
  private String name;
  private Date dob;
  private float temperature;
  private float bloodPressureSystolic;
  private float bloodPressureDiastolic;

  public Vital() {}


  public Vital(String name, Date dob, float temperature, float bloodPressureSystolic, float bloodPressureDiastolic) {
    this.name = name;
    this.dob = dob;
    this.temperature = temperature;
    this.bloodPressureSystolic = bloodPressureSystolic;
    this.bloodPressureDiastolic = bloodPressureDiastolic;
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

  public float getTemperature() {
    return temperature;
  }

  public void setTemperature(float temperature) {
    this.temperature = temperature;
  }

  public float getBloodPressureSystolic() {
    return bloodPressureSystolic;
  }

  public void setBloodPressureSystolic(float bloodPressureSystolic) {
    this.bloodPressureSystolic = bloodPressureSystolic;
  }

  public float getBloodPressureDiastolic() {
    return bloodPressureDiastolic;
  }

  public void setBloodPressureDiastolic(float bloodPressureDiastolic) {
    this.bloodPressureDiastolic = bloodPressureDiastolic;
  }
}
