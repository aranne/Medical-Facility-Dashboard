package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.controller.CheckoutPages.ReportManager;
import edu.ncsu.csc.model.Reason;
import edu.ncsu.csc.model.Report;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.ComboBoxPage;
import edu.ncsu.csc.view.PageView;

import java.util.List;

public class UpdateReason extends BasePage implements PageView {
    private Reason reason;
    ReportManager rpm;
    Report report;
    public UpdateReason(ReportManager rpm, Report report) {
        this.rpm = rpm;
        this.report = report;
        choicePrompt = "choose a reason";
        menuStrs.add("service unavailable at time of visit");
        menuStrs.add("service not present at facility");
        menuStrs.add("non payment");
    }

    public Reason getReason() {
        return reason;
    }

    @Override
    public void display() {
        List<String> services = rpm.getServiceMenu();
        reason = new Reason();
        int index = ComboBoxPage.getInstance().select(services,"choose a service");
        reason.setServiceCode(rpm.getServiceSelection(index - 1).getServiceCode());
        initPage();
        reason.setReasonCode(String.valueOf(getChoice()));
        reason.setDescription(getStringFromInput("input some description:"));
        reason.setTime(report.getTime());
        reason.setDob(report.getDob());
        reason.setLastName(report.getLastName());
    }
}
