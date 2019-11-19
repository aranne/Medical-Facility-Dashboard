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
  CheckIn checkIn;



  public StaffMenu(Staff m_staff, MedicalFacility facility) {
    this.m_facility = facility;
    this.m_staff = m_staff;
    pageTitle = "====================== STAFF MENU ======================";
    choicePrompt = "select a job:";
    menuStrs.add("Checked-in patient list");
    menuStrs.add("Treated patient list");
    menuStrs.add("Add symptoms");
    menuStrs.add("Add severity scale");
    menuStrs.add("Add assessment rule");
    menuStrs.add("Go back");
  }

  @Override
  public void display() {
    running = true;
    StaffMenuController checkmm = new StaffMenuController(m_facility);
    while (running) {
      checkmm.reload();
      initPage();
      int index = getChoice();
      checkIn = null;
      if (index == 1 || index == 2) {

      }
      switch (index) {
        case 1:

          List<String> checkins = checkmm.getCheckedinPatientChoices();
          if (checkins.size() <= 0) {
            show("the patient checklist is empty!");
            continue;
          } else {
            checkIn = checkmm.getCheckInSelection(ComboBoxPage.getInstance().select(checkins, "please select a checkin record:"));
          }
          new ProcessPatient(checkIn, m_staff).display();
          break;
        case 2:

          List<String> treateds = checkmm.getTreatedPatientChoices();
          if (treateds.size() <= 0) {
            show("the patient checklist is empty!");
            continue;
          } else {
            checkIn = checkmm.getTreatedSelection(ComboBoxPage.getInstance().select(treateds, "please select a checkin record:"));
          }

          new TreatedPatient(checkIn, m_staff).display();
          break;
        case 3:
          new AddSymptoms().display();
          break;
        case 4:
          new ChooseSymptom(4).display();
          break;
        case 5:
          new ChooseSymptom(5).display();
          break;
        case 6:
          running = false;
          break;
      }
    }
  }
}
