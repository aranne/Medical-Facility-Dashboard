package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Service;
import edu.ncsu.csc.model.ServiceDept;

import java.sql.SQLException;
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
    public List<ServiceDept> getBatchByQuery(String queryStr) {
        return null;
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
