package edu.ncsu.csc.controller.StartPages;

import edu.ncsu.csc.DAO.*;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.model.Staff;

import java.util.Date;

public class UserManager {

    public UserManager(){

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
        TemplateDAO<Patient> patientDAO = new PatientDAOImp();
        return patientDAO.addOneValue(p);
    }

    public Patient signInAsPatient(int facilityId, String lastName, Date dob, String city) {
        PatientDAOImp patientDAO = new PatientDAOImp();
        Patient p =null;
        p= patientDAO.patientExist(lastName,dob);
        if (p == null || !p.getAddrCity().equals(city)) {
            return null;
        } else {
            //Register to facility o
            if(!patientDAO.patientInFacility(facilityId,p)){
                if(!patientDAO.registerToFacility(facilityId,p)){
                    p=null;
                }
            }
            return p;
        }
    }

    public Staff signInAsStaff(int facilityId, String lastName, Date dob) {
        StaffDAOImp staffDao = new StaffDAOImp();
        Staff staff = null;
        staff= staffDao.getStaffByNameAndDob(lastName,dob);
        if(staff!=null)
        {
            if(!staffDao.staffInFacility(facilityId,staff)) {
                staff=null;
            }
        }
        return staff;
    }
}
