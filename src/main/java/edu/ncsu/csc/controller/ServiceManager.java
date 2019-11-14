package edu.ncsu.csc.controller;

import edu.ncsu.csc.DAO.ServiceDAOImp;
import edu.ncsu.csc.DAO.TemplateDAO;
import edu.ncsu.csc.model.Service;

import java.util.ArrayList;
import java.util.List;

public class ServiceManager {
    public ServiceManager() {
        reLoad();
    }
    public void reLoad(){
        TemplateDAO tdao=new ServiceDAOImp();
        services=tdao.getAllValues();
    }
    private List<Service> services;

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
