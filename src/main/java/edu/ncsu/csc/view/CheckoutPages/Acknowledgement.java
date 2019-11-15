package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.model.Report;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

public class Acknowledgement extends BasePage implements PageView {
    Report report;

    public Acknowledgement(Report report) {
        this.report = report;
        choicePrompt = "Enter Choice (1-3)";
        pageTitle = "===========Check-out Acknowledgement===============";
        menuStrs.add("Yes");
        menuStrs.add("No");
        menuStrs.add("Go back");
    }

    @Override
    public void display() {
        initPage();
        int index = getChoice();
        if(index==2)
        {

        }
        //TODO
        getStringFromInput("input your reasons:");
    }

}