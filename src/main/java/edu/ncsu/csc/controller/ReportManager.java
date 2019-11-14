package edu.ncsu.csc.controller;

import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.DAO.ServiceDAOImp;
import edu.ncsu.csc.DAO.TemplateDAO;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Service;

import java.util.ArrayList;
import java.util.List;

public class ReportManager {
    private List<Service> services;
    private List<MedicalFacility> facilities;
    public ReportManager() {
        reLoad();
    }
    public void reLoad(){
        TemplateDAO<MedicalFacility> tdao=new MedicalFacilityDAOImp();
        facilities=tdao.getAllValues();
        TemplateDAO tdao1=new ServiceDAOImp();
        services=tdao1.getAllValues();
    }


    public List<String> getFacilityMenu(){
        List<String> choices = new ArrayList<String>(0);
        for(int i=0;i<facilities.size();i++)
        {
            choices.add(facilities.get(i).getName());
        }
        return choices;
    }
    public MedicalFacility getMedicalFacilitySelection(int index){
        return  facilities.get(index);
    }



    public List<String> getServiceMenu(){
        List<String> choices = new ArrayList<String>(0);
        for(int i=0;i<services.size();i++)
        {
            choices.add(services.get(i).getName());
        }
        return choices;
    }
    public Service getServiceSelection(int index){
        return services.get(index);
    }
}
