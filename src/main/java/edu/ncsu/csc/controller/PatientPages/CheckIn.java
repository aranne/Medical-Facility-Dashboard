package edu.ncsu.csc.controller.PatientPages;

import edu.ncsu.csc.DAO.PatientPagesDao;
import edu.ncsu.csc.DAO.PatientPagesDaoImpl;
import edu.ncsu.csc.model.Symptom;

import java.util.ArrayList;

public class CheckIn {

  public static ArrayList<Symptom> getAllSymptoms() {
    PatientPagesDaoImpl patientPagesDao = new PatientPagesDaoImpl();
    ArrayList<Symptom> symptoms = patientPagesDao.getAllSymptoms();
    return symptoms;
  }

  public static void gotoSymptomMeta() {

  }
}
