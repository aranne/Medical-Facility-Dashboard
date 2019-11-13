package edu.ncsu.csc.view.PatientPages;

import edu.ncsu.csc.model.Symptom;
import edu.ncsu.csc.view.InteractiveTool;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static edu.ncsu.csc.controller.PatientPages.CheckIn.*;


public class CheckIn {
  public static void display(int patientId) {
    List<String> menueStrs = new ArrayList<String>(0);
    List<Symptom> symptomsList = getAllSymptoms();
    ArrayList<Symptom> symptomsToBeSaved = new ArrayList<Symptom>();
    Boolean running = true;
    InteractiveTool intertool = new InteractiveTool();
    for (Symptom symptom : symptomsList) {
      menueStrs.add(symptom.getName());
    }
    menueStrs.add("Other");
    menueStrs.add("Done");

    while (running) {
      System.out.println("size" + menueStrs.size());
      intertool.show(menueStrs);
      intertool.show("input your choice");
      int index = intertool.getChoice(menueStrs.size() + 2);

      if (index == menueStrs.size()) {
        if (symptomsToBeSaved != null) {
          saveSymptoms(symptomsToBeSaved, patientId);
        }
        running = false;
      } else if (index == menueStrs.size() - 1) {
//        TODO: allow patient provide a description for the symptom
      } else {
        gotoMetaSymptomPage(symptomsToBeSaved, patientId);
      }
    }
  }
}
