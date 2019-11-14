package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.controller.ReportManager;
import edu.ncsu.csc.controller.ServiceManager;
import edu.ncsu.csc.model.Reason;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.util.List;

public class UpdateReason extends BasePage implements PageView {
     private Reason reason;
    ReportManager rpm;
    public UpdateReason(Reason reason, ReportManager rpm) {
        this.reason = reason;
        this.rpm=rpm;
        choicePrompt = "input your choice:";
        menueStrs.add("service unavailable at time of visit");
        menueStrs.add("service not present at facility");
        menueStrs.add("non payment");
    }

    @Override
    public void display() {
        List<String> services=rpm.getServiceMenu();
        show(services);
        show("choose a service");
        int index=getChoice(services);
        reason.setServiceCode(rpm.getServiceSelection(index).getServiceCode());
        show(menueStrs);
        show("choose a reason");
        index=getChoice(menueStrs);
        reason.setReasonCode(String.valueOf(index));
        reason.setDescription(getEmailFromInput("input some disciption:"));
    }
}
