package edu.ncsu.csc.DAO;

import java.util.List;

import edu.ncsu.csc.model.Staff;
import edu.ncsu.csc.model.Vital;

public interface TemplateDAO<T>{
    boolean addOneValue(T p);

    List<T> getAllValues();
    List<T> getBatchByQuery(String queryStr);
    T getOneByQuery(String queryStr);
    T getOneById(int id);
    T getOneById(String id);

    boolean updateValue(T p);

    boolean deleteRecord(T p);
}
