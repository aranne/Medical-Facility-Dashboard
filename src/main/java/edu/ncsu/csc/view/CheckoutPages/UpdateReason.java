package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.controller.CheckoutPages.ReportManager;
import edu.ncsu.csc.model.Reason;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.ComboBoxPage;
import edu.ncsu.csc.view.PageView;

import java.util.List;

public class UpdateReason extends BasePage implements PageView {
     private Reason reason;
    ReportManager rpm;
    public UpdateReason(Reason reason, ReportManager rpm) {
        this.reason = reason;
        this.rpm=rpm;
        choicePrompt = "choose a reason";
        menuStrs.add("service unavailable at time of visit");
        menuStrs.add("service not present at facility");
        menuStrs.add("non payment");
    }

    @Override
    public void display() {
        List<String> services = rpm.getServiceMenu();
        int index= ComboBoxPage.getInstance().select(services,"choose a service");
        reason.setServiceCode(rpm.getServiceSelection(index).getServiceCode());
        show(menuStrs);
        initPage();
        reason.setReasonCode(String.valueOf(index));
        reason.setDescription(getStringFromInput("input some description:"));
    }
}
