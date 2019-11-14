package edu.ncsu.csc.controller;

import edu.ncsu.csc.model.BodyPart;
import edu.ncsu.csc.model.Severity;
import edu.ncsu.csc.model.Symptom;

import java.util.ArrayList;
import java.util.List;

public class SymptomMetaManager {
    private List<Severity> severities;
    private List<BodyPart> bodyparts;
    private Symptom symptom;
    public SymptomMetaManager(Symptom symptom) {
        this.symptom=symptom;
        reLoad();
    }
    public void reLoad(){
//        severities=
//                bodyparts=
    }
    public List<String> getBodyMenu(){
        List<String> choices = new ArrayList<String>(0);
        for(int i=0;i<bodyparts.size();i++)
        {
            choices.add(bodyparts.get(i).getBodyName());
        }
        return choices;
    }
    public List<String> getSeverityMenu(){
        List<String> choices = new ArrayList<String>(0);
        for(int i=0;i<severities.size();i++)
        {
            choices.add(severities.get(i).getName());
        }
        return choices;
    }
    public Severity getSeveritySelection(int index){
        return severities.get(index);
    }

    public BodyPart getBodySelection(int index){
        return bodyparts.get(index);
    }
}
