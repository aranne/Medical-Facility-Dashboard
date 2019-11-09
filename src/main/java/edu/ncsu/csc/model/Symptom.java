package edu.ncsu.csc.model;

public class Symptom {
    private String name;
    private String symCode;

    public Symptom() {
    }

    public Symptom(String name, String symCode) {
        this.name = name;
        this.symCode = symCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymCode() {
        return symCode;
    }

    public void setSymCode(String symCode) {
        this.symCode = symCode;
    }
}
