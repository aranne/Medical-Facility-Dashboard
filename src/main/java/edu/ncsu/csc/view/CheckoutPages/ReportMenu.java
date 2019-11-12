package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.view.InteractiveTool;

import java.util.ArrayList;
import java.util.List;

import static edu.ncsu.csc.controller.CheckoutPages.ReportMenu.*;

public class ReportMenu {
    public static void display() {
        List<String> menueStrs = new ArrayList<String>(0);
        menueStrs.add("Discharge Status");
        menueStrs.add("Referral Status");
        menueStrs.add("Treatment");
        menueStrs.add("Negative Experience");
        menueStrs.add("Go back");
        menueStrs.add("Submit");
        Boolean running = true;
        InteractiveTool intertool = new InteractiveTool();
        while (running) {
            intertool.show(menueStrs);
            intertool.show("input your choice:");
            int index = intertool.getChoice(6);
            switch (index) {
                case 1:
                    updateDischarge();
                    break;
                case 2:
                    updateReferral();
                    break;
                case 3:
                    treatDescription();
                    break;
                case 4:
                    updateNegative();
                    break;
                case 5:
                    running = false;
                    break;
                case 6:
                    reportConfirm();
                    break;

            }
        }
    }
}
