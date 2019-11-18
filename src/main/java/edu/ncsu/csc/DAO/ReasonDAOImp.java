package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Reason;

import java.util.List;

public class ReasonDAOImp extends AbstractDAO implements TemplateDAO<Reason> {

    @Override
    public boolean addOneValue(Reason p) {
        return false;
    }

    @Override
    public List<Reason> getAllValues() {
        return null;
    }

    @Override
    public List<Reason> getBatchByQuery(String queryStr) {
        return null;
    }

    @Override
    public Reason getOneByQuery(String queryStr) {
        return null;
    }

    @Override
    public Reason getOneById(int id) {
        return null;
    }

    @Override
    public Reason getOneById(String id) {
        return null;
    }

    @Override
    public boolean updateValue(Reason p) {
        return false;
    }

    @Override
    public boolean deleteRecord(Reason p) {
        return false;
    }
}
