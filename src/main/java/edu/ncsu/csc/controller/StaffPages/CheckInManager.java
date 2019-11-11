package edu.ncsu.csc.controller.StaffPages;

import edu.ncsu.csc.DAO.CheckInDAOImp;
import edu.ncsu.csc.model.CheckIn;
import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.util.ArrayList;
import java.util.List;

public class CheckInManager {
    List<CheckIn> checkIns;

    public CheckIn checkIn=null;
    public CheckInManager(){
        reloadCheckinList();
    }
    public void reloadCheckinList(){
        CheckInDAOImp checkDao=new CheckInDAOImp();
        checkIns=checkDao.getAllCheckIn();//c.getAllValues();
    }
    public  List<String> getChechinChoices(){
        List<String> choices = new ArrayList<String>(checkIns.size());
        for(int i=0;i<checkIns.size();i++)
        {
            choices.add(checkIns.get(i).getLastName());
        }
        return choices;
    }
    public void setChoosedCheckin(int index){
        if(index<0 || index>=checkIns.size())
            throw new ValueException("invalidate checkin idnex");
        checkIn=checkIns.get(index);
    }
    public CheckIn getCheckIn() {
        if(null==checkIn)
            throw new ValueException("must choose a checkIn before entering a vital!!");
        return checkIn;
    }
}
