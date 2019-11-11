package edu.ncsu.csc.controller.StaffPages;

import edu.ncsu.csc.DAO.TemplateDAO;
import edu.ncsu.csc.DAO.VitalDAOImp;
import edu.ncsu.csc.model.Vital;

import java.util.Date;

public class InsertVital {
    public static  boolean enterVital(String lName, Date dob,float temperature, float bloodPressureDiastolic, float bloodPressureSystolic){
        Vital vit=new Vital();
        vit.setLastName(lName);
        vit.setDob(dob);
        vit.setTemperature(temperature);
        vit.setBloodPressureDiastolic(bloodPressureDiastolic);
        vit.setBloodPressureSystolic(bloodPressureSystolic);
        TemplateDAO vidao=new VitalDAOImp();
        return vidao.addOneValue(vit);
    }
}
