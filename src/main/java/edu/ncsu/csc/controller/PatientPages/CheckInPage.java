package edu.ncsu.csc.controller.PatientPages;

import edu.ncsu.csc.DAO.CheckInDAOImp;
import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.DAO.PatientDAOImp;
import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;

public class CheckInPage {
  public static void checkIn(int patientId, int facilityId) {
    MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
    MedicalFacility facility = facilityDao.getFacilityById(facilityId);
    System.out.println("Successfully checked in " + facility.getName());
    /* Get patient. */
    PatientDAOImp patientDao = new PatientDAOImp();
    Patient p = patientDao.getPatientById(patientId);
    /* Create a new record in CheckIn table. */
    CheckIn c = new CheckIn();
    c.setLastName(p.getLastName());
    c.setDob(p.getDob());
    c.setFacilityId(facilityId);
    CheckInDAOImp checkInDao = new CheckInDAOImp();
    checkInDao.addCheckIn(c);
    /* Go to Patient Check-In page. */
    // TODO go to Patient check-in page
  }
}
