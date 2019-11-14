package edu.ncsu.csc.controller.CheckoutPages;

import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.DAO.ReportDAOImp;
import edu.ncsu.csc.DAO.ServiceDAOImp;
import edu.ncsu.csc.DAO.StaffDAOImp;
import edu.ncsu.csc.DAO.TemplateDAO;
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
        staffs=staffdao.getWorkmates(checkouter);
    }
    public List<String> getStaffMenu() {
        List<String> choices = new ArrayList<String>(0);
        for (int i = 0; i < staffs.size(); i++) {
            choices.add(String.valueOf(staffs.get(i).getEmployeeId()));
        }
        return choices;
    }

    public Staff getStaffSelection(int index) {
        return staffs.get(index);
    }

    public List<String> getFacilityMenu() {
        List<String> choices = new ArrayList<String>(0);
        for (int i = 0; i < facilities.size(); i++) {
            choices.add(facilities.get(i).getName());
        }
        return choices;
    }

    public MedicalFacility getFacilitySelection(int index) {
        return facilities.get(index);
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

    public boolean submit(Report report) {
    	ReportDAOImp repdao=new ReportDAOImp();
        return repdao.addOneValue(report);
    }
}
