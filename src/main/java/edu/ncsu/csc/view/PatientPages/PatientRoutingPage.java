package edu.ncsu.csc.view.PatientPages;

import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.DAO.NegativeExpeDAOImp;
import edu.ncsu.csc.DAO.ReasonDAOImp;
import edu.ncsu.csc.DAO.StaffDAOImp;
import edu.ncsu.csc.controller.PatientPages.PatientCheckProceed;
import edu.ncsu.csc.model.*;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.CheckoutPages.Acknowledgement;
import edu.ncsu.csc.view.PageView;

import java.util.List;

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
          CheckIn checkIn = new CheckIn();
          new CheckInPage(checkIn, this.pd, f).display();
          break;
        case 2:
          PatientCheckProceed pcp = new PatientCheckProceed(f);
          Report r = pcp.getReport(pd);
          if (pcp.getReport(pd) == null){
            show("Here is not your report yet");
          }else{
            new Acknowledgement(pcp.getReport(pd)).display();
          }
          break;
        case 3:
          running = false;
          break;
      }
    }
  }
}
