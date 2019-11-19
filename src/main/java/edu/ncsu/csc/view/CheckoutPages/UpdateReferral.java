package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.controller.CheckoutPages.ReportManager;
import edu.ncsu.csc.model.Reason;
import edu.ncsu.csc.model.ReferralStatus;
import edu.ncsu.csc.model.Report;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.ComboBoxPage;
import edu.ncsu.csc.view.PageView;

import java.util.ArrayList;
import java.util.List;

public class UpdateReferral extends BasePage implements PageView {
    private ReferralStatus referralStatus;
    private Report report;
    private ReportManager repm;
    private List<Reason> reasons;
    private int facilityId;
    public UpdateReferral(ReferralStatus referralStatus,ReportManager repm, Report report) {
        this.referralStatus = referralStatus;
        this.repm = repm;
        this.report = report;
        menuStrs.add("Facility id");
        menuStrs.add("Referrer id");
        menuStrs.add("add a reason");
        menuStrs.add("done");
        reasons = new ArrayList<>();
    }

    public List<Reason> getReasons() {
        return reasons;
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
               facilityId = repm.getFacilitySelection(index);
               report.setReferFacilityId(facilityId);
           }else if(cho==2){
               if (facilityId != 0) {
                   int index = ComboBoxPage.getInstance().select(repm.getStaffMenu(facilityId),"choose a Referrer id");
                   report.setReferrerId(repm.getStaffSelection(index));
               } else {
                   show("Please select a medical facility to refer to.");
               }
           }else if(cho==3){
               UpdateReason upr = new UpdateReason(repm, report);
               upr.display();
               reasons.add(upr.getReason());
               if (reasons.size() == 4) {
                   running = false;
               }
           }else{
               running=false;
           }
       }

    }
}
