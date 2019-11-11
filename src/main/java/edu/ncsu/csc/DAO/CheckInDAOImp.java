package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.CheckIn;

import java.sql.SQLException;
import java.util.List;

public class CheckInDAOImp extends AbstractDAO implements CheckInDAO {
  @Override
  public void addCheckIn(CheckIn c) {
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("insert into check_ins (last_name, dob, start_time, facility_id)" +
                      " values (?, ?, ?, ?)");
      preparedStatement.setString(1, c.getLastName());
      preparedStatement.setDate(2, new java.sql.Date(c.getDob().getTime()));
      preparedStatement.setDate(3, new java.sql.Date(System.currentTimeMillis())); // Get current System Time
      preparedStatement.setInt(4, c.getFacilityId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
  }

  @Override
  public List<CheckIn> getAllCheckIn() {
    return null;
  }

  @Override
  public CheckIn getCheckInByPatientId() {
    return null;
  }

  @Override
  public CheckIn getCheckInByFacilityId() {
    return null;
  }

  @Override
  public void updateCheckIn(CheckIn c) {

  }

  @Override
  public void deleteCheckIn(CheckIn c) {

  }

  @Override
  public void setCheckInEndTime(CheckIn c) {

  }
}
