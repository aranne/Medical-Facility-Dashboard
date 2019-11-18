package edu.ncsu.csc.controller.CheckoutPages;

import edu.ncsu.csc.DAO.*;
import edu.ncsu.csc.model.*;

import java.util.ArrayList;
import java.util.List;

public class ReportManager {
    private List<Service> services;
    private List<MedicalFacility> facilities;
    private List<Staff> staffs;
    private Staff checkouter;
    private CheckIn checkIn;

    public ReportManager(CheckIn checkIn, Staff checkouter) {
        this.checkouter = checkouter;
        this.checkIn = checkIn;
        reLoad();
    }


    public void reLoad() {
        TemplateDAO<MedicalFacility> tdao = new MedicalFacilityDAOImp();
        facilities = tdao.getAllValues();
        TemplateDAO<Service> tdao1 = new ServiceDAOImp();
        services = tdao1.getAllValues();
        StaffDAOImp staffdao=new StaffDAOImp();
        staffs=staffdao.getReferralList(checkouter);
    }
    public List<String> getStaffMenu() {
        List<String> choices = new ArrayList<String>(0);
        for (int i = 0; i < staffs.size(); i++) {
            choices.add(String.valueOf(staffs.get(i).getEmployeeId() )
                    + " " + staffs.get(i).getLastName());
        }
        return choices;
    }

    public int getStaffSelection(int index) {
        return staffs.get(index - 1).getEmployeeId();
    }

    public List<String> getFacilityMenu() {
        List<String> choices = new ArrayList<String>(0);
        for (int i = 0; i < facilities.size(); i++) {
            choices.add(facilities.get(i).getName());
        }
        return choices;
    }

    public int getFacilitySelection(int index) {
        return facilities.get(index-1).getFacilityId();
    }


    public List<String> getServiceMenu() {
        List<String> choices = new ArrayList<String>(0);
        for (int i = 0; i < services.size(); i++) {
            choices.add(services.get(i).getName());
        }
        return choices;
    }

    public Service getServiceSelection(int index) {
        return services.get(index);
    }

    public boolean submitReport(Report report) {
    	ReportDAOImp repdao = new ReportDAOImp();

        return repdao.addOneValue(report);
    }

    public boolean submitReason(Reason reason) {
        ReasonDAOImp reasondao = new ReasonDAOImp();
        return reasondao.addOneValue(reason);
    }

    public boolean submitNegativeExperience(NegativeExperience nega) {
        NegativeExpeDAOImp negadao = new NegativeExpeDAOImp();
        return negadao.addOneValue(nega);
    }
}
