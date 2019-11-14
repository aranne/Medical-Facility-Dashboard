package edu.ncsu.csc.controller.PatientPages;

import edu.ncsu.csc.DAO.SymptomDAO;
import edu.ncsu.csc.model.Symptom;

import java.util.ArrayList;
import java.util.List;

public class CheckIn {

  public static List<Symptom> getAllSymptoms() {
    SymptomDAO patientPagesDao = new SymptomDAO();
    List<Symptom> symptoms = patientPagesDao.getAllValues();
    return symptoms;
  }

  public static void gotoMetaSymptomPage(List<Symptom> symptoms, int patientId) {
//    TODO: goto Meta Symptom Page
  }

  public static void saveSymptoms(List<Symptom> symptoms, int patientId) {
//    TODO: save symptoms
  }

  public static void saveOtherSymptom(int patientId) {
//    TODO: save other symptom provided by patient
  }
}
