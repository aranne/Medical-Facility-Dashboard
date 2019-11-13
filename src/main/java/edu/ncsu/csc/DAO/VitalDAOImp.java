package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Vital;

import java.util.List;

public class VitalDAOImp extends AbstractDAO implements TemplateDAO<Vital> {


    @Override
    public boolean addOneValue(Vital p) {

        return false;
    }

    @Override
    public List<Vital> getAllValues() {
        return null;
    }

    @Override
    public List<Vital> getBatchByQuery(String queryStr) {
        return null;
    }

    @Override
    public Vital getOneByQuery(String queryStr) {
        return null;
    }


    @Override
    public Vital getOneById(int id) {
        return null;
    }

    @Override
    public Vital getOneById(String id) {
        return null;
    }

    @Override
    public boolean updateValue(Vital p) {

        return false;
    }

    @Override
    public boolean deleteRecord(Vital p) {

        return false;
    }
}
