package edu.ncsu.csc.view.StaffPages;

import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc.DAO.SeverityDAOImp;
import edu.ncsu.csc.model.Severity;
import edu.ncsu.csc.model.Symptom;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

public class AddSeverityScale extends BasePage implements PageView {
  Symptom symptom;

  public AddSeverityScale(Symptom symptom) {
    this.symptom = symptom;
    choicePrompt = symptom.getName() + ":";
    menuStrs.add("There's another level for this scale");
    menuStrs.add("There's no more levels, Go back");
  }


  @Override
  public void display() {
    running = true;
    List<Severity> levels = new ArrayList<Severity>(0);
    while (running) {
      SeverityDAOImp severityDAOImp = new SeverityDAOImp();
      List<Severity> severities = severityDAOImp.getAllBySymCode(symptom.getSymCode());
      for (Severity s : severities) {
        System.out.println(s.toString());
      }
      initPage();
      int index = getChoice();
      switch (index) {
        case 1:
          Severity sev = new Severity();
          sev.setName(symptom.getSymCode());
          sev.setScale(getStringFromInput("input severity's scale:"));
          addScale(sev);
          break;
        case 2:
          running = false;
          break;
      }
    }
  }


  private void addScale(Severity severity) {
    SeverityDAOImp severityDAOImp = new SeverityDAOImp();
    severityDAOImp.addSeverity(severity);
  }
}
