package edu.ncsu.csc.controller.StartPages;

import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.DAO.PatientDAOImp;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;

import java.util.Date;

import static edu.ncsu.csc.view.StartPages.Home.display;

public class SignIn {
  public static void signInAsPatient(int facilityId, String lastName, Date dob, String city) {
    PatientDAOImp patientDao = new PatientDAOImp();
    Patient p = patientDao.getPatientByNameAndDob(lastName, dob);
    if (p == null) {
      System.out.println("Sign in Incorrect, please enter again");
      Home.signIn();
    } else {
      if (!p.getAddrCity().equals(city)) {
        p.setAddrCity(city);
        patientDao.updatePatient(p);
      }
      /* add facility to relation table. */
      MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
      MedicalFacility f = facilityDao.getFacilityById(facilityId);
      p.addFacility(f);
      patientDao.addFacility(p);
      System.out.println("Login successfully\n" + "Thanks for choosing " + f.getName());
      // TODO go into Patient routing menu.
    }
  }

  public static void signInAsStaff() {

  }

  public static void goBack() {
    display();
  }
}
