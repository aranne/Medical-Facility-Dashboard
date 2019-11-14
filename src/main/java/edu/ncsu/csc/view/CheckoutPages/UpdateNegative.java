package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.controller.ServiceManager;
import edu.ncsu.csc.model.NagativeExperience;
import edu.ncsu.csc.model.Reason;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.util.List;

public class UpdateNegative extends BasePage implements PageView {
    NagativeExperience nagexp;
    public UpdateNegative(NagativeExperience nagexp) {
        this.nagexp = nagexp;
        choicePrompt = "input your choice:";
        menueStrs.add("Misdiagnosis");
        menueStrs.add("Patient acquired an infection during hospital stay");
    }

    @Override
    public void display() {
        initPage();
        int index=getChoice(menueStrs);
        nagexp.setNagativeCode(String.valueOf(index));
        nagexp.setDiscription(getEmailFromInput("input some disciptions:"));
    }
}
