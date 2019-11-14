package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.view.InteractiveTool;

import java.util.ArrayList;
import java.util.List;

public class AddAssessmentRule {

    public static void display() {
        List<String> menueStrs = new ArrayList<String>(0);
        menueStrs.add("Record");
        menueStrs.add("Go Back");
        Boolean running = true;
        InteractiveTool intertool = new InteractiveTool();
        while (running) {
            intertool.show(menueStrs);
            intertool.show("input your choice:");
            int index = intertool.getChoice(2);
            switch (index) {
                case 1:
                    //TODO
                    //use intertool to get the informations of this rule;
                    break;
                case 2:
                    running = false;
                    break;
            }
        }
    }
}
