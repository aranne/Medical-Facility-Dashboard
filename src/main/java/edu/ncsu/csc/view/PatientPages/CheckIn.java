package edu.ncsu.csc.view.PatientPages;

import edu.ncsu.csc.controller.StaffPages.SymptomsManager;
import edu.ncsu.csc.model.Symptom;
import edu.ncsu.csc.model.SymptomMeta;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.InteractiveTool;
import edu.ncsu.csc.view.PageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static edu.ncsu.csc.controller.PatientPages.CheckIn.*;


public class CheckIn extends BasePage implements PageView {
    private Symptom symptom;
    SymptomsManager symm;

    public CheckIn() {
        choicePrompt = "Enter Choice (1-3)";
        pageTitle = "==================== CHECKIN ====================";
        symm = new SymptomsManager();
        List<String> symptoms = symm.getSymtomsMenu();
        for (int i = 0; i < symptoms.size(); i++) {
            menueStrs.add(symptoms.get(i));
        }
        menueStrs.add("Other");
        menueStrs.add("Done");

    }

    @Override
    public void display() {
        running = true;
        SymptomMeta smeta;
        while (running) {
            initPage();
            while (running) {
                initPage();
                int index = getChoice(menueStrs);
                if (index <= (menueStrs.size() - 2)) {
                    symptom = symm.getSymtomsSelection(index);
                    PageView p = new InputSymptomMeta(symptom);
                    p.display();
                    smeta = ((InputSymptomMeta) p).getSm();
                } else if (index == menueStrs.size() - 1) {
                    String smname = getStringFromInput("input a symptom :");
                    symptom = new Symptom(smname, "unknow");
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
