package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.controller.CheckoutPages.ReportManager;
import edu.ncsu.csc.model.*;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ReportMenu extends BasePage implements PageView {
    private Report report;
    private Staff staff;
    private ReferralStatus referralStatus;
    List<Reason> reasons;
    List<NegativeExperience> negas;
    ReportManager repm;
    public ReportMenu(CheckIn checkIn,Staff staff) {
    	super();
    	 pageTitle="================= Report Menu ==============================";
    	 choicePrompt="input your choice:";
    	 menuStrs.add("Discharge Status");
         menuStrs.add("Referral Status");
         menuStrs.add("Treatment");
         menuStrs.add("Negative Experience");
         menuStrs.add("Go back");
         menuStrs.add("Submit");
        this.staff=staff;
        report = new Report();
        report.setTime(new Date(System.currentTimeMillis()));
        report.setLastName(checkIn.getLastName());
        report.setDob(checkIn.getDob());
        report.setFacilityId(checkIn.getFacilityId());
        report.setEmployeeId(staff.getEmployeeId());

        repm = new ReportManager(checkIn,staff);
        negas = new ArrayList<>();
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
                        UpdateReferral updateReferral = new UpdateReferral(referralStatus, repm,report);
                        updateReferral.display();
                        reasons = updateReferral.getReasons();
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
                    UpdateNegative updateNegative = new UpdateNegative(report);
                    updateNegative.display();
                    negas.add(updateNegative.getNagexp());
                    report.setNagexps(negas);
                    break;
                case 5:
                    running = false;
                    break;
                case 6:
                    if(report.getDischargeStatus() == null){
                        show("Please input discharge status");
                        break;
                    }
                    if(report.getTreatment() == null){
                        show("please input Treatment description");
                        break;
                    }
                    ReportConfirm reportConfirm = new ReportConfirm(report, repm, reasons, negas);
                    reportConfirm.display();
                    running = false;
                    break;

            }
        }
    }
}
