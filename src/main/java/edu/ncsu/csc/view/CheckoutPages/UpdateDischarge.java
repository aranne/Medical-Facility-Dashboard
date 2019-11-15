package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

public class UpdateDischarge extends BasePage implements PageView {


    String dischargeStatus;

    public UpdateDischarge() {
        this.dischargeStatus = "";
        pageTitle = "";
        choicePrompt = "input your choice:";
        menuStrs.add("Treated Successfully");
        menuStrs.add("Deceased");
        menuStrs.add("Referred");

    }

    @Override
    public void display() {
        initPage();
        dischargeStatus = menuStrs.get(getChoice());
    }

    public String getDischargeStatus() {
        return dischargeStatus;
    }
}
