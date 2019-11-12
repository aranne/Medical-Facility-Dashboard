package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Symptom;

import java.util.ArrayList;

public interface PatientPagesDao {
  ArrayList<Symptom> getAllSymptoms();
}
