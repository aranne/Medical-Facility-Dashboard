package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.ServiceDept;
import edu.ncsu.csc.model.Staff;

import java.util.List;

public interface StaffDAO {
  void addStaff(Staff s);

  List<Staff> getAllStaff();

  Staff getStaffById(int id);

  void updateStaff(Staff s);

  void deleteStaff(Staff s);

  List<ServiceDept> getAllDepts(Staff s);

  ServiceDept getPrimaryDept(Staff s);

  List<ServiceDept> getAllSecondaryDepts(Staff s);
}
