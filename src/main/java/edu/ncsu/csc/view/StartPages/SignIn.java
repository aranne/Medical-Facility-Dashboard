package edu.ncsu.csc.view.StartPages;

import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.controller.StartPages.UserManager;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static edu.ncsu.csc.controller.StartPages.SignIn.*;

public class SignIn extends BasePage implements PageView {
    private MedicalFacility facility;
    UserManager um;
    private boolean isPatient;
    public SignIn(MedicalFacility facility) {
        super();
        menueStrs.add("Sign in");
        menueStrs.add("Go Back");
        pageTitle = "==================== SIGN IN ====================";
        choicePrompt = "input your choice:";
        this.facility = facility;
        um=new UserManager();
        isPatient=false;
    }
    public void display() {
        running = true;
        while (running) {
            initPage();
            switch (getChoice(menueStrs)) {
                case 1:
                    if (doSignIn()) {
                        if(isPatient)
                        {
                            show("Login successfully\n" + "Thanks for choosing " + facility.getName());
                            //TODO
                        }else{
                            show("Login successfully\n" );
                            //TODO
                        }
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

    private boolean doSignIn() {
        String lastName = getStringFromInput("B. Last Name");
        Date dob = getDateFromInput("C. Date of Birth in format mm/dd/yyyy");
        String addrCity = getStringFromInput("D. City of address");
        String tmp = getStringFromInput("E. Patient with Options(y/n?)");
        if (tmp.equals("y")) {
            isPatient=true;
            return um.signInAsPatient(facility.getFacilityId(),lastName,dob,addrCity);
        } else {
            isPatient=false;
            return um.signInAsStaff(facility.getFacilityId(),lastName,dob);
        }
    }
}
