package edu.ncsu.csc.model;

public class SymptomMeta {
    private String duration;
    private Boolean isFirstTime;
    private String incident;
    private Severity severity;
    private Symptom symptom;
    private BodyPart bodyPart;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Boolean getIsFirstTime() {
        return isFirstTime;
    }

    public void setIsFirstTime(Boolean isFirstTime) {
        this.isFirstTime = isFirstTime;
    }

    public String getIncident() {
        return incident;
    }

    public void setIncident(String incident) {
        this.incident = incident;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Symptom getSymptom() {
        return symptom;
    }

    public void setSymptom(Symptom symptom) {
        this.symptom = symptom;
    }

    public BodyPart getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(BodyPart bodyPart) {
        this.bodyPart = bodyPart;
    }

}
