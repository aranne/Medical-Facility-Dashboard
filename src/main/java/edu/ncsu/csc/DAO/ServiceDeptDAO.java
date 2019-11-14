package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.ServiceDept;

import java.util.List;

public interface ServiceDeptDAO {
    void addServiceDept(ServiceDept d);

    List<ServiceDept> getAllServiceDept();

    ServiceDept getServiceDeptByCode(String code);

    void updateServiceDept(ServiceDept d);

    void deleteServiceDept(ServiceDept d);
}
