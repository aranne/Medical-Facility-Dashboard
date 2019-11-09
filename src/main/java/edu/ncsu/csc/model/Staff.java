package edu.ncsu.csc.model;

import java.util.Date;

public class Staff {
    private int employeeId;
    private String name;
    private boolean isMedical;
    private Date dob;
    private Date hireDate;

    public Staff() {
    }

    public Staff(int employeeId, String name, boolean isMedical, Date dob, Date hireDate) {
        this.employeeId = employeeId;
        this.name = name;
        this.isMedical = isMedical;
        this.dob = dob;
        this.hireDate = hireDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
