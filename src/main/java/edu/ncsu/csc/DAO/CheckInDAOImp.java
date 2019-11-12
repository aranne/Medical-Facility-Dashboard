package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.CheckIn;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckInDAOImp extends AbstractDAO implements TemplateDAO<CheckIn> {

  @Override
  public boolean addOneValue(CheckIn p) {
    boolean rest=true;
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("INSERT INTO check_ins (LAST_NAME, DOB, START_TIME, END_TIME,FACILITY_ID) values (?, ?, ?, ?,?)");
      preparedStatement.setString(1, p.getLastName());
      preparedStatement.setDate(2, (Date) p.getDob());
      preparedStatement.setDate(3, (Date) p.getStartTime());
      preparedStatement.setDate(4, (Date) p.getEndTime());
      preparedStatement.setInt(5, p.getFacilityId());
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
  public List<CheckIn> getAllValues() {
    List<CheckIn> rules = null;
    try {
      rules = new ArrayList<CheckIn>(0);
      openConnection();
      preparedStatement = connection
              .prepareStatement("SELECT * FROM check_ins");
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        rules.add(new CheckIn(
                resultSet.getInt("id"),
                resultSet.getString("last_name"),
                resultSet.getDate("dob"),
                resultSet.getDate("start_time"),
                resultSet.getDate("end_time"),
                resultSet.getInt("facility_id")
        ));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return rules;
  }

  @Override
  public List<CheckIn> getBatchByQuery(String queryStr) {
    return null;
  }

  @Override
  public CheckIn getOneByQuery(String queryStr) {
    return null;
  }

  @Override
  public CheckIn getOneById(int id) {
    return null;
  }

  @Override
  public CheckIn getOneById(String id) {
    return null;
  }

  @Override
  public boolean updateValue(CheckIn p) {
    return false;
  }

  @Override
  public boolean deleteRecord(CheckIn p) {
    return false;
  }
}
