package edu.ncsu.csc.controller.StaffPages;

import edu.ncsu.csc.DAO.BodyPartDAO;
import edu.ncsu.csc.DAO.SymptomDAOImpl;
import edu.ncsu.csc.DAO.TemplateDAO;
import edu.ncsu.csc.model.BodyPart;
import edu.ncsu.csc.model.Symptom;

import java.util.ArrayList;
import java.util.List;

public class SymptomsManager {
    List<Symptom> symptoms;
    List<BodyPart> bodyParts;
    public SymptomsManager(){
        reloadDatas();
    }
    public void reloadDatas(){
        TemplateDAO m_dao=new SymptomDAOImpl();
        symptoms=m_dao.getAllValues();
        TemplateDAO m_dao1=new BodyPartDAO();
        bodyParts=m_dao1.getAllValues();
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
    public Symptom getSymtomsSelection(int index ){
        return symptoms.get(index);
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
    public List<BodyPart> getSlected(String[] indexs){
        List<BodyPart> seleteds=new ArrayList<BodyPart>(0);
        for(int i=0;i<indexs.length;i++)
        {
            seleteds.add(bodyParts.get(Integer.parseInt(indexs[i])));
        }
        return seleteds;
    }
    public List<String> getBodyPartsMenu(){
        List<String> choices = new ArrayList<String>(bodyParts.size());
        for(int i=0;i<bodyParts.size();i++)
        {
            choices.add(bodyParts.get(i).getBodyName());
        }
        return choices;
    }
    public  void addSymptom(String name,String code,String[] indexs){

        if(null==indexs)
        {
            //symptom can associated all bodypart;
        }else{
            TemplateDAO m_dao=new SymptomDAOImpl();
                Symptom s=new Symptom(name,code);
                List<BodyPart> bodies=getSlected(indexs);
//                m_dao.addSymptomWithBody(s,bodies);
        }

    }

    public boolean submit(Symptom symptom, SymptomsManager symm) {
        return false;
    }
}
