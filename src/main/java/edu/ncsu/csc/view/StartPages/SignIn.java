package edu.ncsu.csc.view.StartPages;

import java.util.ArrayList;
import java.util.Scanner;

import static edu.ncsu.csc.controller.StartPages.SignIn.signInAsPatient;
import static edu.ncsu.csc.controller.StartPages.SignIn.signInAsStaff;

public class SignIn {
  public static void display() {
    Scanner input = new Scanner(System.in);
    ArrayList<String> choices = new ArrayList<String>();
    choices.add("1");
    choices.add("2");
    String choice = "-1" ;

    while (!choice.equals("2")) {

      System.out.println("A. Facility id");
      String facilityId = input.next();

      System.out.println("B. Last name");
      String lastName = input.next();

      System.out.println("C. Date of Birth");
      String dob = input.next();

      System.out.println("D. City of address");
      String city = input.next();

      System.out.println("E. Patient with Options(y/n?)");
      String isPatient = input.next();
      while (!isPatient.equals("y")&& !isPatient.equals("n")) {
        System.out.println("E. Patient with Options(y/n?)");
        isPatient = input.next();
      }

      System.out.println("1. Sign in");
      System.out.println("2. Go Back");
      choice = input.next();
      while (!choices.contains(choice)) {
        System.out.println("Invalid");
        System.out.println("1. Sign in");
        System.out.println("2. Go Back");
        choice = input.next();
      }

      switch (Integer.parseInt(choice)) {
        case 1:
          if (isPatient.equals("y"))
            signInAsPatient();
          if (isPatient.equals("n"))
            signInAsStaff();
          break;
        case 2:
          break;
      }
    }
  }
}
