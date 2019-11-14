package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.controller.ReportManager;
import edu.ncsu.csc.model.Reason;
import edu.ncsu.csc.model.ReferralStatus;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.util.List;

public class UpdateReferral extends BasePage implements PageView {
    private ReferralStatus referralStatus;
    ReportManager rpm;
    public UpdateReferral(ReferralStatus referralStatus,ReportManager rpm) {
            this.referralStatus=referralStatus;
        this.rpm=rpm;
        menueStrs.add("add a reason");
        menueStrs.add("done");
    }

    @Override
    public void display() {
        List<String> facilityMenu=rpm.getFacilityMenu();
        show(facilityMenu);
        show("choose a edicalFacility");
        int index=getChoice(facilityMenu);
        referralStatus.setFacility(rpm.getMedicalFacilitySelection(index));
       running=true;
       while(running){
           show(menueStrs);
           if (getChoice(menueStrs)==1){
               Reason r=new Reason();
               UpdateReason upr=new UpdateReason(r,rpm);
               referralStatus.getReasons().add(r);
           }else{
               running=false;
           }
       }

    }
}
