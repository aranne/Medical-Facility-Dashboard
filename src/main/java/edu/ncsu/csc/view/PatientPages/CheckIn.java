package edu.ncsu.csc.view.PatientPages;

import edu.ncsu.csc.model.Symptom;

import java.util.ArrayList;
import java.util.Scanner;

import static edu.ncsu.csc.controller.PatientPages.CheckIn.getAllSymptoms;
import static edu.ncsu.csc.controller.PatientPages.CheckIn.gotoSymptomMeta;

public class CheckIn {
  public static void display(int patientId) {
    Scanner input = new Scanner(System.in);
    String choice = "-1";
    ArrayList<Symptom> symptoms = getAllSymptoms();
    ArrayList<String> symptomsNumbers = new ArrayList<String>();
    ArrayList<String> choices = new ArrayList<String>();

//    display menu
    int i = 0;
    for (; i < symptoms.size(); i++) {
//    symptom index = number - 1
      choices.add(String.valueOf(i + 1));
      symptomsNumbers.add(String.valueOf(i+1));
      System.out.println(String.valueOf(i+1) + ". " + symptoms.get(i).getName());
    }
    choices.add(String.valueOf(i+1));
    System.out.println(String.valueOf(i+1) + ". Other" );
    choices.add(String.valueOf(i+2));
    System.out.println(String.valueOf(i+2) + ". Done" );

    choice = input.next();
    while (!choices.contains(choice)) {
      System.out.println("Invalid Input, please try again");
      choice = input.next();
    }

    if (symptomsNumbers.contains(choice)) {
      gotoSymptomMeta();
    }

    if (choice.equals(String.valueOf(i+1))) {
//      TODO: provide description for the symptom
    }

    if (choice.equals(String.valueOf(i+2))) {
      return;
    }
  }
}
