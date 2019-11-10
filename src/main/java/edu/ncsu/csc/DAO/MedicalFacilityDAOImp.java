package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.MedicalFacility;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicalFacilityDAOImp extends AbstractDAO implements MedicalFacilityDAO {
  @Override
  public void addFacility(MedicalFacility f) {
  }

  @Override
  public List<MedicalFacility> getAllFacility() {
    List<MedicalFacility> facilities = new ArrayList<>();
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("select * from medical_facilities");
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        facilities.add(new MedicalFacility(
                resultSet.getInt("facility_id"),
                resultSet.getString("name"),
                resultSet.getString("classification"),
                resultSet.getString("address"),
                resultSet.getString("capacity")
        ));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return facilities;
  }

  @Override
  public MedicalFacility getFacilityById(int id) {
    MedicalFacility f = null;
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("select * from medical_facilities where facility_id = ?");
      preparedStatement.setInt(1, id);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        f = new MedicalFacility(
                resultSet.getInt("facility_id"),
                resultSet.getString("name"),
                resultSet.getString("classification"),
                resultSet.getString("address"),
                resultSet.getString("capacity")
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return f;
  }

  @Override
  public void updateFacility(MedicalFacility m) {

  }

  @Override
  public void deleteFacility(MedicalFacility m) {

  }
}