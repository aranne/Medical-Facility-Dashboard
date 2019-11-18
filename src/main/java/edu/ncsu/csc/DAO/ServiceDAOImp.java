package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAOImp  extends AbstractDAO implements TemplateDAO<Service>{
    @Override
    public boolean addOneValue(Service p) {
        return false;
    }

    @Override
    public List<Service> getAllValues() {
        List<Service> service = new ArrayList<>();
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select * from SERVICES");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                service.add(new Service(
                        resultSet.getString("service_code"),
                        resultSet.getString("name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        if(service.size()==0)
            service = null;
        return service;
    }

    @Override
    public List<Service> getBatchByQuery(String queryStr) {
        return null;
    }

    @Override
    public Service getOneByQuery(String queryStr) {
        return null;
    }

    @Override
    public Service getOneById(int id) {
        return null;
    }

    @Override
    public Service getOneById(String id) {
        return null;
    }

    @Override
    public boolean updateValue(Service p) {
        return false;
    }

    @Override
    public boolean deleteRecord(Service p) {
        return false;
    }
}
