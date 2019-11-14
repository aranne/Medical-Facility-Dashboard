package edu.ncsu.csc.view.StartPages;

import edu.ncsu.csc.controller.StartPages.UserManager;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.model.Staff;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;
import edu.ncsu.csc.view.PatientPages.PatientRoutingPage;
import edu.ncsu.csc.view.StaffPages.StaffMenu;

import java.util.Date;

public class SignIn extends BasePage implements PageView {
    private MedicalFacility facility;
    private Staff m_staff;
    private Patient m_patient;
    private boolean isPatient;
    public SignIn(MedicalFacility facility) {
        super();
        menueStrs.add("Sign in");
        menueStrs.add("Go Back");
        pageTitle = "==================== SIGN IN ====================";
        choicePrompt = "input your choice:";
        this.facility = facility;
        m_staff=null;
        m_patient=null;
        isPatient=false;
    }
    public void display() {
        running = true;
        while (running) {
            initPage();
            m_staff=null;
            m_patient=null;
            isPatient=false;
            switch (getChoice()) {
                case 1:
                    if (doSignIn()) {
                        if(isPatient)
                        {
                            show("Login successfully\n" + "Thanks for choosing " + facility.getName());
                            new PatientRoutingPage(m_patient,facility).display();
                        }else{
                            show("Login successfully\n" );
                            new StaffMenu(m_staff).display();
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
        UserManager um=new UserManager();
        String lastName = getStringFromInput("B. Last Name");
        Date dob = getDateFromInput("C. Date of Birth in format mm/dd/yyyy");
        String addrCity = getStringFromInput("D. City of address");
        String tmp = getStringFromInput("E. Patient with Options(y/n?)");
        if (tmp.equals("y")) {
            isPatient=true;
            m_patient=um.signInAsPatient(facility.getFacilityId(),lastName,dob,addrCity);
            if(m_patient==null)
            {
                return false;
            }
            else {
                return true;
            }
        } else {
            isPatient=false;
            m_staff=um.signInAsStaff(facility.getFacilityId(),lastName,dob);
            if(m_staff==null)
            {
                show("Sign in Incorrect or You are not working in this facility, please enter again");
                return false;
            }
            else {
                return true;
            }
        }
    }
}
