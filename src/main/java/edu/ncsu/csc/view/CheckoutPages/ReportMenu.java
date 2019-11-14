package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.controller.CheckoutPages.ReportManager;
import edu.ncsu.csc.model.*;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.util.ArrayList;
import java.util.List;


public class ReportMenu extends BasePage implements PageView {
    private Report report;
    private Staff staff;
    private ReferralStatus referralStatus;
    ReportManager repm;
    public ReportMenu(CheckIn checkIn,Staff staff) {
    	super();
    	 pageTitle="=================ReportMenu==============================";
    	 choicePrompt="input your choice:";
    	 menueStrs.add("Discharge Status");
         menueStrs.add("Referral Status");
         menueStrs.add("Treatment");
         menueStrs.add("Negative Experience");
         menueStrs.add("Go back");
         menueStrs.add("Submit");
        this.staff=staff;
        report =new Report();
        report.setLastName(checkIn.getLastName());
        report.setDob(checkIn.getDob());
        report.setFacilityId(checkIn.getFacilityId());;
        repm=new ReportManager(checkIn,staff);
    }

    @Override
    public  void display() {       
        running = true;
        while (running) {
            int index = getChoice();
            switch (index) {
                case 1:
                    UpdateDischarge up=new UpdateDischarge();
                    report.setDischargeStatus(up.getDischargeStatus());
                    break;
                case 2:
                    if(report.getDischargeStatus().equals("Referred")){
                        if(referralStatus==null)
                            referralStatus=new ReferralStatus();
                        new UpdateReferral(referralStatus,repm).display();;
                        report.setReferralStatus(referralStatus);
                }else{
                        show("This field is valid only if Discharge Status is Referred");
                    }

                    break;
                case 3:
                    String tratment=getEmailFromInput("input treatment text description");
                    while(null==tratment||tratment.length()<=0)
                    {
                        show("treatment description must not be empty!!!");
                        tratment=getEmailFromInput("input treatment text description");
                    }
                    report.setTreatment(tratment);
                    break;
                case 4:
                    NagativeExperience nagexp=new NagativeExperience();
                    new UpdateNegative(nagexp).display();
                    report.getNagexps().add(nagexp);
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
