package edu.ncsu.csc.view.PatientPages;

import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.controller.PatientPages.CheckInPage;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;
import edu.ncsu.csc.view.StartPages.Home;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Routing extends BasePage implements PageView {
  Patient pd;
  MedicalFacility f;

  public Routing(Patient pd, MedicalFacility f) {
    this.pd = pd;
    this.f = f;
    choicePrompt = "Enter Choice (1-3)";
    pageTitle = "==================== MENU ====================";
    menueStrs.add("Check-in");
    menueStrs.add("Check-out acknowledgement");
    menueStrs.add("Go Back");
  }
//
//  private static int displayFacilities(Scanner input) {
//    List<MedicalFacility> facilities;
//    List<Integer> ids = new ArrayList<>();
//    MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
//    facilities = facilityDao.getAllFacility();
//    for (MedicalFacility f : facilities) {
//      ids.add(f.getFacilityId());
//    }
//    int facilityId;
//    while (true) {
//      try {
//        System.out.println("Please choose a Facility's Id to check in");
//        for (MedicalFacility f : facilities) {
//          System.out.println("Id: " + f.getFacilityId() + ", Name: " + f.getName());
//        }
//        facilityId = Integer.parseInt(input.next());
//        if (ids.contains(facilityId)) {
//          break;
//        } else {
//          System.out.println("Invalid Input, please try again");
//        }
//      } catch (NumberFormatException e) {
//        System.out.println("Invalid Input, please try again");
//      }
//    }
//    return facilityId;
//  }

  @Override
  public void display() {
//    running = true;
//    Medicalsheet ms = null;
//    while (flag) {
//      int index = getChoice(3);
//      initPage();
//      switch (index) {
//        case 1:
//          if (ms == null) {
//            ms = new MedicalsheetDao();
//            ms.setFacility(f);
//            ms.setPatient(pd);
//            ((MedicalsheetDao) ms).insert();
//
//            Page p = new CheckinPage(ms);
//            p.run();
//          }
//          break;
//        case 2:
//          if (ms != null)
//          {
//            Page p1 = new CheckoutAcknPage(ms);
//            p1.run();
//          }
//          else
//            show("please check-in fisrt!");
//
//          break;
//        case 3:
//          break;
//      }
//      index = -1;
//    }
  }
}
