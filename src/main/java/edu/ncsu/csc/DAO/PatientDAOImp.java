package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class PatientDAOImp extends AbstractDAO implements PatientDAO {
    public void addPatient(Patient p) {
        try {
            preparedStatement = connection
                    .prepareStatement("insert into PATIENTS (Patient_Id, LAST_NAME, DOB, Address_City, Phone) values (PATIENT_ID_SEQ.nextval, ?, ?, ?, ?)");
            preparedStatement.setString(1, p.getLastName());
            preparedStatement.setDate(2, new java.sql.Date(p.getDob().getTime()));
            preparedStatement.setString(3, p.getAddrCity());
            preparedStatement.setString(4, p.getPhone());
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

    public int getPatientIdByNameAndDob(String name, Date dob) {
        return 0;
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
