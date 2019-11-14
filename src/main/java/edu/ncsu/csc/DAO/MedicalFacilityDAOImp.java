package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.ServiceDept;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicalFacilityDAOImp extends AbstractDAO implements TemplateDAO<MedicalFacility> {


//  public List<MedicalFacility> getAllServiceDept(MedicalFacility f) {
//    List<ServiceDept> depts = new ArrayList<>();
//    List<String> codes = new ArrayList<>();
//    try {
//      openConnection();
//      preparedStatement = connection
//              .prepareStatement("select dept_code from facility_has_dept where facility_id = ?");
//      preparedStatement.setInt(1, f.getFacilityId());
//      resultSet = preparedStatement.executeQuery();
//      while (resultSet.next()) {
//        codes.add(
//                resultSet.getString("dept_code")
//        );
//      }
//    } catch (SQLException e) {
//      e.printStackTrace();
//    } finally {
//      closeConnection();
//    }
//    /* Find all depts corresponding to dept_code. */
//    ServiceDeptDAOImp deptDao = new ServiceDeptDAOImp();
//    for (String code : codes) {
//      depts.add(deptDao.getServiceDeptByCode(code));
//    }
//    return depts;
//  }

  @Override
  public boolean addOneValue(MedicalFacility p) {
    return false;
  }

  @Override
  public List<MedicalFacility> getAllValues() {
    List<MedicalFacility> facilities = new ArrayList<>();
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("select * from medical_facilities");
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        facilities.add(new MedicalFacility(
                resultSet.getInt("facility_id"),
                resultSet.getString("name"),
                resultSet.getString("classification"),
                resultSet.getString("address"),
                resultSet.getString("capacity")
        ));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    if(facilities.size()==0)
      facilities=null;
    return facilities;
  }

  @Override
  public List<MedicalFacility> getBatchByQuery(String queryStr) {
    return null;
  }

  @Override
  public MedicalFacility getOneByQuery(String queryStr) {
    return null;
  }

  @Override
  public MedicalFacility getOneById(int id) {
    MedicalFacility f = null;
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("select * from medical_facilities where facility_id = ?");
      preparedStatement.setInt(1, id);
      resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        f = new MedicalFacility(
                resultSet.getInt("facility_id"),
                resultSet.getString("name"),
                resultSet.getString("classification"),
                resultSet.getString("address"),
                resultSet.getString("capacity")
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return f;
  }

  @Override
  public MedicalFacility getOneById(String id) {
    return null;
  }

  @Override
  public boolean updateValue(MedicalFacility p) {
    return false;
  }

  @Override
  public boolean deleteRecord(MedicalFacility p) {
    return false;
  }
}
