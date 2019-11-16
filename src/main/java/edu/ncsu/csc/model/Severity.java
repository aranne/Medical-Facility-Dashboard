package edu.ncsu.csc.model;

public class Severity {
    private int id;
//    value: 0 is normal, 1 is high, 2 is Quarantine
    private int priority;
    private String name;
    private String scale;

    public Severity() {
    }

    @Override
    public String toString() {
        return "Severity{" +
            "priority: " + priority +
            ", name code: '" + name + '\'' +
            ", scale: '" + scale + '\'' +
            '}';
    }

    public Severity(int id, int priority, String name, String scale) {
        this.id = id;
        this.priority = priority;
        this.name = name;
        this.scale = scale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
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
