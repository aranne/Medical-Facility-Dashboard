package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.DAO.NegativeExpeDAOImp;
import edu.ncsu.csc.controller.CheckoutPages.ReportManager;
import edu.ncsu.csc.model.NegativeExperience;
import edu.ncsu.csc.model.Reason;
import edu.ncsu.csc.model.ReferralStatus;
import edu.ncsu.csc.model.Report;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.util.List;

public class ReportConfirm extends BasePage implements PageView {
    private Report report;
    private Reason reason;
    private NegativeExperience nega;
    private ReportManager rpm;
    public ReportConfirm(Report report, ReportManager rpm, Reason reason, NegativeExperience nega) {
        choicePrompt = "input your choice:";
        menuStrs.add("Confirm");
        menuStrs.add("Go Back");
        this.report = report;
        this.rpm = rpm;
        this.reason = reason;
        this.nega = nega;
        rpm.submitReport(report);
        if(reason != null){
            rpm.submitReason(reason);
        }
        if(nega != null){
            rpm.submitNegativeExperience(nega);
        }


    }


    @Override
    public void display() {
        running = true;
        while (running) {
            initPage();
            switch (getChoice()) {
                case 1:
                    running = false;
                    break;
                case 2:
                    show("the report may not be confirmed");
                    running = false;
                    break;
            }
        }
    }
    public void showReport() {
        String stat = report.getDischargeStatus();
        show("Discharge Status:\t" + stat);
        show("Referral Status:\t");
        if(report.getReferralStatus() == null){
            show("null");
        }else if(report.getReferralStatus() != null){
            ReferralStatus rs = report.getReferralStatus();
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
        List<NegativeExperience> rrs = report.getNagexps();
        for (NegativeExperience rr : rrs) {
            show(rr.getNegativeCode());
            show(rr.getDescription());
        }
    }
}
