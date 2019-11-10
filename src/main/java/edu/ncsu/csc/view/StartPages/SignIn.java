package edu.ncsu.csc.view.StartPages;

import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.model.MedicalFacility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static edu.ncsu.csc.controller.StartPages.SignIn.*;

public class SignIn {
  public static void display() {
    Scanner input = new Scanner(System.in);
    ArrayList<String> choices = new ArrayList<>();
    choices.add("1");
    choices.add("2");
    String choice = "-1" ;
    List<MedicalFacility> facilities;
    List<Integer> ids = new ArrayList<>();

    while (!choice.equals("2") && !choice.equals("1")) {
      MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
      facilities = facilityDao.getAllFacility();
      for (MedicalFacility f : facilities) {
        ids.add(f.getFacilityId());
      }
      int facilityId;
      while (true) {
        try {
          System.out.println("A. Facility id\n Please choose id from this list");
          for (MedicalFacility f : facilities) {
            System.out.println("Id: " + f.getFacilityId() + ", Name: " + f.getName());
          }
          facilityId = Integer.parseInt(input.next());
          if (ids.contains(facilityId)) {
            break;
          } else {
            System.out.println("Invalid Input, please try again");
          }
        } catch (NumberFormatException e) {
          System.out.println("Invalid Input, please try again");
        }
      }

      System.out.println("B. Last name");
      String lastName = input.next();

      Date dob;
      while (true) {
        System.out.println("C. Date of Birth in format mm/dd/yyyy");
        try {
          dob = new SimpleDateFormat("MM/dd/yyyy").parse(input.next());
          break;
        } catch (ParseException e) {
          System.out.println("Invalid Format for Date of Birth");
        }
      }

      System.out.println("D. City of address");
      String city = input.next();

      String isPatient;
      while (true) {
        System.out.println("E. Patient with Options(y/n?)");
        isPatient = input.next();
        if (isPatient.equals("y") || isPatient.equals("n")) {
          break;
        } else {
          System.out.println("Invalid Input");
        }
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
          if (isPatient.equals("y")) {
            signInAsPatient(facilityId, lastName, dob, city);
          } else {
            signInAsStaff();
          }
          break;
        case 2:
          goBack();
          break;
      }
    }
  }
}
