package edu.ncsu.csc.view.PatientPages;

import edu.ncsu.csc.controller.PatientPages.CheckinSymptoms;
import edu.ncsu.csc.model.*;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.util.ArrayList;
import java.util.List;


public class CheckInPage extends BasePage implements PageView {
  Patient patient;
  MedicalFacility medicalFacility;
  private CheckIn checkIn;
  CheckinSymptoms checkinSymptoms;
  ArrayList<SymptomMeta> symptomMetaList;

  public CheckInPage(CheckIn checkIn, Patient patient, MedicalFacility medicalFacility) {
    this.patient = patient;
    this.medicalFacility = medicalFacility;
    choicePrompt = "Enter Choice";
    pageTitle = "==================== CHECK IN ====================";
    checkinSymptoms = new CheckinSymptoms();
    List<String> symptoms = checkinSymptoms.getSymptomsMenu();
    for (int i = 0; i < symptoms.size(); i++) {
      menuStrs.add(symptoms.get(i));
    }
    menuStrs.add("Other");
    menuStrs.add("Done");
    symptomMetaList = new ArrayList<SymptomMeta>();
    this.checkIn = checkIn;
  }

  @Override
  public void display() {
    running = true;
    SymptomMeta smeta;
    Symptom symptom = null;
    while (running) {
      initPage();
      smeta = null;
      int index = getChoice();
      if (index <= (menuStrs.size() - 2)) {
        symptom = checkinSymptoms.getSymtomsSelection(index);
        PageView p = new InputSymptomMeta(symptom);
        p.display();
        smeta = ((InputSymptomMeta) p).getSymptomMeta();
        if (smeta != null)
          symptomMetaList.add(smeta);
      } else if (index == menuStrs.size() - 1) {
        String smname = getStringFromInput("input a symptom :");
        symptom = new Symptom(smname, "unknown");
        PageView p = new InputSymptomMeta(symptom);
        p.display();
        smeta = ((InputSymptomMeta) p).getSymptomMeta();
        if (smeta != null)
          symptomMetaList.add(smeta);
      } else {
        if (checkinSymptoms.submit(symptomMetaList,patient) && checkinSymptoms.addCheckIn(patient, medicalFacility)) {
          show("checkin successfully.");
          running = false;
        } else {
          show("failed to checkin.");
          if (!getStringFromInput("retry(y/n)?").equals("y")) {
            running = false;
          }
        }
      }

    }
  }
}
