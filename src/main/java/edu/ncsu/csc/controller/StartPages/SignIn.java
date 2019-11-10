package edu.ncsu.csc.controller.StartPages;

import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.DAO.PatientDAOImp;
import edu.ncsu.csc.DAO.StaffDAOImp;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.model.ServiceDept;
import edu.ncsu.csc.model.Staff;
import edu.ncsu.csc.view.PatientPages.Routing;

import java.util.Date;
import java.util.List;

import static edu.ncsu.csc.view.StartPages.Home.display;

public class SignIn {
  public static void signInAsPatient(int facilityId, String lastName, Date dob, String city) {
    PatientDAOImp patientDao = new PatientDAOImp();
    Patient p = patientDao.getPatientByNameAndDob(lastName, dob);
    if (p == null || !p.getAddrCity().equals(city)) {
      System.out.println("Sign in Incorrect, please enter again");
      Home.signIn();
    } else {
      /* Register to facility only if patient goes to this facility for the first time. */
      MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
      MedicalFacility f = facilityDao.getFacilityById(facilityId);
      List<MedicalFacility> facilities = patientDao.getAllFacility(p);
      if (!facilities.contains(f)) {
        p.addFacility(f);
        patientDao.addFacility(p);
        System.out.println("Login successfully\n" + "Thanks for choosing " + f.getName());
      } else {
        System.out.println("Login successfully\n" + "Welcome back to " + f.getName());
      }
      /* Display routing menu. */
      Routing.display(p.getId());
    }
  }

  public static void signInAsStaff(int facilityId, String lastName, Date dob) {
    StaffDAOImp staffDao = new StaffDAOImp();
    Staff staff = staffDao.getStaffByNameAndDob(lastName, dob);
    /* Verify facilityId for this staff in primary and secondary serviceDepts. */
    List<ServiceDept> depts = staffDao.getAllDepts(staff);
    MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
    MedicalFacility facility = facilityDao.getFacilityById(facilityId);
    List<ServiceDept> facilityDepts = facilityDao.getAllServiceDept(facility);
    /* Staff's working depts must be in this facility's depts. */
    boolean isInFacility = false;
    for (ServiceDept d: depts) {
      if (facilityDepts.contains(d)) {
        isInFacility = true;
        break;
      }
    }
    if (staff == null) {
      System.out.println("Sign in Incorrect, please enter again");
      Home.signIn();
    } else if (!isInFacility) {
      System.out.println("You are not working in this facility, please enter again");
      Home.signIn();
    } else {
      System.out.println("Login successfully\n" + "Welcome to " + facility.getName());
      // TODO routing to staff menu
    }
  }

  public static void goBack() {
    display();
  }
}
