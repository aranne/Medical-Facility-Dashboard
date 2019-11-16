package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.model.Symptom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientDAOImp extends AbstractDAO implements TemplateDAO<Patient> {
  public void addPatient(Patient p) {

  }

  public List<Patient> getAllPatient() {
    return null;
  }

  public Patient getPatientById(int id) {
    Patient patient = null;
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("select * from PATIENTS where patient_id = ?");
      preparedStatement.setInt(1, id);
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
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

  public Patient patientExist(String lastName,Date dob) {
    Patient patient = null;
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("select * from PATIENTS where last_name = ? and dob = ?");
      preparedStatement.setString(1,lastName);
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

  public Patient treatedPatient(Date treatmentDate) {
    Patient patient = null;
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("select * from PATIENTS where treatment_time = ?");
      preparedStatement.setDate(1, new java.sql.Date(treatmentDate.getTime()));
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


  public void addFacility(Patient p) {
    try {
      openConnection();
      for (MedicalFacility f : p.getFacilities()) {
        preparedStatement = connection
                .prepareStatement("insert into PATIENT_HAS_FACILITY values (?, ?, ?)");
        preparedStatement.setInt(1, f.getFacilityId());
        preparedStatement.setDate(2, new java.sql.Date(p.getDob().getTime()));
        preparedStatement.setString(3, p.getLastName());
        preparedStatement.executeUpdate();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
  }

  public boolean patientInFacility(int facilityId,Patient p) {
    boolean rest=false;
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("select * from patient_has_facility where dob = ? and last_name = ? and facility_id= ?");
      preparedStatement.setDate(1, new java.sql.Date(p.getDob().getTime()));
      preparedStatement.setString(2, p.getLastName());
      preparedStatement.setInt(3,facilityId);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        rest=true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return rest;
  }
  public boolean registerToFacility(int facilityId,Patient p) {
    boolean rest=false;
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("insert into patient_has_facility (facility_id, dob, last_name) values (?, ?, ?)");
      preparedStatement.setInt(1, facilityId);
      preparedStatement.setDate(2, new java.sql.Date(p.getDob().getTime()));
      preparedStatement.setString(3, p.getLastName());
      preparedStatement.executeUpdate();
      rest=true;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return rest;
  }
  @Override
  public boolean addOneValue(Patient p) {
    boolean rest=false;
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
      rest=true;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return rest;
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
  public Patient getOneByQuery(String queryStr) {
    Patient patient = null;
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("select * from PATIENTS where"+queryStr);
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

  @Override
  public Patient getOneById(int id) {
    return null;
  }

  @Override
  public Patient getOneById(String id) {
    return null;
  }


  @Override
  public boolean updateValue(Patient p) {
    boolean rest=false;
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
      rest=true;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return rest;
  }

  public boolean updateTreatment(Patient p) {
    boolean rest = false;
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("update patients set treatment_time = ? where patient_id = ?");
      preparedStatement.setDate(1, new java.sql.Date(p.getTreatmentDate().getTime()));
      preparedStatement.setInt(2, p.getId());
      preparedStatement.executeUpdate();
      rest = true;
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return rest;
  }

  @Override
  public boolean deleteRecord(Patient p) {
    return false;
  }


}
