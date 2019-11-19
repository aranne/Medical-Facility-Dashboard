package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.controller.CheckoutPages.ReportManager;
import edu.ncsu.csc.model.Reason;
import edu.ncsu.csc.model.ReferralStatus;
import edu.ncsu.csc.model.Report;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.ComboBoxPage;
import edu.ncsu.csc.view.PageView;

public class UpdateReferral extends BasePage implements PageView {
    private ReferralStatus referralStatus;
    private Report report;
    private ReportManager repm;
    private Reason reason;
    public UpdateReferral(ReferralStatus referralStatus,ReportManager repm, Report report) {
        this.referralStatus = referralStatus;
        this.repm = repm;
        this.report = report;
        menuStrs.add("Facility id");
        menuStrs.add("Referrer id");
        menuStrs.add("add a reason");
        menuStrs.add("done");
    }

    public Reason getReason() {
        return reason;
    }

    @Override
    public void display() {
       running = true;
//       report = new Report();
       while(running){
           initPage();
           int cho=getChoice();
           if (cho==1){
               int index = ComboBoxPage.getInstance().select(repm.getFacilityMenu(),"choose a medicalFacility");
               report.setReferFacilityId(repm.getFacilitySelection(index));
           }else if(cho==2){
               int index = ComboBoxPage.getInstance().select(repm.getStaffMenu(),"choose a Referrer id");
               report.setReferrerId(repm.getStaffSelection(index));
           }else if(cho==3){
               Reason r = new Reason();
               UpdateReason upr = new UpdateReason(repm, report);
               this.reason = upr.getReason();
               upr.display();

           }else{
               running=false;
           }
       }

    }
}
