package edu.ncsu.csc.view.PatientPages;

import edu.ncsu.csc.DAO.SeverityDAOImp;
import edu.ncsu.csc.controller.PatientPages.CheckinSymptomMeta;
import edu.ncsu.csc.model.BodyPart;
import edu.ncsu.csc.model.Severity;
import edu.ncsu.csc.model.Symptom;
import edu.ncsu.csc.model.SymptomMeta;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.ComboBoxPage;
import edu.ncsu.csc.view.PageView;

import java.util.List;
import java.util.Scanner;

public class InputSymptomMeta extends BasePage implements PageView {
  Symptom s;
  SymptomMeta symptomMeta;
  CheckinSymptomMeta checkinSymptomMeta;

  public SymptomMeta getSymptomMeta() {
    return symptomMeta;
  }

  public InputSymptomMeta(Symptom s) {
    this.s = s;
    choicePrompt = "Enter Choice (1-5)";
    pageTitle = "#Symptom meta";
    menuStrs.add("Body part");
    menuStrs.add("Duration");
    menuStrs.add("Reoccurring?");
    menuStrs.add("Severity");
    menuStrs.add("Cause(Incident)");
    menuStrs.add("Cancel");
    menuStrs.add("Done");
    checkinSymptomMeta = new CheckinSymptomMeta(s);
    symptomMeta = new SymptomMeta();
    symptomMeta.setSymptom(s);
    symptomMeta.setIsFirstTime(true);
  }

  @Override
  public void display() {
    running = true;
    while (running) {
      initPage();
      switch (getChoice()) {
        case 1:
          inputPart();
          break;
        case 2:
          inputDuration();
          break;
        case 3:
          inputReoccur();
          break;
        case 4:
          inputSeverity();
          break;
        case 5:
          inputCause();
          break;
        case 6:
          symptomMeta = null;
          running = false;
          break;
        case 7:
          running = false;
          break;
      }

    }
  }

  public void inputPart() {

    List<String> bps = checkinSymptomMeta.getBodyMenu();

    if (bps.size() > 0) {
      int ch = ComboBoxPage.getInstance().select(bps, "choose a bodypart:");
      symptomMeta.setBodyPart(checkinSymptomMeta.getBodySelection(ch));
    } else {
      String bodyPart = getStringFromInput("input a bodyPart name:");
      //TODO
      symptomMeta.setBodyPart(new BodyPart(bodyPart, bodyPart));
    }

  }

  public void inputDuration() {
    symptomMeta.setDuration(getStringFromInput("input Duration:"));
  }

  public void inputReoccur() {
    String s = "";
    do {
      s = getStringFromInput("Reoccurring(yes/no)?");
    } while (!s.equals("yes") && !s.equals("no"));
    if (s.equals("yes"))
      symptomMeta.setIsFirstTime(true);
    else
      symptomMeta.setIsFirstTime(false);
  }

  //TODO
  public void inputSeverity() {
    SeverityDAOImp severityDAOImp = new SeverityDAOImp();

    List<Severity> severities = severityDAOImp.getAllBySymCode(s.getSymCode());
    if (s.getSymCode().equals("unknown") || severities.size() == 0) {
      return;
    }
    for (int i = 0; i < severities.size(); i++) {
      System.out.println(String.valueOf(i+1) + ": " + severities.get(i).getScale());
    }
    boolean flag = true;
    int choice = -1;
    while (flag) {
      System.out.println("Please input value");
      choice = scanner.nextInt();
      if (choice > 0 && choice <= severities.size())
          flag = false;
    }
    symptomMeta.setSeverity(severities.get(choice-1));
  }

  public void inputCause() {
    symptomMeta.setIncident(getStringFromInput("input a Cause"));
  }

}
