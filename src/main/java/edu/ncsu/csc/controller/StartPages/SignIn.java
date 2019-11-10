package edu.ncsu.csc.controller.StartPages;

import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.DAO.PatientDAOImp;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;
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
      /* Add facility to relation table only if patient goes to this facility for the first time. */
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

  public static void signInAsStaff() {

  }

  public static void goBack() {
    display();
  }
}
