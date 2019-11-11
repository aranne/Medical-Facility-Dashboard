package edu.ncsu.csc.view.StartPages;

import edu.ncsu.csc.DAO.PatientDAOImp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static edu.ncsu.csc.controller.StartPages.SignUp.goBack;
import static edu.ncsu.csc.controller.StartPages.SignUp.signUp;

public class SignUp {
  public static void display() {
    Scanner input = new Scanner(System.in);
    ArrayList<String> choices = new ArrayList<>();
    choices.add("1");
    choices.add("2");
    String choice = "-1" ;
    PatientDAOImp patientDAO = new PatientDAOImp();

    while (!choice.equals("2") && !choice.equals("1")) {
      System.out.println("==================== SIGN UP ====================");
      System.out.println("A. First Name");
      String firstName = input.next();

      String lastName;
      Date dob;

      while (true) {
        System.out.println("B. Last name");
        lastName = input.next();

        while (true) {
          System.out.println("C. Date of Birth in format mm/dd/yyyy");
          try {
            dob = new SimpleDateFormat("MM/dd/yyyy").parse(input.next());
            break;
          } catch (ParseException e) {
            System.out.println("Invalid Format for Date of Birth");
          }
        }
        /* User has not signed up before. */
        if (patientDAO.getPatientByNameAndDob(lastName, dob) == null) {
          break;
        } else {
          System.out.println("Last Name and Date of Birth are already used, please try again");
        }
      }

      System.out.println("D. Street of address");
      String addrStreet = input.next();

      System.out.println("D. City of address");
      String addrCity = input.next();

      System.out.println("D. State of address");
      String addrState = input.next();

      System.out.println("D. Country of address");
      String addrCountry = input.next();

      int addrZip;
      while (true) {
        System.out.println("D. Zip of address");
        try {
          addrZip = Integer.parseInt(input.next());
          break;
        } catch (NumberFormatException e) {
          System.out.println("Zip should be integer, please try again");
        }
      }

      System.out.println("E. Phone Number");
      String phone = input.next();

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
          signUp(firstName, lastName, dob, addrStreet, addrCity, addrState, addrCountry, addrZip, phone);
          break;
        case 2:
          goBack();
          break;
      }
    }
  }
}
