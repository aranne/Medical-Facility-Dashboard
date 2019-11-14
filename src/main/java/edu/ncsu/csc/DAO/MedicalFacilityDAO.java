package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.ServiceDept;

import java.util.List;

public interface MedicalFacilityDAO {
  void addFacility(MedicalFacility f);

  List<MedicalFacility> getAllFacility();

  MedicalFacility getFacilityById(int id);

  void updateFacility(MedicalFacility m);

  void deleteFacility(MedicalFacility m);

  List<ServiceDept> getAllServiceDept(MedicalFacility f);
}
