package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.DAO.SymptomDAOImp;
import edu.ncsu.csc.model.Symptom;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.util.List;

public class ChooseSymptom extends BasePage implements PageView {
  List<Symptom> symptoms;
  int page;

  public ChooseSymptom(int page) {
    this.page = page;
    SymptomDAOImp symptomDAO = new SymptomDAOImp();
    this.symptoms = symptomDAO.getAllValues();
    choicePrompt = "Enter Choice";
    for (int i = 0; i < symptoms.size(); i++) {
      menuStrs.add(symptoms.get(i).getName());
    }
    menuStrs.add("Done");
  }

  @Override
  public void display() {
    running = true;
    while (running) {
      initPage();
      int index = getChoice();

      if (index == menuStrs.size()) {
        running = false;
      } else {
        switch (page) {
          case 4:
            new AddSeverityScale(symptoms.get(index - 1)).display();
            break;
          case 5:
            new AddAssessmentRule(symptoms.get(index - 1)).display();
            break;
          default:
            break;
        }

      }

    }

  }
}
