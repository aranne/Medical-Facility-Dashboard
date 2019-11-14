package edu.ncsu.csc.controller.StartPages;

import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.DAO.PatientDAOImp;
import edu.ncsu.csc.DAO.StaffDAOImp;
import edu.ncsu.csc.DAO.TemplateDAO;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.model.ServiceDept;
import edu.ncsu.csc.model.Staff;
import edu.ncsu.csc.view.PatientPages.Routing;
import edu.ncsu.csc.view.StartPages.Home;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserManager {

    public UserManager(){

    }
    public void reLoad(){
        TemplateDAO tdao=new MedicalFacilityDAOImp();
        facilities=tdao.getAllValues();
    }
    private List<MedicalFacility> facilities;

    public List<String> getFacilityMenu(){
        List<String> choices = new ArrayList<String>(0);
        for(int i=0;i<facilities.size();i++)
        {
            choices.add(facilities.get(i).getName());
        }
        return choices;
    }
    public boolean signUp(String firstName, String lastName, Date dob, String addrStreet, String addrCity, String addrState, String addrCountry, int addrZip, String phone) {
        Patient p = new Patient();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setDob(dob);
        p.setAddrStreet(addrStreet);
        p.setAddrCity(addrCity);
        p.setAddrState(addrState);
        p.setAddrCountry(addrCountry);
        p.setAddrZip(addrZip);
        p.setPhone(phone);
        TemplateDAO patientDAO = new PatientDAOImp();
        return patientDAO.addOneValue(p);
    }

    public boolean signInAsPatient(int facilityId, String lastName, Date dob, String city) {
        TemplateDAO patientDAO = new PatientDAOImp();
        Patient p = (Patient) patientDAO.getOneByQuery("last_name = '"+lastName+"' and dob = '"+dob.toString()+"'");
        if (p == null || !p.getAddrCity().equals(city)) {
            return false;
//            System.out.println("Sign in Incorrect, please enter again");
        } else {
            /* Register to facility only if patient goes to this facility for the first time. */
//            MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
//            MedicalFacility f = facilityDao.getFacilityById(facilityId);
//            List<MedicalFacility> facilities = patientDao.getAllFacility(p);
//            if (!facilities.contains(f)) {
//                p.addFacility(f);
//                patientDao.addFacility(p);
//                System.out.println("Login successfully\n" + "Thanks for choosing " + f.getName());
//            } else {
//                System.out.println("Login successfully\n" + "Welcome to " + f.getName());
//            }
//            /* Display routing menu. */
//            Routing.display(p.getId());
            return true;
        }
    }

    public boolean signInAsStaff(int facilityId, String lastName, Date dob) {
//        StaffDAOImp staffDao = new StaffDAOImp();
//        Staff staff = staffDao.getStaffByNameAndDob(lastName, dob);
//        /* Verify facilityId for this staff in primary and secondary serviceDepts. */
//        List<ServiceDept> depts = staffDao.getAllDepts(staff);
//        MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
//        MedicalFacility facility = facilityDao.getFacilityById(facilityId);
//        List<ServiceDept> facilityDepts = facilityDao.getAllServiceDept(facility);
//        /* Staff's working depts must be in this facility's depts. */
//        boolean isInFacility = false;
//        for (ServiceDept d : depts) {
//            if (facilityDepts.contains(d)) {
//                isInFacility = true;
//                break;
//            }
//        }
//        if (staff == null) {
//            System.out.println("Sign in Incorrect, please enter again");
//            edu.ncsu.csc.controller.StartPages.Home.signIn();
//        } else if (!isInFacility) {
//            System.out.println("You are not working in this facility, please enter again");
//            edu.ncsu.csc.controller.StartPages.Home.signIn();
//        } else {
//            System.out.println("Login successfully\n" + "Welcome to " + facility.getName());
//            // TODO routing to staff menu
//        }
        return false;
    }
}
