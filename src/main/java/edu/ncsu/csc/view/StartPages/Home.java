package edu.ncsu.csc.view.StartPages;

import edu.ncsu.csc.controller.StartPages.MedicalFacilityManager;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.ComboBoxPage;
import edu.ncsu.csc.view.PageView;

import java.util.List;


public class Home extends BasePage implements PageView {
    public Home() {
        super();
        menuStrs.add("Sign in");
        menuStrs.add("Sign Up(Patient)");
        menuStrs.add("Demo Queries");
        menuStrs.add("Go Back");
        pageTitle = "==================== HOME ====================";
        choicePrompt = "input your choice:";
    }

    public void display() {
        running = true;
        MedicalFacilityManager umm = new MedicalFacilityManager();
        List<String> facilityMenu=umm.getFacilityMenu();
        while (running) {
            initPage();
            PageView p = null;
            switch (getChoice()) {
                case 1:
                    int index=ComboBoxPage.getInstance().select(facilityMenu,"Choose A Medical Facility:");
                    p = new SignIn(umm.getFacilitySelection(index));
                    p.display();
                    break;
                case 2:
                    p = new SignUp();
                    p.display();
                    break;
                case 3:
                //TODO
                	break;
                case 4:
                    running = false;
                    break;
            }
        }
    }

}
