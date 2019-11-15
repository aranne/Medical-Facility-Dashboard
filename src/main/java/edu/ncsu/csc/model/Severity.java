package edu.ncsu.csc.model;

public class Severity {
    private int id;
//    value: 0 is normal, 1 is high, 2 is Quarantine
    private int value;
    private String name;
    private String scale;

    public Severity() {
    }

    @Override
    public String toString() {
        return "Severity{" +
            "value=" + value +
            ", name='" + name + '\'' +
            ", scale='" + scale + '\'' +
            '}';
    }

    public Severity(int id, int value, String name, String scale) {
        this.id = id;
        this.value = value;
        this.name = name;
        this.scale = scale;
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

}
