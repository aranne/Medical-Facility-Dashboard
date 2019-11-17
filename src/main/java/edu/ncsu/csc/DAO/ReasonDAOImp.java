package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Reason;

import java.sql.SQLException;
import java.util.List;

public class ReasonDAOImp extends AbstractDAO implements TemplateDAO<Reason> {
    @Override
    public boolean addOneValue(Reason p) {
        boolean reason = true;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("INSERT INTO REASONS " +
                            "(REASON_CODE, DESCRIPTION, SERVICE_CODE, TIME,DOB,LAST_NAME) " +
                            "values (?, ?, ?, ?,?,?)");
            preparedStatement.setString(1, p.getReasonCode());
            preparedStatement.setString(2, p.getDescription());
            preparedStatement.setString(3, p.getServiceCode());
            preparedStatement.setTimestamp(4, new java.sql.Timestamp(p.getTime().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(p.getDob().getTime()));
            preparedStatement.setString(6, p.getLastName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            reason = false;
        } finally {
            closeConnection();
        }
        return reason;

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
