package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Service;
import edu.ncsu.csc.model.ServiceDept;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDeptDAOImp extends AbstractDAO implements TemplateDAO<ServiceDept> {

    @Override
    public boolean addOneValue(ServiceDept p) {
        return false;
    }

    @Override
    public List<ServiceDept> getAllValues() {
        return null;
    }

    @Override
    public List<ServiceDept> getBatchByQuery(String query) {
        return null;
    }

    public int getMstaff(String id) {
        int getmStaff = -1;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select Count(*) from STAFFS where IS_MEDICAL = '1' and PRIMARY_DEPT_CODE in (select DEPT_CODE from FACILITY_HAS_DEPT where FACILITY_ID = "+id+" )");
            //preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                getmStaff = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return getmStaff;
    }
    public int getNstaff(String id) {
        int getnStaff = -1;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select Count(*) from STAFFS where IS_MEDICAL = '0' and PRIMARY_DEPT_CODE in (select DEPT_CODE from FACILITY_HAS_DEPT where FACILITY_ID = "+id+" )");
            //preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                getnStaff = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return getnStaff;
    }

    @Override
    public ServiceDept getOneByQuery(String queryStr) {
        return null;
    }

    @Override
    public ServiceDept getOneById(int id) {
        return null;
    }

    @Override
    public ServiceDept getOneById(String id) {
        ServiceDept dept = null;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select * from service_depts where dept_code = ?");
            preparedStatement.setString(1, id);
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
    public boolean updateValue(ServiceDept p) {
        return false;
    }

    @Override
    public boolean deleteRecord(ServiceDept p) {
        return false;
    }
}
