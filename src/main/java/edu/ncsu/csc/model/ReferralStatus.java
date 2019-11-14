package edu.ncsu.csc.model;

import java.util.List;

public class ReferralStatus {
    private MedicalFacility facility;
    private Staff staff;
    List<Reason> reasons;
    public MedicalFacility getFacility() {
        return facility;
    }

    public void setFacility(MedicalFacility facility) {
        this.facility = facility;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public List<Reason> getReasons() {
        return reasons;
    }

    public void setReasons(List<Reason> reasons) {
        this.reasons = reasons;
    }
}
