package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Patient;

import java.util.Date;
import java.util.List;

public interface PatientDAO {
    void addPatient(Patient p);

    List<Patient> getAllPatient();

    Patient getPatientById(int id);

    Patient getPatientByNameAndDob(String name, Date dob);

    void updatePatient(Patient p);

    void deletePatient(Patient p);

    void addFacility(Patient p);

}
