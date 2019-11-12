package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.ServiceDept;

import java.sql.SQLException;
import java.util.List;

public class ServiceDeptDAOImp extends AbstractDAO implements ServiceDeptDAO {

  @Override
  public void addServiceDept(ServiceDept d) {

  }

  @Override
  public List<ServiceDept> getAllServiceDept() {
    return null;
  }

  @Override
  public ServiceDept getServiceDeptByCode(String code) {
    ServiceDept dept = null;
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("select * from service_depts where dept_code = ?");
      preparedStatement.setString(1, code);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        dept = new ServiceDept(
                resultSet.getString("dept_code"),
                resultSet.getString("name"),
                resultSet.getBoolean("is_medical")
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return dept;
  }

  @Override
  public void updateServiceDept(ServiceDept d) {

  }

  @Override
  public void deleteServiceDept(ServiceDept d) {

  }
}
