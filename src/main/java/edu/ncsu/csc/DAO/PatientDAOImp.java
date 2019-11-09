package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PatientDAOImp extends AbstractDAO implements PatientDAO {
  public void addPatient(Patient p) {
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("insert into PATIENTS " +
                      "(FIRST_NAME, LAST_NAME, DOB, Address_Country, Address_State, Address_City, Address_Street, Address_Zip, Phone) " +
                      "values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
      preparedStatement.setString(1, p.getFirstName());
      preparedStatement.setString(2, p.getLastName());
      preparedStatement.setDate(3, new java.sql.Date(p.getDob().getTime()));
      preparedStatement.setString(4, p.getAddrCountry());
      preparedStatement.setString(5, p.getAddrState());
      preparedStatement.setString(6, p.getAddrCity());
      preparedStatement.setString(7, p.getAddrStreet());
      preparedStatement.setInt(8, p.getAddrZip());
      preparedStatement.setString(9, p.getPhone());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
  }

  public List getAllPatient() {
    return null;
  }

  public Patient getPatientById(int id) {
    return null;
  }

  public Patient getPatientByNameAndDob(String lastName, Date dob) {
    Patient patient = null;
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("select * from PATIENTS where last_name = ? and dob = ?");
      preparedStatement.setString(1, lastName);
      preparedStatement.setDate(2, new java.sql.Date(dob.getTime()));
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        patient = new Patient(
                resultSet.getInt("patient_id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getDate("dob"),
                resultSet.getString("phone"),
                resultSet.getString("address_country"),
                resultSet.getString("address_state"),
                resultSet.getString("address_city"),
                resultSet.getString("address_street"),
                resultSet.getInt("address_zip"),
                resultSet.getString("priority_status"),
                resultSet.getDate("treatment_time")
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return patient;
  }

  public void updatePatient(Patient p) {

  }

  public void deletePatient(Patient p) {

  }

  @Override
  public void addFacility(Patient p, MedicalFacility f) {
    int facilityId = f.getFacilityId();
    try {
      preparedStatement = connection
              .prepareStatement("insert into PATIENT_HAS_FACILITY values (?, ?, ?)");
      preparedStatement.setInt(1, f.getFacilityId());
      preparedStatement.setDate(2, new java.sql.Date(p.getDob().getTime()));
      preparedStatement.setString(3, p.getLastName());
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
  }
}
