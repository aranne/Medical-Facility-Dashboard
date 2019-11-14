package edu.ncsu.csc.controller.PatientPages;

import edu.ncsu.csc.DAO.SeverityDAOImp;
import edu.ncsu.csc.DAO.SymptomDAOImpl;
import edu.ncsu.csc.model.BodyPart;
import edu.ncsu.csc.model.Severity;
import edu.ncsu.csc.model.Symptom;

import java.util.ArrayList;
import java.util.List;

public class CheckinSymptomMeta {
    private List<Severity> severities;
    private List<BodyPart> bodyparts;
    private Symptom symptom;
    public CheckinSymptomMeta(Symptom symptom) {
        this.symptom=symptom;
        reLoad();
    }
    public void reLoad(){
        SeverityDAOImp severdao=new SeverityDAOImp();
        severities=severdao.getAllValues();
        SymptomDAOImpl symps=new SymptomDAOImpl();
        bodyparts=symps.getBodysbySymptom(symptom);
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
