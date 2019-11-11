package edu.ncsu.csc.view.PatientPages;

import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.controller.PatientPages.CheckInPage;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.view.StartPages.Home;

import java.util.ArrayList;
import java.util.List;
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
        int facilityId = Routing.displayFacilities(input);
        CheckInPage.checkIn(patientId, facilityId);
        break;
      case 2:
        // TODO go to patient check-out acknowledgement controller
        break;
      case 3:
        Home.display();
        break;
    }
  }

  private static int displayFacilities(Scanner input) {
    List<MedicalFacility> facilities;
    List<Integer> ids = new ArrayList<>();
    MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
    facilities = facilityDao.getAllFacility();
    for (MedicalFacility f : facilities) {
      ids.add(f.getFacilityId());
    }
    int facilityId;
    while (true) {
      try {
        System.out.println("Please choose a Facility's Id to check in");
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
    return facilityId;
  }
}
