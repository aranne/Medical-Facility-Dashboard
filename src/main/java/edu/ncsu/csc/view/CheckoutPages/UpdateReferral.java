package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.controller.CheckoutPages.ReportManager;
import edu.ncsu.csc.model.Reason;
import edu.ncsu.csc.model.ReferralStatus;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.ComboBoxPage;
import edu.ncsu.csc.view.PageView;

import java.util.List;

public class UpdateReferral extends BasePage implements PageView {
    private ReferralStatus referralStatus;
    private ReportManager repm;
    public UpdateReferral(ReferralStatus referralStatus,ReportManager repm) {
        this.referralStatus = referralStatus;
        this.repm=repm;
        menueStrs.add("Facility id");
        menueStrs.add("Referrer id");
        menueStrs.add("add a reason");
        menueStrs.add("done");
    }
    @Override
    public void display() {
       running=true;
       while(running){
           initPage();
           int cho=getChoice();
           if (cho==1){
               int index=ComboBoxPage.getInstance().select(repm.getFacilityMenu(),"choose a medicalFacility");
               referralStatus.setFacility(repm.getFacilitySelection(index));
           }else if(cho==2){
               int index=ComboBoxPage.getInstance().select(repm.getStaffMenu(),"choose a Referrer id");
               referralStatus.setStaff(repm.getStaffSelection(index));
           }else if(cho==3){
               Reason r=new Reason();
               UpdateReason upr=new UpdateReason(r,repm);
               referralStatus.getReasons().add(r);
           }else{
               running=false;
           }
       }

    }
}
