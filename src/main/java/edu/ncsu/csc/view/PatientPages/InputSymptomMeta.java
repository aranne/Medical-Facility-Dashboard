package edu.ncsu.csc.view.PatientPages;

import edu.ncsu.csc.controller.PatientPages.CheckinSymptomMeta;
import edu.ncsu.csc.model.BodyPart;
import edu.ncsu.csc.model.Symptom;
import edu.ncsu.csc.model.SymptomMeta;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.ComboBoxPage;
import edu.ncsu.csc.view.PageView;

import java.util.List;

public class InputSymptomMeta extends BasePage implements PageView {
    SymptomMeta sm;
    CheckinSymptomMeta smm;
    public SymptomMeta getSm() {
        return sm;
    }

    public InputSymptomMeta(Symptom s) {
        choicePrompt = "Enter Choice (1-4)";
        pageTitle = "#Symptom meta";
        menueStrs.add("Body part");
        menueStrs.add("Duration");
        menueStrs.add("Reoccurring?");
        menueStrs.add("Severity");
        menueStrs.add("Cause(Incident)");
        smm=new CheckinSymptomMeta(s);
        sm=new SymptomMeta();
//        bps = (List<Bodypart>) s.getBodypartys();
//        if(bps.size()<=0)
//        {
//            SelectAllDao sd=new SelectAllDao();
//            bps=sd.getAllBodyparts();
//        }
//        sm = new Symptommeta();
//        sm.setSymptom(s);
//        sc=s.getScaletype();
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
                    inputDure();
                    break;
                case 3:
                    inputReoccur();
                    break;
                case 4:
                    inputSeverity();
                    break;
                case 5:
                    inputCause();
                default:
                    break;
            }
            if (!getStringFromInput("continue to input(y/n)?").equals("y")) {
                running = false;
            }

        }
    }

    public void inputPart() {

        List<String> bps=smm.getBodyMenu();

        if (bps.size() > 0) {
            int ch =ComboBoxPage.getInstance().select(bps,"choose a bodypart:");
            sm.setBodypart(smm.getBodySelection(ch));
        } else {
            String bodypart = getStringFromInput("input a bodypart name:");
            //TODO
            sm.setBodypart(new BodyPart(bodypart,bodypart));
        }

    }

    public void inputDure() {
        sm.setDuration(getRealValue("input Duration:"));
    }

    public void inputReoccur() {
        String s = "";
        do {
            s = getStringFromInput("Reoccurring(yes/no)?");
        } while (!s.equals("yes") || !s.equals("no"));
        if (s.equals("yes"))
            sm.setNeworre(true);
        else
            sm.setNeworre(false);
    }

    //TODO
    public void inputSeverity() {
//        if (sc != null) {
//            String[] vs = sc.getValues().split(",");
//
//            if (sc.getType().equals("number")) {
//                sm.setSeverity(String.valueOf(getNum("input a value")));
//            } else if (sc.getType().equals("realvalue")) {
//                sm.setSeverity(String.valueOf(getRealValue("input a value")));
//            } else if (sc.getType().equals("level")) {
//                show("choose a severity");
//                sm.setSeverity(vs[getChoice(vs.length) - 1]);
//            }
//        } else
//            show("thsi symptom has no avaliable Severity");
    }

    public void inputCause() {
        sm.setIncident(getStringFromInput("input a Cause"));
    }


}
