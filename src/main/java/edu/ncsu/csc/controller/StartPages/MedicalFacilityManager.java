package edu.ncsu.csc.controller.StartPages;

import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.DAO.TemplateDAO;
import edu.ncsu.csc.model.MedicalFacility;

import java.util.ArrayList;
import java.util.List;

public class MedicalFacilityManager {
    private List<MedicalFacility> facilities;
    public MedicalFacilityManager() {
        reLoad();
    }

    public void reLoad(){
        TemplateDAO<MedicalFacility> tdao=new MedicalFacilityDAOImp();
        facilities=tdao.getAllValues();
    }

    public List<String> getFacilityMenu(){
        List<String> choices = new ArrayList<String>(0);
        for(int i=0;i<facilities.size();i++)
        {
            choices.add(facilities.get(i).getName());
        }
        return choices;
    }
    public MedicalFacility getFacilitySelection(int index){
        return facilities.get(index-1);
    }
}
