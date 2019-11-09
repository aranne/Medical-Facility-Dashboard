package edu.ncsu.csc.view.StartPages;

import java.util.ArrayList;
import java.util.Scanner;

import static edu.ncsu.csc.controller.StartPages.SignUp.signUp;

public class SignUp {
  public static void display() {
    Scanner input = new Scanner(System.in);
    ArrayList<String> choices = new ArrayList<String>();
    choices.add("1");
    choices.add("2");
    String choice = "-1" ;


    while (!choice.equals("2")) {

      System.out.println("A. First Name");
      String firstName = input.next();

      System.out.println("B. Last name");
      String lastName = input.next();

      System.out.println("C. Date of Birth");
      String dob = input.next();

      System.out.println("D. City of address");
      String city = input.next();

      System.out.println("E. Phone Number");
      String phoneNumber = input.next();

      System.out.println("1. Sign up");
      System.out.println("2. Go Back");
      choice = input.next();
      while (!choices.contains(choice)) {
        System.out.println("Invalid");
        System.out.println("1. Sign up");
        System.out.println("2. Go Back");
        choice = input.next();
      }

      switch (Integer.parseInt(choice)) {
        case 1:
          signUp();
          break;
        case 2:
          break;
      }
    }
  }
}
