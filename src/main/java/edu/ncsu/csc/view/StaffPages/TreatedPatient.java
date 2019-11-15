package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.controller.StaffPages.StaffMenuController;
import edu.ncsu.csc.controller.StaffPages.StaffProcessPatient;
import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.Staff;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.CheckoutPages.ReportMenu;
import edu.ncsu.csc.view.ComboBoxPage;
import edu.ncsu.csc.view.PageView;

import java.util.List;

public class TreatedPatient extends BasePage implements PageView {
    Staff staff;
    public TreatedPatient(Staff staff) {
        this.staff=staff;
        pageTitle="=======================TreatedPatient=============================";
        choicePrompt="input your choice:";
        menueStrs.add("Check out");
        menueStrs.add("Go Back");
    }
    public void display() {
        running = true;
        while (running) {
                StaffMenuController checkmm=new StaffMenuController();
                List<String> checkins= checkmm.getChechinChoices();//获取已经check_in的病人列表
                if(checkins.size()<=0)
                {
                    show("the patient checklist is empty!");
                    break;
                }
            CheckIn   checkIn=checkmm.getCheckInSelection( ComboBoxPage.getInstance().select(checkins,"please select a checkin record:"));
            initPage();
            switch (getChoice()) {
                case 1:
                    new ReportMenu(checkIn,staff).display();
                    break;
                case 2:
                    running = false;
                    break;
            }
        }
    }

}
