package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.DAO.CheckInDAOImp;
import edu.ncsu.csc.DAO.PatientDAOImp;
import edu.ncsu.csc.DAO.SeverityDAOImp;
import edu.ncsu.csc.controller.StaffPages.StaffProcessPatient;
import edu.ncsu.csc.model.*;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.util.ArrayList;
import java.util.List;

public class ProcessPatient extends BasePage implements PageView {
  CheckIn checkIn;
  Staff m_staff;

  public ProcessPatient(CheckIn checkIn, Staff staff) {
    this.checkIn = checkIn;
    this.m_staff = staff;
    pageTitle = "=================== Process Patient =========================";
    choicePrompt = "select a operation:";
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
          Vital vital = new Vital();
          if (checkIn.getEndTime() == null) {
            vital.setLastName(checkIn.getLastName());
            vital.setDob(checkIn.getDob());
            new EnterVital(vital).display();
          }
          if (vital.getLastName() != null && staffp.enterVital(vital, checkIn, m_staff)) {
            List<Severity> allSeverities = new SeverityDAOImp().getAllValues();
            ArrayList<PatientSymptom> allPatientSymptom = new SeverityDAOImp().getPatientSymptoms(checkIn);
            int priority = 1;
            for (PatientSymptom patientSymptom: allPatientSymptom) {
              for (Severity severity: allSeverities) {
                int t = severity.getPriority2(patientSymptom);
                if (t > priority) priority = t;
              }
            }
            new CheckInDAOImp().setPriority(checkIn, priority);
            show("enter vitals successfully! ");
            System.out.println("Priority is " + String.valueOf(priority) + " (1 is normal, 2 is high, 3 is quarantine)");
            running = false;
          } else {
            show("fail to enter a vital !!!");
          }
          break;
        case 2:
          StaffProcessPatient stp = new StaffProcessPatient();
          PatientDAOImp patientDAOImp = new PatientDAOImp();
          patientDAOImp.addTreatmentTime(checkIn);
          break;
        case 3:
          running = false;
          break;
      }
    }
  }

}