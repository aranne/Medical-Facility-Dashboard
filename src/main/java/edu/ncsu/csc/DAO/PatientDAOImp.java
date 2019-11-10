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

  public List<Patient> getAllPatient() {
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
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("update patients " +
                      "set first_name = ?, last_name = ?, dob = ?, phone = ?, " +
                      "address_country = ?, address_state = ?, address_city = ?, address_street = ?, address_zip = ?, priority_status = ?, treatment_time = ?" +
                      "where patient_id = ?");
      preparedStatement.setString(1, p.getFirstName());
      preparedStatement.setString(2, p.getLastName());
      preparedStatement.setDate(3, new java.sql.Date(p.getDob().getTime()));
      preparedStatement.setString(4, p.getPhone());
      preparedStatement.setString(5, p.getAddrCountry());
      preparedStatement.setString(6, p.getAddrState());
      preparedStatement.setString(7, p.getAddrCity());
      preparedStatement.setString(8, p.getAddrStreet());
      preparedStatement.setInt(9, p.getAddrZip());
      preparedStatement.setString(10, p.getPriorityStatus());
      if (p.getTreatmentDate() == null) {
        preparedStatement.setDate(11, null);
      } else {
        preparedStatement.setDate(11, new java.sql.Date(p.getTreatmentDate().getTime()));
      }
      preparedStatement.setInt(12, p.getId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
  }

  public void deletePatient(Patient p) {

  }


  public void addFacility(Patient p) {
    try {
      openConnection();
      for (MedicalFacility f : p.getFacilities()) {
        int facilityId = f.getFacilityId();
        preparedStatement = connection
                .prepareStatement("insert into PATIENT_HAS_FACILITY values (?, ?, ?)");
        preparedStatement.setInt(1, f.getFacilityId());
        preparedStatement.setDate(2, new java.sql.Date(p.getDob().getTime()));
        preparedStatement.setString(3, p.getLastName());
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
  }
}
