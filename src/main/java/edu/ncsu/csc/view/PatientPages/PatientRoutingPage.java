package edu.ncsu.csc.view.PatientPages;

import edu.ncsu.csc.controller.PatientPages.PatientCheckProceed;
import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.CheckoutPages.Acknowledgement;
import edu.ncsu.csc.view.PageView;

public class PatientRoutingPage extends BasePage implements PageView {
  Patient pd;
  MedicalFacility f;

  public PatientRoutingPage(Patient pd, MedicalFacility f) {
    this.pd = pd;
    this.f = f;
    choicePrompt = "Enter Choice (1-3)";
    pageTitle = "==================== MENU ====================";
    menuStrs.add("Check-in");
    menuStrs.add("Check-out acknowledgement");
    menuStrs.add("Go Back");
  }
  @Override
  public void display() {
    running = true;
    while (running) {
      initPage();
      switch (getChoice()) {
        case 1:
          CheckIn checkIn=new CheckIn();
          new CheckInPage(checkIn).display();
          break;
        case 2:
          PatientCheckProceed  pcp=new PatientCheckProceed(f);
          new Acknowledgement(pcp.getReport(pd)).display();
          break;
        case 3:
          break;
      }
    }
  }
}
