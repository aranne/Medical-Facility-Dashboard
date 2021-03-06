package edu.ncsu.csc.controller.PatientPages;

import edu.ncsu.csc.DAO.BodyPartDAO;
import edu.ncsu.csc.DAO.CheckInDAOImp;
import edu.ncsu.csc.DAO.SymptomDAOImp;
import edu.ncsu.csc.DAO.TemplateDAO;
import edu.ncsu.csc.model.*;

import java.util.ArrayList;
import java.util.List;

public class CheckinSymptoms {
  List<Symptom> symptoms;
  List<BodyPart> bodyParts;

  public CheckinSymptoms() {
    reloadDatas();
  }

  public void reloadDatas() {
    TemplateDAO m_dao = new SymptomDAOImp();
    symptoms = m_dao.getAllValues();
    TemplateDAO m_dao1 = new BodyPartDAO();
    bodyParts = m_dao1.getAllValues();
  }

  public List<BodyPart> getBodyparts(Symptom s) {
    BodyPartDAO m_dao = new BodyPartDAO();
    return m_dao.getSymptomBodies(s);
  }

  public List<String> getSymptomsMenu() {
    List<String> choices = new ArrayList<String>(symptoms.size());
    for (int i = 0; i < symptoms.size(); i++) {
      choices.add(symptoms.get(i).getName());
    }
    return choices;
  }

  public Symptom getSymtomsSelection(int index) {
    return symptoms.get(index - 1);
  }

  public List<String> getBodyPartsMenu(int index) {
    List<BodyPart> bodies = getBodyparts(symptoms.get(index));
    List<String> choices = new ArrayList<String>(bodies.size());
    for (int i = 0; i < bodies.size(); i++) {
      choices.add(bodies.get(i).getBodyName());
    }
    return choices;
  }

  public List<BodyPart> getSlected(List<Integer> indexs) {
    List<BodyPart> seleteds = new ArrayList<BodyPart>(0);
    for (int i = 0; i < indexs.size(); i++) {
      seleteds.add(bodyParts.get(indexs.get(i)));
    }
    return seleteds;
  }

  public List<String> getBodyPartsMenu() {
    List<String> choices = new ArrayList<String>(bodyParts.size());
    for (int i = 0; i < bodyParts.size(); i++) {
      choices.add(bodyParts.get(i).getBodyName());
    }
    return choices;
  }

  public void addSymptom(String name, String code, List<Integer> indexs) {

    if (indexs.size() == 0) {
      //symptom can associated all bodypart;
    } else {
      TemplateDAO m_dao = new SymptomDAOImp();
      Symptom s = new Symptom(name, code);
      List<BodyPart> bodies = getSlected(indexs);
      ((SymptomDAOImp) m_dao).addSymptomWithBody(s, bodies);
    }

  }

  public boolean submit(ArrayList<SymptomMeta> symptomMetaList, Patient patient) {
    CheckInDAOImp checkInDAOImp = new CheckInDAOImp();
    return checkInDAOImp.addSymptomMeta(symptomMetaList, patient);
  }

  public boolean addCheckIn(Patient patient, MedicalFacility medicalFacility) {
    CheckInDAOImp checkInDAOImp = new CheckInDAOImp();
    return checkInDAOImp.addCheckin(patient, medicalFacility);
  }
}
