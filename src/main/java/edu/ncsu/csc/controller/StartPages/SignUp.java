package edu.ncsu.csc.controller.StartPages;

import edu.ncsu.csc.DAO.PatientDAOImp;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.view.StartPages.Home;

import java.util.Date;

public class SignUp {
  public static void signUp(String firstName, String lastName, Date dob, String addrStreet, String addrCity, String addrState, String addrCountry, int addrZip, String phone) {
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
    PatientDAOImp patientDAO = new PatientDAOImp();
    patientDAO.addPatient(p);
    System.out.println("Sign up successfully, please login");
    Home.display();
  }

  public static void goBack() {

  }

}
