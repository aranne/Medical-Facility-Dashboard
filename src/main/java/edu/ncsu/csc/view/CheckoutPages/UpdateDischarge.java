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
        int  index=getChoice()-1;
        if(index>=0&&index<menueStrs.size()){
            dischargeStatus = menueStrs.get(index);
        }else{
            show("!!!!!!!");
        }

    }

    public String getDischargeStatus() {
        return dischargeStatus;
    }
}
