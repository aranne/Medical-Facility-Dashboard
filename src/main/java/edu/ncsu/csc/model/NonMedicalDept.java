package edu.ncsu.csc.model;

public class NonMedicalDept {
    private String deptCode;
    private String name;

    public NonMedicalDept() {
    }

    public NonMedicalDept(String deptCode) {
        this.deptCode = deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getName() {
        return name;
    }
}
