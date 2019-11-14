package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.controller.ReportManager;
import edu.ncsu.csc.model.NagativeExperience;
import edu.ncsu.csc.model.ReferralStatus;
import edu.ncsu.csc.model.Report;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.InteractiveTool;
import edu.ncsu.csc.view.PageView;

import java.util.ArrayList;
import java.util.List;

import static edu.ncsu.csc.controller.CheckoutPages.ReportMenu.*;

public class ReportMenu extends BasePage implements PageView {
    private Report report;
    private ReferralStatus referralStatus;
    ReportManager repm;
    public ReportMenu(Report report) {
        this.report = report;
        repm=new ReportManager();
    }

    @Override
    public  void display() {
        List<String> menueStrs = new ArrayList<String>(0);
        menueStrs.add("Discharge Status");
        menueStrs.add("Referral Status");
        menueStrs.add("Treatment");
        menueStrs.add("Negative Experience");
        menueStrs.add("Go back");
        menueStrs.add("Submit");
        Boolean running = true;
        InteractiveTool intertool = new InteractiveTool();
        while (running) {
            intertool.show(menueStrs);
            intertool.show("input your choice:");
            int index = intertool.getChoice(6);
            switch (index) {
                case 1:
                    UpdateDischarge up=new UpdateDischarge();
                    report.setDischargeStatus(up.getDischargeStatus());
                    break;
                case 2:
                    if(report.getDischargeStatus().equals("Referred")){
                        if(referralStatus==null)
                            referralStatus=new ReferralStatus();
                        UpdateReferral upref=new UpdateReferral(referralStatus,repm);
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
                    UpdateNegative upn=new UpdateNegative(nagexp);
                    report.getNagexps().add(nagexp);
                    break;
                case 5:
                    running = false;
                    break;
                case 6:
                    reportConfirm();
                    running = false;
                    break;

            }
        }
    }
}
