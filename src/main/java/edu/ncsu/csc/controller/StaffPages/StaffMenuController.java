package edu.ncsu.csc.controller.StaffPages;


import edu.ncsu.csc.DAO.CheckInDAOImp;
import edu.ncsu.csc.DAO.TemplateDAO;
import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.MedicalFacility;

import java.util.ArrayList;
import java.util.List;
// similarity with ChecKInManager,use this class to manage the "Treated Patient list"
public class StaffMenuController {

    List<CheckIn> checkedinPatientsList;
    List<CheckIn> treatedPatientsList;
    MedicalFacility medicalFacility;


    public StaffMenuController(MedicalFacility medicalFacility){
        this.medicalFacility = medicalFacility;
        reloadCheckinList();
    }
    public void reloadCheckinList(){
        reload();
    }
    public void reload(){
        TemplateDAO<CheckIn> checkDao = new CheckInDAOImp();
        //应该获取treated patient list
        checkedinPatientsList = ((CheckInDAOImp) checkDao).getAllCheckedInPatientsByFacility(medicalFacility);
        treatedPatientsList = ((CheckInDAOImp) checkDao).getAllTreatedPatientsByFacility(medicalFacility);
    }
    public  List<String> getCheckedinPatientChoices(){
        List<String> choices = new ArrayList<String>(0);
        for(int i = 0; i< checkedinPatientsList.size(); i++)
        {
                choices.add(checkedinPatientsList.get(i).getLastName());
        }
        return choices;
    }
    public  List<String> getTreatedPatientChoices(){
        List<String> choices = new ArrayList<String>(0);
        for(int i = 0; i< treatedPatientsList.size(); i++)
        {
            choices.add(treatedPatientsList.get(i).getLastName());
        }
        return choices;
    }

    public CheckIn getCheckInSelection(int index){
        if(index<0 || index> checkedinPatientsList.size())
            throw new NullPointerException("invalidate checkin index");
        return checkedinPatientsList.get(index - 1);
    }

    public CheckIn getTreatedSelection(int index){
        if(index<0 || index> treatedPatientsList.size())
            throw new NullPointerException("invalidate checkin index");
        return treatedPatientsList.get(index - 1);
    }

    public  boolean treating(CheckIn checkin){
        return false;
    }

}
