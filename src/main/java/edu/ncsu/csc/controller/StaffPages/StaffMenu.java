package edu.ncsu.csc.controller.StaffPages;


import edu.ncsu.csc.view.StaffPages.*;
import edu.ncsu.csc.view.StaffPages.AddSeverityScale;

public class StaffMenu {

    public static void addScale() {
        AddSeverityScale.display();
    }

    public static void addSymptom() {
        AddSymptoms.display();
    }

    public static void treatedPatient() {

        ProcessPatient.display();
    }

    public static void processPatient() {
        TreatedPatient.display();
    }

    public static void addAssessment() {
        AddAssessmentRule.display();
    }

    public static void exit() {
    }
}
