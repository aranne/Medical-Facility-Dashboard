package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Report;

import java.sql.SQLException;
import java.util.List;

public class ReportDAOImp extends AbstractDAO implements TemplateDAO<Report> {
    @Override
    public boolean addOneValue(Report p) {
    	 boolean rest=true;
         try {
             openConnection();
             preparedStatement = connection
                     .prepareStatement("INSERT INTO reports " +
                             "(time, dob, last_name, discharge_status,treatment,facility_id,employee_id) " +
							"values (?, ?, ?, ?,?,?,?)");
			preparedStatement.setDate(1, new java.sql.Date(p.getTime().getTime()));
			preparedStatement.setDate(2, new java.sql.Date(p.getDob().getTime()));
			preparedStatement.setString(3, p.getLastName());
			preparedStatement.setString(4, p.getDischargeStatus());
			preparedStatement.setString(5, p.getTreatment());
			preparedStatement.setInt(6, p.getFacilityId());
			preparedStatement.setInt(7, p.getEmployeeId());
			preparedStatement.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
             rest=false;
         } finally {
             closeConnection();
         }
         return rest;
    }

    @Override
    public List<Report> getAllValues() {
        return null;
    }

    @Override
    public List<Report> getBatchByQuery(String queryStr) {
        return null;
    }

    @Override
    public Report getOneByQuery(String queryStr) {
        return null;
    }

    @Override
    public Report getOneById(int id) {
        return null;
    }

    @Override
    public Report getOneById(String id) {
        return null;
    }

    @Override
    public boolean updateValue(Report p) {
        return false;
    }

    @Override
    public boolean deleteRecord(Report p) {
        return false;
    }
}
