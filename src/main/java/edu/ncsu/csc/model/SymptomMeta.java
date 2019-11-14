package edu.ncsu.csc.model;

public class SymptomMeta {
    private float duration;

    private Boolean neworre;
    private String incident;
    private Severity severity;
    private Symptom symptom;
    private BodyPart bodypart;

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public Boolean getNeworre() {
        return neworre;
    }

    public void setNeworre(Boolean neworre) {
        this.neworre = neworre;
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

    public BodyPart getBodypart() {
        return bodypart;
    }

    public void setBodypart(BodyPart bodypart) {
        this.bodypart = bodypart;
    }

}
