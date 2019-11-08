package edu.ncsu.csc.model;

public class MedicalDept {
    private String deptCode;
    private String name;

    public MedicalDept() {

    }

    public MedicalDept(String deptCode, String name) {
        this.deptCode = deptCode;
        this.name = name;
    }

    public void setDeptCode(String code) {
         deptCode= code;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
