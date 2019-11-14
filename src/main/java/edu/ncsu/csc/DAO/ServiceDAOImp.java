package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Service;

import java.util.List;

public class ServiceDAOImp  extends AbstractDAO implements TemplateDAO<Service>{
    @Override
    public boolean addOneValue(Service p) {
        return false;
    }

    @Override
    public List<Service> getAllValues() {
        return null;
    }

    @Override
    public List<Service> getBatchByQuery(String queryStr) {
        return null;
    }

    @Override
    public Service getOneByQuery(String queryStr) {
        return null;
    }

    @Override
    public Service getOneById(int id) {
        return null;
    }

    @Override
    public Service getOneById(String id) {
        return null;
    }

    @Override
    public boolean updateValue(Service p) {
        return false;
    }

    @Override
    public boolean deleteRecord(Service p) {
        return false;
    }
}
