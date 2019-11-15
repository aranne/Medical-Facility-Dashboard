package edu.ncsu.csc.view.PatientPages;

import edu.ncsu.csc.controller.PatientPages.CheckinSymptoms;
import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.Symptom;
import edu.ncsu.csc.model.SymptomMeta;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.util.List;


public class CheckInPage extends BasePage implements PageView {
    private CheckIn checkIn;
    CheckinSymptoms symm;

    public CheckInPage(CheckIn checkIn) {
        choicePrompt = "Enter Choice (1-3)";
        pageTitle = "==================== CHECKIN ====================";
        symm = new CheckinSymptoms();
        List<String> symptoms = symm.getSymtomsMenu();
        for (int i = 0; i < symptoms.size(); i++) {
            menuStrs.add(symptoms.get(i));
        }
        menuStrs.add("Other");
        menuStrs.add("Done");
        this.checkIn=checkIn;
    }

    @Override
    public void display() {
        running = true;
        SymptomMeta smeta;
        Symptom symptom=null;
        while (running) {
            initPage();
            while (running) {
                initPage();

                int index = getChoice();
                if (index <= (menuStrs.size() - 2)) {
                    symptom = symm.getSymtomsSelection(index);
                    PageView p = new InputSymptomMeta(symptom);
                    p.display();
                    smeta = ((InputSymptomMeta) p).getSm();
                } else if (index == menuStrs.size() - 1) {
                    String smname = getStringFromInput("input a symptom :");
                    symptom = new Symptom(smname, "unknown");
                    PageView p = new InputSymptomMeta(symptom);
                    p.display();
                    smeta = ((InputSymptomMeta) p).getSm();
                } else {
                    if (symm.submit(symptom, symm)) {
                        show("checkin successfuly.");
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
}
