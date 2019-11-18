package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.NegativeExperience;

import java.util.Date;
import java.util.List;

public class NegativeExpeDAOImp extends AbstractDAO implements TemplateDAO<NegativeExperience> {

    @Override
    public boolean addOneValue(NegativeExperience p) {
        return false;
    }

    // TODO for sample query five
    @Override
    public List<NegativeExperience> getAllValues() {
        return null;
    }

    @Override
    public List<NegativeExperience> getBatchByQuery(String queryStr) {
        return null;
    }

    @Override
    public NegativeExperience getOneByQuery(String queryStr) {
        return null;
    }

    @Override
    public NegativeExperience getOneById(int id) {
        return null;
    }

    @Override
    public NegativeExperience getOneById(String id) {
        return null;
    }

    @Override
    public boolean updateValue(NegativeExperience p) {
        return false;
    }

    @Override
    public boolean deleteRecord(NegativeExperience p) {
        return false;
    }

    //TODO for sample queries
    public List<NegativeExperience> getAllByNameAndDob(String lastName, Date dob, Date time) {
        return null;
    }
}
