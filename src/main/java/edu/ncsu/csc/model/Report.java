package edu.ncsu.csc.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Report {
    private int id;
    private Date time;
    private Date dob;
    private String lastName;
    private String dischargeStatus;
    private String treatment;
    private int facilityId;
    private int employeeId;
    private int referrerId;
    private int referFacilityId;
    private String reason;

    public int getReferrerId() {
        return referrerId;
    }

    public void setReferrerId(int referrerId) {
        this.referrerId = referrerId;
    }

    public int getReferFacilityId() {
        return referFacilityId;
    }

    public void setReferFacilityId(int referFacilityId) {
        this.referFacilityId = referFacilityId;
    }

    private ReferralStatus referralStatus;
    private List<NegativeExperience> nagexps=new ArrayList<NegativeExperience>();
    public Report() {
    }


    public Report(int id, Date time, Date dob, String lastName, String dischargeStatus, String treatment, int facilityId, int employeeId, String reason, int referrerId, int referFacilityId) {
        this.id = id;
        this.time = time;
        this.dob = dob;
        this.lastName = lastName;
        this.dischargeStatus = dischargeStatus;
        this.treatment = treatment;
        this.facilityId = facilityId;
        this.employeeId = employeeId;
        this.reason = reason;
        this.referrerId = referrerId;
        this.referFacilityId = referFacilityId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDischargeStatus() {
        return dischargeStatus;
    }

    public void setDischargeStatus(String dischargeStatus) {
        this.dischargeStatus = dischargeStatus;
    }

    public String getTreatment() {
        return treatment;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public ReferralStatus getReferralStatus() {
        return referralStatus;
    }

    public void setReferralStatus(ReferralStatus referralStatus) {
        this.referralStatus = referralStatus;
    }

    public List<NegativeExperience> getNagexps() {
        return nagexps;
    }

    public void setNagexps(List<NegativeExperience> nagexps) {
        this.nagexps = nagexps;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
