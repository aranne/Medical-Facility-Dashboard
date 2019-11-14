package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.view.InteractiveTool;

import java.util.ArrayList;
import java.util.List;

import static edu.ncsu.csc.controller.StaffPages.StaffMenu.*;

public class StaffMenu {

    public static void display() {
        List<String> menueStrs = new ArrayList<String>(0);
        menueStrs.add("Checked-in patient list");
        menueStrs.add("Threated patient list");
        menueStrs.add("Add symptoms");
        menueStrs.add("Add severity scale");
        menueStrs.add("Add assessment rule");
        menueStrs.add("Go back");
        Boolean running = true;
        InteractiveTool intertool = new InteractiveTool();
        while (running) {
            intertool.show(menueStrs);
            intertool.show("input your choice:");
            int index = intertool.getChoice(6);
            switch (index) {
                case 1:
                    processPatient();
                    break;
                case 2:
                    treatedPatient();
                    break;
                case 3:
                    addSymptom();
                    break;
                case 4:
                    addScale();
                    break;
                case 5:
                    addAssessment();
                    break;
                case 6:
                    running = false;
                    break;
            }
        }
    }
}
