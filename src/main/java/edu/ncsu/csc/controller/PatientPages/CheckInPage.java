package edu.ncsu.csc.controller.PatientPages;

import edu.ncsu.csc.DAO.CheckInDAOImp;
import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.DAO.PatientDAOImp;
import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.view.PatientPages.Routing;

import java.util.List;

public class CheckInPage {
//  public static void checkIn(int patientId, int facilityId) {
//    /* Check whether patient has already checked in this facility. */
//    CheckInDAOImp checkInDao = new CheckInDAOImp();
//    List<CheckIn> checkIns = checkInDao.getAllCheckInByPatientIdAndFacilityId(patientId, facilityId);
//    boolean isCheckIn = false;
//    for (CheckIn c : checkIns) {
//      if (c.getEndTime() == null) {
//        isCheckIn = true;
//        System.out.println("You have checked-in in this facility");
//        Routing.display(patientId);
//      }
//    }
//    if (!isCheckIn) {
//      /* Get patient. */
//      PatientDAOImp patientDao = new PatientDAOImp();
//      Patient p = patientDao.getPatientById(patientId);
//      /* Create a new record in CheckIn table. */
//      CheckIn c = new CheckIn();
//      c.setLastName(p.getLastName());
//      c.setDob(p.getDob());
//      c.setFacilityId(facilityId);
//      checkInDao.addCheckIn(c);
//      MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
//      MedicalFacility facility = facilityDao.getFacilityById(facilityId);
//      System.out.println("Successfully checked in " + facility.getName());
//      /* Go to Patient Check-In page. */
//      // TODO go to Patient check-in page
//    }
//  }
}
