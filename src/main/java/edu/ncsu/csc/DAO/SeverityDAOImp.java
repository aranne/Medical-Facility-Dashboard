package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Severity;

import java.util.List;

public class SeverityDAOImp extends AbstractDAO implements TemplateDAO<Severity> {

    @Override
    public boolean addOneValue(Severity p) {
        return false;
    }

    @Override
    public List<Severity> getAllValues() {
        return null;
    }

    @Override
    public List<Severity> getBatchByQuery(String queryStr) {
        return null;
    }

    @Override
    public Severity getOneByQuery(String queryStr) {
        return null;
    }

    @Override
    public Severity getOneById(int id) {
        return null;
    }

    @Override
    public Severity getOneById(String id) {
        return null;
    }

    @Override
    public boolean updateValue(Severity p) {
        return false;
    }

    @Override
    public boolean deleteRecord(Severity p) {
        return false;
    }
}
