package edu.ncsu.csc.view.StartPages;

import edu.ncsu.csc.model.Patient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static edu.ncsu.csc.controller.StartPages.SignUp.signUp;

public class SignUp {
  public static void display() throws ParseException {
    Patient patient = new Patient();
    Scanner input = new Scanner(System.in);
    ArrayList<String> choices = new ArrayList<String>();
    choices.add("1");
    choices.add("2");
    String choice = "-1" ;


    while (!choice.equals("2")) {

      System.out.println("A. First Name");
      patient.setFirstName(input.next());

      System.out.println("B. Last name");
      patient.setLastName(input.next());

      System.out.println("C. Date of Birth in format dd/mm/yyyy");
      Date date = new SimpleDateFormat("dd/MM/yyyy").parse(input.next());
      patient.setDob(date);

      System.out.println("D. City of address");
      patient.setAddrCity(input.next());

      System.out.println("E. Phone Number");
      patient.setPhone(input.next());

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
          signUp(patient);
          break;
        case 2:
          break;
      }
    }
  }
}
