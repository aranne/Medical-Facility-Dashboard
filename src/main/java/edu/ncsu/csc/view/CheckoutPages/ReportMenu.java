package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.controller.CheckoutPages.ReportManager;
import edu.ncsu.csc.model.*;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.sql.Time;
import java.util.Date;


public class ReportMenu extends BasePage implements PageView {
    private Report report;
    private Staff staff;
    private ReferralStatus referralStatus;
    ReportManager repm;
    public ReportMenu(CheckIn checkIn,Staff staff) {
    	super();
    	 pageTitle="=================ReportMenu==============================";
    	 choicePrompt="input your choice:";
    	 menuStrs.add("Discharge Status");
         menuStrs.add("Referral Status");
         menuStrs.add("Treatment");
         menuStrs.add("Negative Experience");
         menuStrs.add("Go back");
         menuStrs.add("Submit");
        this.staff=staff;
        report = new Report();
        report.setTime(new Time(System.currentTimeMillis()));
        report.setLastName(checkIn.getLastName());
        report.setDob(checkIn.getDob());
        report.setFacilityId(checkIn.getFacilityId());
        report.setEmployeeId(staff.getEmployeeId());
        repm = new ReportManager(checkIn,staff);
    }

    @Override
    public void display() {
        running = true;
        while (running) {
            initPage();
            int index = getChoice();
            switch (index) {
                case 1:
                    show("Please update discharge status");
                    UpdateDischarge up = new UpdateDischarge();
                    up.display();
                    report.setDischargeStatus(up.getDischargeStatus());
                    break;
                case 2:
                    if(report.getDischargeStatus().equals("Referred")){
                        if(referralStatus == null)
                            referralStatus = new ReferralStatus();
                        new UpdateReferral(referralStatus,repm).display();
                        report.setReferralStatus(referralStatus);
                    }else{
                        show("This field is valid only if Discharge Status is Referred");
                    }

                    break;
                case 3:
                    String treatment = getStringFromInput("input treatment text description");
                    while(null == treatment || treatment.length() <= 0)
                    {
                        show("treatment description must not be empty!!!");
                        treatment = getStringFromInput("input treatment text description");

                    }
                    report.setTreatment(treatment);

                    break;
                case 4:
//                    NegativeExperience nagexp = new NegativeExperience();
//                    new UpdateNegative(nagexp).display();
//                    report.getNagexps().add(nagexp);
                    break;
                case 5:
                    running = false;
                    break;
                case 6:
                    new ReportConfirm(report,repm).display();
                    running = false;
                    break;

            }
        }
    }
}
