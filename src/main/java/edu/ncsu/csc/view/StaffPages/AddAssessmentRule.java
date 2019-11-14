package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.util.ArrayList;
import java.util.List;

public class AddAssessmentRule extends BasePage implements PageView {
    public AddAssessmentRule() {
        pageTitle="=================== AddAssessmentRule =============================";
        choicePrompt="input your choice:";
        menueStrs.add("Record");
        menueStrs.add("Go Back");
    }

    @Override
    public void display() {
        running = true;
        while (running) {
            initPage();
            switch (getChoice()) {
                case 1:
                    //TODO
                    throw new NullPointerException("todo");
                    //use intertool to get the informations of this rule;
//                    break;
                case 2:
                    running = false;
                    break;
            }
        }
    }
}
