package edu.ncsu.csc.model;

public class PatientSymptom {
  String symCode;
  String scale;

  public PatientSymptom(String symCode, String scale) {
    this.symCode = symCode;
    this.scale = scale;
  }

  public String getSymCode() {
    return symCode;
  }

  public void setSymCode(String symCode) {
    this.symCode = symCode;
  }

  public String getScale() {
    return scale;
  }

  public void setScale(String scale) {
    this.scale = scale;
  }

  public boolean compare(PatientSymptom patientSymptom) {
    if (this.symCode.equals(patientSymptom.symCode) && this.scale.equals(patientSymptom.scale))
      return true;
    return false;
  }
}
