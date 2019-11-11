package edu.ncsu.csc.controller.StaffPages;


import java.util.ArrayList;
import java.util.List;
// similarity with ChecKInManager,use this calss to manage the "Trated Patient list"
public class TreatedPatients {

//    List<CheckIn> checkIns;

//    public CheckIn checkIn=null;

    public TreatedPatients(){
        //reloadCheckinList();
    }
//    public void reloadCheckinList(){
//        CheckInDAO checkDao=new CheckInDAOImp();
//        checkIns=checkDao.getAllCheckIn();
//    }
    public  List<String> getChechinChoices(){
        List<String> choices = new ArrayList<String>(0);
//        for(int i=0;i<checkIns.size();i++)
//        {
//            choices.add(checkIns.get(i).getLastName());
//        }
        return choices;
    }
//    public void setChoosedCheckin(int index){
//        if(index<0 || index>=checkIns.size())
//            throw new ValueException("invalidate checkin idnex");
//        checkIn=checkIns.get(index);
//    }
//    public CheckIn getCheckIn() {
//        if(null==checkIn)
//            throw new ValueException("must choose a checkIn before entering a vital!!");
//        return checkIn;
//    }
}
