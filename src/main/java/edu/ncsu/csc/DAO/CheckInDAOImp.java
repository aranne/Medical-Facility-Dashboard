package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.Patient;

import java.sql.SQLException;
import java.util.ArrayList;
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
  public List<CheckIn> getAllCheckInByPatientIdAndFacilityId(int patientId, int facilityId) {
    PatientDAOImp patientDao = new PatientDAOImp();
    Patient p = patientDao.getPatientById(patientId);
    List<CheckIn> checkIns = new ArrayList<>();
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("select * from CHECK_INS where last_name = ? and dob = ? and facility_id = ?");
      preparedStatement.setString(1, p.getLastName());
      preparedStatement.setDate(2, new java.sql.Date(p.getDob().getTime()));
      preparedStatement.setInt(3, facilityId);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        CheckIn checkIn = new CheckIn(
                resultSet.getInt("id"),
                resultSet.getString("last_name"),
                resultSet.getDate("dob"),
                resultSet.getDate("start_time"),
                resultSet.getDate("end_time"),
                resultSet.getInt("facility_id")
        );
        checkIns.add(checkIn);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return checkIns;
  }

  @Override
  public List<CheckIn> getAllCheckInByFacilityId(int facilityId) {
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
