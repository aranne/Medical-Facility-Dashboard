package edu.ncsu.csc.model;

import java.util.Date;
import java.util.List;

public class Staff {
    private int employeeId;
    private String firstName;
    private String lastName;
    private boolean isMedical;
    private Date dob;
    private Date hireDate;
    private String primaryDeptCode;

    private List<ServiceDept> secondaryDepts;

    public Staff() {
    }

    public Staff(int employeeId, String firstName, String lastName, boolean isMedical, Date dob, Date hireDate, String primaryDeptCode, List<ServiceDept> secondaryDepts) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isMedical = isMedical;
        this.dob = dob;
        this.hireDate = hireDate;
        this.primaryDeptCode = primaryDeptCode;
        this.secondaryDepts = secondaryDepts;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getPrimaryDeptCode() {
        return primaryDeptCode;
    }

    public void setPrimaryDeptCode(String primaryDeptCode) {
        this.primaryDeptCode = primaryDeptCode;
    }

    public void addSecondaryDept(ServiceDept d) {
        secondaryDepts.add(d);
    }

    public List<ServiceDept> getSecondaryDepts() {
        return secondaryDepts;
    }
}
