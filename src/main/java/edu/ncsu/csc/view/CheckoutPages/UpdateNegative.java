package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.model.NegativeExperience;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;


public class UpdateNegative extends BasePage implements PageView {
    NegativeExperience nagexp;
    public UpdateNegative(NegativeExperience nagexp) {
        this.nagexp = nagexp;
        choicePrompt = "input your choice:";
        menuStrs.add("Misdiagnosis");
        menuStrs.add("Patient acquired an infection during hospital stay");
    }

    @Override
    public void display() {
        initPage();
        int index=getChoice();
        nagexp.setNegativeCode(menuStrs.get(index - 1));
        nagexp.setDescription(getStringFromInput("input some description:"));
    }
}
