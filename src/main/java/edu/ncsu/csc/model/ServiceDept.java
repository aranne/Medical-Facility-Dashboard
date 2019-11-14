package edu.ncsu.csc.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceDept that = (ServiceDept) o;
        return deptCode.equals(that.deptCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptCode);
    }
}
