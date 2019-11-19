package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.PatientSymMeta;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SymptomMetaDAOImp extends AbstractDAO implements TemplateDAO<PatientSymMeta> {

    public SymptomMetaDAOImp() {
    }

    @Override
    public boolean addOneValue(PatientSymMeta p) {
        return false;
    }

    @Override
    public List<PatientSymMeta> getAllValues() {
        return null;
    }

    @Override
    public List<PatientSymMeta> getBatchByQuery(String queryStr) {
        List<PatientSymMeta> symMetas = new ArrayList<>();
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select * from patient_sym_meta where " + queryStr);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                symMetas.add(new PatientSymMeta(
                        resultSet.getString("body_code"),
                        resultSet.getString("sym_code"),
                        resultSet.getString("scale"),
                        resultSet.getString("last_name"),
                        resultSet.getDate("dob"),
                        resultSet.getString("duration"),
                        resultSet.getString("cause_incident"),
                        resultSet.getBoolean("first_occurrence")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return symMetas;
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
