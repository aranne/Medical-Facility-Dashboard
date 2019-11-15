package edu.ncsu.csc.view.StaffPages;

import java.util.List;

import edu.ncsu.csc.controller.StaffPages.StaffProcessPatient;
import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.Staff;
import edu.ncsu.csc.model.Vital;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.ComboBoxPage;
import edu.ncsu.csc.view.PageView;

public class ProcessPatient  extends BasePage implements PageView {
    Staff m_staff;
    public ProcessPatient(Staff staff) {
        this.m_staff=staff;
        pageTitle="===================ProcessPatient=========================";
        choicePrompt="select a operation:";
        menuStrs.add("Enter Vitals");
        menuStrs.add("Treat patient");
        menuStrs.add("Go back");
    }
    public void display() {
        running = true;
        while (running) {
            initPage();
            StaffProcessPatient staffp=new StaffProcessPatient();
            List<String> checkins= staffp.getChechinChoices();//��ȡ�Ѿ�check_in�Ĳ����б�
            if(checkins.size()<=0)
            {
                show("the patient checklist is empty!");
                break;
            }
            CheckIn checkIn=staffp.getCheckInSelection( ComboBoxPage.getInstance().select(checkins,"please select a checkin record:"));
            switch (getChoice()) {
                case 1:
                    //进入指标输入页面，并传入病人信息参数
                	Vital vital=new Vital();
                	vital.setLastName(checkIn.getLastName());
                    vital.setDob(checkIn.getDob());
                    new EnterVital(vital).display();
                    if(staffp.enterVital(vital,checkIn,m_staff))
                    {
                        show("enter vital successfully!");
                    }else{
                        show("faild to enter a vital !!!");
                    }
                    break;
                case 2:
                	StaffProcessPatient stp=new StaffProcessPatient();
                    if(stp.checkPrivilege(checkIn,m_staff)){
                        new TreatedPatient(checkIn,m_staff).display();
//                        if(stp.treating(checkIn)){
//                            show("faild to traet patient !!!");
//                        }else{
//                            show("treat patient successfully!");
//                        }
                    }else{
                        show("you have no privilege for this operation!");
                    }
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
    }

}
