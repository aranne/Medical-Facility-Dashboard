package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.model.Symptom;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public interface PatientDAO {
    void addPatient(Patient p);

    List getAllPatient();

    Patient getPatientById(int id);

    Patient getPatientByNameAndDob(String name, Date dob);

    void updatePatient(Patient p);

    void deletePatient(Patient p);

    void addFacility(Patient p, MedicalFacility f);

}
