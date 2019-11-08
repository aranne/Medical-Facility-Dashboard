package edu.ncsu.csc.model;

public class Severity {
    private Integer value;
    private String name;
    private String scale;

    public Severity() {

    }

    public Severity(Integer value, String name, String scale) {
        this.value = value;
        this.name = name;
        this.scale = scale;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
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
}
