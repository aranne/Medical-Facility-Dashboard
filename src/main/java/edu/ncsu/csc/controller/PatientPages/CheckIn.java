package edu.ncsu.csc.controller.PatientPages;

import edu.ncsu.csc.DAO.SymptomDAOImpl;
import edu.ncsu.csc.model.Symptom;

import java.util.ArrayList;

public class CheckIn {

  public static ArrayList<Symptom> getAllSymptoms() {
    SymptomDAOImpl patientPagesDao = new SymptomDAOImpl();
    ArrayList<Symptom> symptoms = patientPagesDao.getAllSymptoms();
    return symptoms;
  }

  public static void gotoMetaSymptomPage(ArrayList<Symptom> symptoms, int patientId) {
//    TODO: goto Meta Symptom Page
  }

  public static void saveSymptoms(ArrayList<Symptom> symptoms, int patientId) {
//    TODO: save symptoms
  }

  public static void saveOtherSymptom(int patientId) {
//    TODO: save other symptom provided by patient
  }
}
