package edu.ncsu.csc.view.PatientPages;

import edu.ncsu.csc.model.Symptom;
import edu.ncsu.csc.view.InteractiveTool;

import java.util.ArrayList;
import java.util.List;

public class SymptomMeta {
  public static void display(List<Symptom> symptomsToBeSaved) {
    List<String> menueStrs = new ArrayList<String>(0);
    Boolean running = true;
    InteractiveTool intertool = new InteractiveTool();

    menueStrs.add("Body part");
    menueStrs.add("Duration");
    menueStrs.add("Reoccurring?");
    menueStrs.add("Severity");
    menueStrs.add("Cause");
  }
}
