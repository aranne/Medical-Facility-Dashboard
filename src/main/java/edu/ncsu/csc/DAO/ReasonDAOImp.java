package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Reason;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

    public List<Reason> getAllByNameAndDob(String lastName, Date dob, Date time) {
        List<Reason> reasons = new ArrayList<>();
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select * from REASONS where last_name = ? and dob = ? and time = ?");
            preparedStatement.setString(1, lastName);
            preparedStatement.setDate(2, new java.sql.Date(dob.getTime()));
            preparedStatement.setTimestamp(3,new java.sql.Timestamp(time.getTime()));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                reasons.add(new Reason(
                        resultSet.getInt("id"),
                        resultSet.getString("reason_code"),
                        resultSet.getString("description"),
                        resultSet.getString("service_code"),
                        resultSet.getDate("time"),
                        resultSet.getDate("dob"),
                        resultSet.getString("last_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return reasons;
    }
}
