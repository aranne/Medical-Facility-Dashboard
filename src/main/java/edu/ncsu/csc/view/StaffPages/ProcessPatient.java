package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.controller.StaffPages.StaffProcessPatient;
import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.Staff;
import edu.ncsu.csc.model.Vital;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

public class ProcessPatient  extends BasePage implements PageView {
    CheckIn checkIn;
    Staff m_staff;
    public ProcessPatient(CheckIn checkIn, Staff staff) {
        this.checkIn = checkIn;
        this.m_staff=staff;
        pageTitle="===================ProcessPatient=========================";
        choicePrompt="select a operation:";
        menuStrs.add("Enter Vitals");
        menuStrs.add("Treat patient");
        menuStrs.add("Go back");
    }
    public void display() {
        StaffProcessPatient staffp = new StaffProcessPatient();
        running = true;
        while (running) {
            initPage();
            switch (getChoice()) {
                case 1:
                    Vital vital=new Vital();
                    if (checkIn.getEndTime() == null) {
                        vital.setLastName(checkIn.getLastName());
                        vital.setDob(checkIn.getDob());
                        new EnterVital(vital).display();
                    }
                    if(vital.getLastName() != null && staffp.enterVital(vital,checkIn,m_staff))
                    {

                        show("enter vitals successfully!");
                        running = false;
                    }else{
                        show("fail to enter a vital !!!");
                    }
                    break;
                case 2:
                	StaffProcessPatient stp=new StaffProcessPatient();
                    if(stp.checkPrivilege(checkIn,m_staff)){
                        stp.treatPatient(checkIn, m_staff);
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
