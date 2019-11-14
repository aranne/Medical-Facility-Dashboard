package edu.ncsu.csc.view.StaffPages;

import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.controller.StaffPages.CheckInManager;
import edu.ncsu.csc.controller.StaffPages.TreatPatient;
import edu.ncsu.csc.view.InteractiveTool;

public class ProcessPatient {

    public static void display() {
        List<String> menueStrs = new ArrayList<String>(0);
        menueStrs.add("Enter Vitals");
        menueStrs.add("Treat patient");
        menueStrs.add("Go back");
        Boolean running = true;
        InteractiveTool intertool = new InteractiveTool();
        while (running) {
            CheckInManager staffp=new CheckInManager();
            List<String> checkins= staffp.getChechinChoices();//获取已经check_in的病人列表
            if(checkins.size()<=0)
            {
                intertool.show("the patient checklist is empty!");
                break;
            }
            intertool.show(checkins);//获取用户选择的记录
            intertool.show("please select a checkin record:");
            staffp.setChoosedCheckin(intertool.getChoice(checkins.size()));
            intertool.show(menueStrs);
            intertool.show("input your choice:");
            int index = intertool.getChoice(3);
            switch (index) {
                case 1:
                    //进入指标输入页面，并传入病人信息参数
                    EnterVital.display(staffp.getCheckIn().getLastName(),staffp.getCheckIn().getDob());
                    break;
                case 2:
                    if(TreatPatient.checkPrivilege(staffp.getCheckIn())){
                        if(TreatPatient.treating(staffp.getCheckIn())){
                            intertool.show("faild to traet patient !!!");
                        }else{
                            intertool.show("treat patient successfully!");
                        }
                    }else{
                        intertool.show("you have no privilege for this operation!");
                    }
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
    }

}
