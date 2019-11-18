package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Report;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;
import edu.ncsu.csc.view.PatientPages.PatientRoutingPage;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;

public class Acknowledgement extends BasePage implements PageView {
    Report report;
    Patient pd;
    MedicalFacility f;

    public Acknowledgement(Report report) {
        this.report = report;
        choicePrompt = "Enter Choice (1-3)";
        pageTitle = "===========Check-out Acknowledgement===============";
        menuStrs.add("Yes");
        menuStrs.add("No");
        menuStrs.add("Go back");
    }

    @Override
    public void display() {

        initPage();
        int index = getChoice();
        switch (index) {
            case 1:
            case 3:
                PatientRoutingPage up = new PatientRoutingPage(pd, f);
                up.display();
                break;
            case 2:
                String reason = getStringFromInput("input your reasons:");
                while(null == reason || reason.length() <= 0)
                {
                    show("reason must not be empty!!!");
                    reason = getStringFromInput("input your reasons:");

                }
                report.setReason(reason);
                break;
        }

    }

}