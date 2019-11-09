package edu.ncsu.csc.model;

public class ServiceDept {
    private String deptCode;
    private String name;
    private boolean isMedical;

    public ServiceDept() {
    }

    public ServiceDept(String deptCode, String name, boolean isMedical) {
        this.deptCode = deptCode;
        this.name = name;
        this.isMedical = isMedical;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isMedical() {
        return isMedical;
    }

    public void setMedical(boolean medical) {
        isMedical = medical;
    }
}
