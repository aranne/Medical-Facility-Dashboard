package edu.ncsu.csc.view.StaffPages;

import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.model.Severity;
import edu.ncsu.csc.view.InteractiveTool;

import static edu.ncsu.csc.controller.StaffPages.AddSeverityScale.*;

public class AddSeverityScale {

    public static void display() {
        List<String> menueStrs = new ArrayList<String>(0);
        menueStrs.add("There's another level for this scale");
        menueStrs.add("There's no more levels");
        menueStrs.add("Go back");
        Boolean running = true;
        InteractiveTool intertool = new InteractiveTool();
        List<Severity> levels=new ArrayList<Severity>(0);
        while (running) {
            intertool.show(menueStrs);
            intertool.show("input your choice:");
            int index = intertool.getChoice(3);
            switch (index) {
                case 1:
                    Severity sev=new Severity();
                    sev.setName(intertool.getStringFromInput("input severity's name:"));
                    sev.setScale(intertool.getStringFromInput("input severity's scale:"));
                    sev.setBleeding(intertool.getStringFromInput("input severity's bleeding:"));
                    sev.setValue(intertool.getNum("input severity's value:"));
                    levels.add(sev);
                    break;
                case 2:
                    if(levels.size()>0) {
                       if(addScale(levels)) {
                           intertool.show("add severities successfully");
                       }else{
                           intertool.show("faild to add severities");
                       }

                    }
                    running = false;
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
    }
}
