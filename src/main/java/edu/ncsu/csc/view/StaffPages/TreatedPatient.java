package edu.ncsu.csc.view.StaffPages;

import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.controller.StaffPages.TreatedPatients;
import edu.ncsu.csc.view.InteractiveTool;

public class TreatedPatient {


    public static void display() {
        List<String> menueStrs = new ArrayList<String>(0);
        menueStrs.add("Check out");
        menueStrs.add("Go Back");
        Boolean running = true;
        InteractiveTool intertool = new InteractiveTool();
        while (running) {
            TreatedPatients staffp=new TreatedPatients();
            List<String> checkins= staffp.getChechinChoices();//get the "treated patient list"
            if(checkins.size()<=0)
            {
                intertool.show("the patient checklist is empty!");
                running = false;
                continue;
            }
            intertool.show(checkins);//获取用户选择的记录
            intertool.show("please select a checkin record:");
            //TODO
            //refer to CheckInManager
            //staffp.setChoosedCheckin(intertool.getChoice(checkins.size()));// refer to CheckInManager
            intertool.show(menueStrs);
            intertool.show("input your choice:");
            int index = intertool.getChoice(2);
            switch (index) {
                case 1:
                    //TODO
                    //redirect to Staff-patient checkout
                    break;
                case 2:
                    running = false;
                    break;
            }
        }
    }

}
