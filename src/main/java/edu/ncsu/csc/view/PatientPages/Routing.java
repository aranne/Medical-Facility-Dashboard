package edu.ncsu.csc.view.PatientPages;

import edu.ncsu.csc.view.StartPages.Home;

import java.util.ArrayList;
import java.util.Scanner;

public class Routing {
  public static void display(int patientId) {
    Scanner input = new Scanner(System.in);
    ArrayList<String> choices = new ArrayList<>();
    choices.add("1");
    choices.add("2");
    choices.add("3");
    String choice;

    while (true) {
      System.out.println("==================== MENU ====================");
      System.out.println("1. Check-in");
      System.out.println("2. Check-out acknowledgement");
      System.out.println("3. Go back");
      choice = input.next();
      if (!choices.contains(choice)) {
        System.out.println("Invalid Input, please try again");
      } else {
        break;
      }
    }
    switch (Integer.parseInt(choice)) {
      case 1:
        // TODO go to patient check-in controller
        break;
      case 2:
        // TODO go to patient check-out acknowledgement controller
        break;
      case 3:
        Home.display();
        break;
    }
  }
}
