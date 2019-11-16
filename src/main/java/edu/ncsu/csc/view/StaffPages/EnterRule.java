package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.DAO.SeverityDAOImp;
import edu.ncsu.csc.model.Severity;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

public class EnterRule extends BasePage implements PageView {
  Severity severity;

  public EnterRule(Severity severity) {
    this.severity = severity;
    choicePrompt = "input a number:";
    menuStrs.add("Normal");
    menuStrs.add("High");
    menuStrs.add("Quarantine");
    menuStrs.add("Cancel");
  }

  @Override
  public void display() {
    running = true;
    while (running) {
      initPage();
      int c = getChoice();
      if (c == 4) {
        running = false;
      } else {
        SeverityDAOImp severityDAOImp = new SeverityDAOImp();
        severityDAOImp.setPriority(severity, c);
        running = false;
      }
    }

  }
}
