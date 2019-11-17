package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.NegativeExperience;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class NegativeExpeDAOImp extends AbstractDAO implements TemplateDAO<NegativeExperience> {
    @Override
    public boolean addOneValue(NegativeExperience p) {
        boolean nega = true;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("INSERT INTO NEGATIVE_EXPERIENCES " +
                            "(NEGA_CODE, DESCRIPTION, TIME, DOB,LAST_NAME) " +
                            "values (?, ?, ?, ?,?)");
            preparedStatement.setString(1, p.getNegativeCode());
            preparedStatement.setString(2, p.getDescription());
            preparedStatement.setTimestamp(3, new java.sql.Timestamp(p.getTime().getTime()));
            preparedStatement.setDate(4, new java.sql.Date(p.getDob().getTime()));
            preparedStatement.setString(5, p.getLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            nega = false;
        } finally {
            closeConnection();
        }
        return nega;

    }

    @Override
    public List getAllValues() {
        return null;
    }

    @Override
    public List getBatchByQuery(String queryStr) {
        return null;
    }

    @Override
    public NegativeExperience getOneByQuery(String queryStr) {
        return null;
    }

    public List<NegativeExperience> getAllByNameAndDob(String lastName, Date dob, Date time) {
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
}
