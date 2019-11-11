package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.CheckIn;

import java.util.List;

public interface CheckInDAO {
  void addCheckIn(CheckIn c);

  List<CheckIn> getAllCheckIn();

  CheckIn getCheckInByPatientId();

  CheckIn getCheckInByFacilityId();

  void updateCheckIn(CheckIn c);

  void deleteCheckIn(CheckIn c);

  /** Set check-in end time. */
  void setCheckInEndTime(CheckIn c);
}
