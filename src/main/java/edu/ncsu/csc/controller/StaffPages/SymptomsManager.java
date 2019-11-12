package edu.ncsu.csc.controller.StaffPages;

import edu.ncsu.csc.DAO.BodyPartDAO;
import edu.ncsu.csc.DAO.SymptomDAO;
import edu.ncsu.csc.DAO.TemplateDAO;
import edu.ncsu.csc.model.BodyPart;
import edu.ncsu.csc.model.Symptom;

import java.util.ArrayList;
import java.util.List;

public class SymptomsManager {
    public List<BodyPart> getBodyParts() {
        return bodyParts;
    }

    List<BodyPart> bodyParts;
    public SymptomsManager(){
        reloadDatas();
    }
    public List<BodyPart> getSlected(String[] indexs){
        List<BodyPart> seleteds=new ArrayList<BodyPart>(0);
        for(int i=0;i<indexs.length;i++)
        {
            seleteds.add(bodyParts.get(Integer.parseInt(indexs[i])));
        }
        return seleteds;
    }
    public void reloadDatas(){
        TemplateDAO m_dao=new BodyPartDAO();
        bodyParts=m_dao.getAllValues();
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
                SymptomDAO m_dao=new SymptomDAO();
                Symptom s=new Symptom(name,code);
                List<BodyPart> bodies=getSlected(indexs);
                m_dao.addSymptomWithBody(s,bodies);
        }

    }
}
