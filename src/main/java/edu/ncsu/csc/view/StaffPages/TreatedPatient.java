package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.Staff;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.CheckoutPages.ReportMenu;
import edu.ncsu.csc.view.PageView;

public class TreatedPatient extends BasePage implements PageView {

    CheckIn checkIn;
    Staff staff;
    public TreatedPatient(CheckIn checkIn, Staff staff) {
        this.checkIn = checkIn;
        this.staff=staff;
        pageTitle="=======================TreatedPatient=============================";
        choicePrompt="input your choice:";
        menueStrs.add("Check out");
        menueStrs.add("Go Back");
    }
    public void display() {
        running = true;
        while (running) {
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
