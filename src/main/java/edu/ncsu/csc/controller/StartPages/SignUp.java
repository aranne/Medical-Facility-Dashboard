package edu.ncsu.csc.controller.StartPages;

import edu.ncsu.csc.DAO.PatientDAOImp;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.view.StartPages.Home;

public class SignUp {
  public static void signUp(Patient p) {
    PatientDAOImp patientDAO = new PatientDAOImp();
    patientDAO.addPatient(p);
    System.out.println("Sign up successfully, please login");
    Home.display();
  }

  public static void goBack() {

  }

}
