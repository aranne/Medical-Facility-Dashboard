package edu.ncsu.csc.controller.StaffPages;


import edu.ncsu.csc.DAO.CheckInDAOImp;
import edu.ncsu.csc.DAO.TemplateDAO;
import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.MedicalFacility;

import java.util.ArrayList;
import java.util.List;
// similarity with ChecKInManager,use this calss to manage the "Trated Patient list"
public class StaffMenuController {

    List<CheckIn> checkIns;


    public StaffMenuController(){
        reloadCheckinList();
    }
    public void reloadCheckinList(){
        reload();
    }
    public void reload(){
        TemplateDAO<CheckIn> checkDao=new CheckInDAOImp();
        //应该获取treated patient lsit
        checkIns=checkDao.getAllValues();
    }
    public  List<String> getChechinChoices(MedicalFacility facility){
        List<String> choices = new ArrayList<String>(0);
        for(int i=0;i<checkIns.size();i++)
        {
            if (checkIns.get(i).getFacilityId().equals(facility.getFacilityId())) {
                choices.add(checkIns.get(i).getLastName());
            }
        }
        return choices;
    }
    public CheckIn getCheckInSelection(int index){
        if(index<0 || index>=checkIns.size())
            throw new NullPointerException("invalidate checkin idnex");
        return checkIns.get(index - 1);
    }
    
    
    public  boolean treating(CheckIn checkin){
        return false;
    }

}
