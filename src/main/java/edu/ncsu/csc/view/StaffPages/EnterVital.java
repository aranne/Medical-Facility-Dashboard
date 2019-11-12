package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.controller.StaffPages.InsertVital;
import edu.ncsu.csc.view.InteractiveTool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnterVital {
    public static void display(String lastName, Date dob) {
        List<String> menueStrs = new ArrayList<String>(0);
        menueStrs.add("Record");
        menueStrs.add("Go back");
        Boolean running = true;
        InteractiveTool intertool = new InteractiveTool();
        while (running) {
            intertool.show(menueStrs);//菜单功能选择(Record or Go back )
            intertool.show("input your choice:");
            int index = intertool.getChoice(2);
            switch (index) {
                case 1:

                    float temperature=intertool.getRealValue("input Temperature:");
                    float bloodPressureDiastolic=intertool.getRealValue("input Systolic blood pressure:");
                    float bloodPressureSystolic=intertool.getRealValue("input Diastolic blood pressure:");
                    if(InsertVital.enterVital(lastName,dob,temperature,bloodPressureDiastolic,bloodPressureSystolic))
                    {
                        intertool.show("enter vital successfully!");
                    }else{
                        intertool.show("faild to enter a vital !!!");
                    }
                    break;
                case 2:
                    running = false;
                    break;
            }
        }
    }
}
