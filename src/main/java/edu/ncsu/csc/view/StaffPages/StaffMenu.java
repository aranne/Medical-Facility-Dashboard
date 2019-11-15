package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.controller.StaffPages.StaffMenuController;
import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Staff;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.ComboBoxPage;
import edu.ncsu.csc.view.PageView;

import java.util.List;
public class StaffMenu extends BasePage implements PageView {
    private MedicalFacility m_facility;
    private Staff m_staff;
    public StaffMenu(Staff m_staff, MedicalFacility facility) {
        this.m_facility = facility;
        this.m_staff = m_staff;
        pageTitle="======================STAFF MENU===============";
        choicePrompt="select a job:";
        menueStrs.add("Checked-in patient list");
        menueStrs.add("Threated patient list");
        menueStrs.add("Add symptoms");
        menueStrs.add("Add severity scale");
        menueStrs.add("Add assessment rule");
        menueStrs.add("Go back");
    }

    @Override
    public void display() {
        running = true;
        while (running) {
            initPage();
            int index = getChoice();
            CheckIn checkIn=null;
            if(index==1||index==2)
            {
            	StaffMenuController checkmm=new StaffMenuController();
                List<String> checkins= checkmm.getChechinChoices(m_facility);//获取已经check_in的病人列表
                if(checkins.size()<=0)
                {
                    show("the patient checklist is empty!");
                    continue;
                } else {
                    checkIn=checkmm.getCheckInSelection( ComboBoxPage.getInstance().select(checkins,"please select a checkin record:"));
                }
              }
            switch (index) {
                case 1:
                    new ProcessPatient(checkIn,m_staff).display();
                    break;
                case 2:
                    new TreatedPatient(checkIn,m_staff).display();
                    break;
                case 3:
                    new AddSymptoms().display();
                    break;
                case 4:
                    new AddSeverityScale().display();
                    break;
                case 5:
                    new AddAssessmentRule();
                    break;
                case 6:
                    running = false;
                    break;
            }
        }
    }
}
