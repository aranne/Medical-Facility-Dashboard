package edu.ncsu.csc.model;

public class BodyPart {
    private String bodyCode;
    private String bodyName;

    public BodyPart() {

    }

    public BodyPart(String bodyCode, String bodyName) {
        this.bodyCode = bodyCode;
        this.bodyName = bodyName;
    }

    public String getBodyCode() {
        return bodyCode;
    }

    public void setBodyCode(String bodyCode) {
        this.bodyCode = bodyCode;
    }

    public String getBodyName() {
        return bodyName;
    }

    public void setBodyName(String bodyName) {
        this.bodyName = bodyName;
    }
}