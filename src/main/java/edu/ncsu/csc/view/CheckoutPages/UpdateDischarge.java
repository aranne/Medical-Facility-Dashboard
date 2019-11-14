package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

public class UpdateDischarge extends BasePage implements PageView {


    String dischargeStatus;

    public UpdateDischarge() {
        this.dischargeStatus = "";
        pageTitle = "";
        choicePrompt = "input your choice:";
        menueStrs.add("Treated Successfully");
        menueStrs.add("Deceased");
        menueStrs.add("Referred");

    }

    @Override
    public void display() {
        initPage();
        dischargeStatus = menueStrs.get(getChoice());
    }

    public String getDischargeStatus() {
        return dischargeStatus;
    }
}
