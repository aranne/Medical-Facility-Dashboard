package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.controller.CheckoutPages.ReportManager;
import edu.ncsu.csc.model.NagativeExperience;
import edu.ncsu.csc.model.Reason;
import edu.ncsu.csc.model.ReferralStatus;
import edu.ncsu.csc.model.Report;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.util.List;

public class ReportConfirm extends BasePage implements PageView {
    private Report report;
    private ReportManager rpm;
    public ReportConfirm(Report report, ReportManager rpm) {
        choicePrompt = "input your choice:";
        menuStrs.add("Confirm");
        menuStrs.add("Go Back");
        this.report = report;
        this.rpm = rpm;
        rpm.submit(report);
    }

    public  void display() {
         showReport();
         initPage();
         if(getChoice()==1){

         }else{
             show("the report may not be confirmed");
         }
    }
    public void showReport() {
        String stat = report.getDischargeStatus();
        show("Discharge Status:\t" + stat);
        show("Referral Status:");
        if(report.getReferralStatus() == null){
            show("null");
        }else if(report.getReferralStatus() != null){
            ReferralStatus rs = report.getReferralStatus();
            String a =  "f";
            if (rs != null){
                int fid = rs.getFacility().getFacilityId();
                if (fid == 0) {
                    show("Facility:unknown");
                } else {
                    show("Facility:" + fid);
                }
                List<Reason> rrs = rs.getReasons();
                for (Reason rr : rrs) {
                    show(rr.getReasonCode());
                    show(rr.getDescription());
                }
            }else{
                show("null");
            }

        }
        show("Treatment:\t" + report.getTreatment());
        List<NagativeExperience> rrs = report.getNagexps();
        for (NagativeExperience rr : rrs) {
            show(rr.getNagativeCode());
            show(rr.getDiscription());
        }
    }
}
