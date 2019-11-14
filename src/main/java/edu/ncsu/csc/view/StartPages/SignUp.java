package edu.ncsu.csc.view.StartPages;

import edu.ncsu.csc.controller.StartPages.UserManager;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.util.Date;


public class SignUp extends BasePage implements PageView {


  private MedicalFacility facility;
  UserManager um;
  public SignUp(MedicalFacility facility) {
    super();
    menueStrs.add("Sign up");
    menueStrs.add("Go Back");
    pageTitle = "==================== SIGN UP ====================";
    choicePrompt = "input your choice:";
    this.facility = facility;
    um=new UserManager();
  }

    public void display() {
        running = true;
        while (running) {
            initPage();
            switch (getChoice(menueStrs)) {
                case 1:
                  if (doSignUp()) {
                    show("Sign up successfully, please login");
                    running = false;
                  } else {
                    show("Failed to Sign, please try it again");
                  }
                    break;
                default:
                    running = false;
                    break;
            }
        }
    }

    private boolean doSignUp() {
        String firstName = getStringFromInput("A. First Name");
        String lastName = getStringFromInput("B. Last Name");
        Date dob = getDateFromInput("C. Date of Birth in format mm/dd/yyyy");
        String addrStreet = getStringFromInput("D. Street of address");
        String addrCity = getStringFromInput("D. City of address");
        String addrState = getStringFromInput("D. State of address");
        String addrCountry = getStringFromInput("D. Country of address");
        int addrZip = getNum("D. Zip of address");
        String phone = getPhoneFromInput("E. Phone Number");
        return um.signUp(firstName, lastName, dob, addrStreet, addrCity, addrState, addrCountry, addrZip, phone);
    }
}
