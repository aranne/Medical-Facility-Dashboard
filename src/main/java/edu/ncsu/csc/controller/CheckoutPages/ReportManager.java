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
    }
    public List<String> getStaffMenu(int facilityId) {
        List<String> choices = new ArrayList<String>(0);
        StaffDAOImp staffDao=new StaffDAOImp();
        staffs = staffDao.getAllValues();
        for (int i = 0; i < staffs.size(); i++) {
            if (staffDao.staffInFacility(facilityId, staffs.get(i))) {
                choices.add((staffs.get(i).getEmployeeId() )
                        + " " + staffs.get(i).getLastName());
            }
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

    public boolean addOneValueWithoutRefer(Report report) {
        ReportDAOImp repdao = new ReportDAOImp();
        return repdao.addOneValueWithoutRefer(report);
    }

    public boolean submitReason(List<Reason> reasons) {
        ReasonDAOImp reasondao = new ReasonDAOImp();
        for (Reason reason : reasons) {
            reasondao.addOneValue(reason);
        }
        return true;
    }

    public boolean submitNegativeExperience(List<NegativeExperience> negas) {
        NegativeExpeDAOImp negadao = new NegativeExpeDAOImp();
        for (NegativeExperience nega : negas) {
            negadao.addOneValue(nega);
        }
        return true;
    }
}
