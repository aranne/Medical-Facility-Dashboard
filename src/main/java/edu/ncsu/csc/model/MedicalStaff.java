package edu.ncsu.csc.model;

import java.util.Date;

public class MedicalStaff {
    private Integer employeeId;
    private String name;
    private String designation;
    private Date hireDate;

    public MedicalStaff() {
    }

    public MedicalStaff(Integer employeeId, String name, String designation, Date hireDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.designation = designation;
        this.hireDate = hireDate;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
