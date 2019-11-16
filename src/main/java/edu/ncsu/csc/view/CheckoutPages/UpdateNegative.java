package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.model.NagativeExperience;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;


public class UpdateNegative extends BasePage implements PageView {
    NagativeExperience nagexp;
    public UpdateNegative(NagativeExperience nagexp) {
        this.nagexp = nagexp;
        choicePrompt = "input your choice:";
        menuStrs.add("Misdiagnosis");
        menuStrs.add("Patient acquired an infection during hospital stay");
    }

    @Override
    public void display() {
        initPage();
        int index=getChoice();
        nagexp.setNagativeCode(String.valueOf(index));
        nagexp.setDiscription(getStringFromInput("input some description:"));
    }
}
