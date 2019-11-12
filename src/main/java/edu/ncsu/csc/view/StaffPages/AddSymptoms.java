package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.controller.StaffPages.SymptomsManager;
import edu.ncsu.csc.view.InteractiveTool;

import java.util.ArrayList;
import java.util.List;

import static edu.ncsu.csc.controller.StaffPages.SymptomsManager.*;

public class AddSymptoms {

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
                    String name=intertool.getStringFromInput("input the symptom's name:");
                    String cdoe=intertool.getStringFromInput("input the symptom's code:");
                    SymptomsManager smg=new  SymptomsManager();
                    List<String> checkins=smg.getBodyPartsMenu();
                    intertool.show(checkins);
                    String selections=intertool.getStringFromInput("choose the associated bodypart:(split by comma)");
                    String[]  tmps=selections.split(",");
                    smg.addSymptom(name,cdoe,tmps);
                    break;
                case 2:
                    running = false;
                    break;
            }
        }
    }
}
