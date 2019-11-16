package edu.ncsu.csc.controller.StaffPages;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.ncsu.csc.DAO.CheckInDAOImp;
import edu.ncsu.csc.DAO.VitalDAOImp;
import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.Staff;
import edu.ncsu.csc.model.Vital;
//Staff process patient page
public class StaffProcessPatient {
    //Checked-in patient list
    List<CheckIn> checkIns;
    public StaffProcessPatient(){
        reloadCheckinList();
    }
    public void reloadCheckinList(){
        reload();
    }
    public void reload(){
        CheckInDAOImp checkDao=new CheckInDAOImp();
        checkIns=checkDao.finishCheckins();
    }
    public CheckIn getCheckInSelection(int index){
        if(index<0 || index>=checkIns.size())
            throw new NullPointerException("invalidate checkin idnex");
        return checkIns.get(index);
    }
    //输入Vital并更新staff_records_vital和CheckIns里的数据
    public boolean enterVital(Vital vital,CheckIn checkin,Staff staff){
        boolean rest=false;
        VitalDAOImp vidao=new VitalDAOImp();
        rest= vidao.addVitalStaff(vital,staff);
        CheckInDAOImp checkdao=new CheckInDAOImp();
        checkin.setEndTime(new Date(System.currentTimeMillis()));
        rest= rest && checkdao.updateValue(checkin);
        return rest;
    }
    public  boolean checkPrivilege(CheckIn checkin, Staff staff){
        System.out.println("can not find in database:check if user could\r\n" +
                "treat body part\r\n" +
                "associated to patient\r\n" +
                "symptoms, if yes, move\r\n" +
                "patient to treated list,");
//        StaffDAOImp staffdao=new StaffDAOImp();
//        List<BodyPart> bodys=staffdao.getBodysCanTreatByStaff(staff);
//
//        SymptomDAOImpl sydao=new SymptomDAOImpl();
//        Symptom symptom=sydao.getSymptomByCheckin(checkin);
//
//        List<BodyPart> bodys1=sydao.getBodysbySymptom(symptom);
//
//        return staffdao.staffInFacility(checkin.getFacilityId(),staff);
        return false;
    }
}