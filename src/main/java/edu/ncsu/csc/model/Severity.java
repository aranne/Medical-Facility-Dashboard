package edu.ncsu.csc.model;

public class Severity {
    private int id;
    private int value;
    private String name;
    private String scale;
    private String bleeding;

    public Severity() {
    }

    public Severity(int id, int value, String name, String scale, String bleeding) {
        this.id = id;
        this.value = value;
        this.name = name;
        this.scale = scale;
        this.bleeding = bleeding;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getBleeding() {
        return bleeding;
    }

    public void setBleeding(String bleeding) {
        this.bleeding = bleeding;
    }
}
