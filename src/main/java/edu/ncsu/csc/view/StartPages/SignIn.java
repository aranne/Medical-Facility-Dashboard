package edu.ncsu.csc.view.StartPages;

import java.util.Scanner;

import static edu.ncsu.csc.controller.StartPages.SignIn.signInAsPatient;
import static edu.ncsu.csc.controller.StartPages.SignIn.signInAsStaff;

public class SignIn {
  public static void display() {
    Scanner input = new Scanner(System.in);
    int choice = -1;
    while (choice != 2) {

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

      System.out.println("1. Sign in");
      System.out.println("2. Go Back");
      choice = input.nextInt();
      while (choice < 0 || choice > 2) {
        System.out.println("Sign in Incorrect");
        choice = input.nextInt();
      }

      switch (choice) {
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
