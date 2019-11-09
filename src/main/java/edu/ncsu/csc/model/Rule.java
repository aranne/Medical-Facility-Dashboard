package edu.ncsu.csc.model;

public class Rule {
    private int id;
    private String bodyCode;
    private String symCode;
    private int scaleLow;
    private int scaleHigh;

    public Rule() {
    }

    public Rule(int id, String bodyCode, String symCode, int scaleLow, int scaleHigh) {
        this.id = id;
        this.bodyCode = bodyCode;
        this.symCode = symCode;
        this.scaleLow = scaleLow;
        this.scaleHigh = scaleHigh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBodyCode() {
        return bodyCode;
    }

    public void setBodyCode(String bodyCode) {
        this.bodyCode = bodyCode;
    }

    public String getSymCode() {
        return symCode;
    }

    public void setSymCode(String symCode) {
        this.symCode = symCode;
    }

    public int getScaleLow() {
        return scaleLow;
    }

    public void setScaleLow(int scaleLow) {
        this.scaleLow = scaleLow;
    }

    public int getScaleHigh() {
        return scaleHigh;
    }

    public void setScaleHigh(int scaleHigh) {
        this.scaleHigh = scaleHigh;
    }
}
