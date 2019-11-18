package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.PatientSymMeta;

import java.util.List;

public class SymptomMetaDAOImp extends AbstractDAO implements TemplateDAO<PatientSymMeta> {

    @Override
    public boolean addOneValue(PatientSymMeta p) {
        return false;
    }

    @Override
    public List<PatientSymMeta> getAllValues() {
        return null;
    }

    // TODO for sample query four
    @Override
    public List<PatientSymMeta> getBatchByQuery(String queryStr) {
        return null;
    }

    @Override
    public PatientSymMeta getOneByQuery(String queryStr) {
        return null;
    }

    @Override
    public PatientSymMeta getOneById(int id) {
        return null;
    }

    @Override
    public PatientSymMeta getOneById(String id) {
        return null;
    }

    @Override
    public boolean updateValue(PatientSymMeta p) {
        return false;
    }

    @Override
    public boolean deleteRecord(PatientSymMeta p) {
        return false;
    }
}
