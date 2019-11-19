package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.model.NegativeExperience;
import edu.ncsu.csc.model.Report;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;


public class UpdateNegative extends BasePage implements PageView {
    NegativeExperience nagexp;
    Report report;
    public UpdateNegative(Report report) {
        nagexp = new NegativeExperience();
        this.report = report;
        choicePrompt = "input your choice:";
        menuStrs.add("Misdiagnosis");
        menuStrs.add("Patient acquired an infection during hospital stay");
    }

    @Override
    public void display() {
        initPage();
        int index = getChoice();
        nagexp.setNegativeCode(menuStrs.get(index - 1));
        nagexp.setDescription(getStringFromInput("input some description:"));
        nagexp.setTime(report.getTime());
        nagexp.setDob(report.getDob());
        nagexp.setLastName(report.getLastName());

    }

    public NegativeExperience getNagexp() {
        return nagexp;
    }
}
