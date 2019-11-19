package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.DAO.SeverityDAOImp;
import edu.ncsu.csc.model.Severity;
import edu.ncsu.csc.model.Symptom;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.util.List;

public class AddAssessmentRule extends BasePage implements PageView {
  Symptom symptom;
  List<Severity> severities;

  public AddAssessmentRule(Symptom symptom) {
    this.symptom = symptom;
    SeverityDAOImp severityDAOImp = new SeverityDAOImp();
    severities = severityDAOImp.getAllBySymCode(symptom.getSymCode());
    pageTitle = "=================== Add Assessment Rule =============================";
    choicePrompt = "input your choice:";
    for (int i = 0; i < severities.size(); i++) {
      menuStrs.add(severities.get(i).toString());
    }
    menuStrs.add("Go Back");
  }

  @Override
  public void display() {
    running = true;
    while (running) {
      initPage();
      int c = getChoice();
      if (c == menuStrs.size()) {
        running = false;
      } else {
        new EnterRule(severities.get(c - 1)).display();
        running = false;
      }
    }
  }
}
