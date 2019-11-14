package edu.ncsu.csc.controller.StaffPages;

import edu.ncsu.csc.DAO.BodyPartDAO;
import edu.ncsu.csc.DAO.SymptomDAOImpl;
import edu.ncsu.csc.DAO.TemplateDAO;
import edu.ncsu.csc.model.BodyPart;
import edu.ncsu.csc.model.Symptom;

import java.util.ArrayList;
import java.util.List;

public class AddAssessments {
    List<Symptom> symptoms;
    public AddAssessments(){
        reloadDatas();
    }
    public void reloadDatas(){
        TemplateDAO m_dao=new SymptomDAOImpl();
        symptoms=m_dao.getAllValues();
    }
    public List<BodyPart> getBodyparts(Symptom s){
        BodyPartDAO m_dao=new BodyPartDAO();
        return m_dao.getSymptomBodies(s);
    }
    public List<String> getSymtomsMenu(){
        List<String> choices = new ArrayList<String>(symptoms.size());
        for(int i=0;i<symptoms.size();i++)
        {
            choices.add(symptoms.get(i).getName());
        }
        return choices;
    }
    public List<String> getBodyPartsMenu(int index){
        List<BodyPart> bodies=getBodyparts(symptoms.get(index));
        List<String> choices = new ArrayList<String>(bodies.size());
        for(int i=0;i<bodies.size();i++)
        {
            choices.add(bodies.get(i).getBodyName());
        }
        return choices;
    }
    public void addRule(String body_code,String sym_code,int low,int hight){
//        symptoms=...
//                bodyParts=....;
    }
}
