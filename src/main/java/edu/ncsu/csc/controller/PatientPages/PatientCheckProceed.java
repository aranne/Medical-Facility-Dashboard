package edu.ncsu.csc.controller.PatientPages;

import edu.ncsu.csc.DAO.CheckInDAOImp;
import edu.ncsu.csc.DAO.ReportDAOImp;
import edu.ncsu.csc.DAO.SymptomDAOImp;
import edu.ncsu.csc.DAO.TemplateDAO;
import edu.ncsu.csc.model.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientCheckProceed {
    MedicalFacility facility ;
    List<Symptom> symptoms;
    public PatientCheckProceed(MedicalFacility facility) {
        this.facility =facility ;
        reload();
    }
    public  void reload(){
        SymptomDAOImp patientPagesDao = new SymptomDAOImp();
        symptoms = patientPagesDao.getAllValues();
    }
    public CheckIn getCheckin(Patient p){
        TemplateDAO<CheckIn> chdao = new CheckInDAOImp();
        return chdao.getOneByQuery("last_name= ? and dob =?");
    }
    public Report getReport(Patient p){
        ReportDAOImp chdao = new ReportDAOImp();
        String lastName = p.getLastName();
        Date dob = p.getDob();
        Report r = chdao.getReportByNameAndDob(lastName, dob);
        return r;
//        ("last_name = lastName and dob = dob");
//        return chdao.getOneByQuery("last_name = lastName and dob = dob");
//        return chdao.getOneByQuery("last_name= ? and dob =?");
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

}
