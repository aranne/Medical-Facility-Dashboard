package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.ServiceDept;
import edu.ncsu.csc.model.Staff;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StaffDAOImp extends AbstractDAO implements StaffDAO {
  @Override
  public void addStaff(Staff s) {

  }

  @Override
  public List<Staff> getAllStaff() {
    return null;
  }

  @Override
  public Staff getStaffById(int id) {
    return null;
  }

  public Staff getStaffByNameAndDob(String lastName, Date dob) {
    Staff staff = null;
    try {
      openConnection();
      // TODO cannot find Staff
      preparedStatement = connection
              .prepareStatement("select * from STAFFS where last_name = ? and dob = ?");
      preparedStatement.setString(1, lastName);
      preparedStatement.setDate(2, new java.sql.Date(dob.getTime()));
      System.out.println(new java.sql.Date(dob.getTime()));
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        staff = new Staff(
                resultSet.getInt("employee_id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"),
                resultSet.getBoolean("is_medical"),
                resultSet.getDate("dob"),
                resultSet.getDate("hire_date"),
                resultSet.getString("primary_dept_code")
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return staff;
  }

  @Override
  public void updateStaff(Staff s) {

  }

  @Override
  public void deleteStaff(Staff s) {

  }

  public List<ServiceDept> getAllSecondaryDepts(Staff s) {
    List<ServiceDept> depts = new ArrayList<>();
    List<String> codes = new ArrayList<>();
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("select dept_code from staff_seco_works_dept where employee_id = ?");
      preparedStatement.setInt(1, s.getEmployeeId());
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        String dept_code = resultSet.getString("dept_code");
        codes.add(dept_code);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    /* Find all ServiceDept corresponding to code. */
    for (String code : codes) {
      ServiceDeptDAOImp deptDao = new ServiceDeptDAOImp();
      ServiceDept dept = deptDao.getServiceDeptByCode(code);
      depts.add(dept);
    }
    return depts;
  }
}
