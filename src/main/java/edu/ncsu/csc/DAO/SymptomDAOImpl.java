package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Symptom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SymptomDAOImpl extends AbstractDAO implements TemplateDAO<Symptom> {

  @Override
  public boolean addOneValue(Symptom p) {
    boolean rest=true;
    try {
      openConnection();
      preparedStatement = connection
          .prepareStatement("INSERT INTO SYMPTOMS (NAME, SYM_CODE) values (?, ?)");
      preparedStatement.setString(1, p.getName());
      preparedStatement.setString(2, p.getSymCode());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      rest=false;
    } finally {
      closeConnection();
    }
    return rest;
  }

  @Override
  public List<Symptom> getAllValues() {
    ArrayList<Symptom> symptoms = new ArrayList<Symptom>();

    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("select * from SYMPTOMS");
      resultSet = preparedStatement.executeQuery();
      System.out.println(resultSet.toString());
      while (resultSet.next()) {
        Symptom symptom = new Symptom(
                resultSet.getString(1),
                resultSet.getString(2));
        symptoms.add(symptom);
      }

    } catch (SQLException e) {
      System.out.println("SQL Expection");
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return symptoms;
  }

  @Override
  public List<Symptom> getBatchByQuery(String queryStr) {
    return null;
  }

  @Override
  public Symptom getOneByQuery(String queryStr) {
    return null;
  }

  @Override
  public Symptom getOneById(int id) {
    return null;
  }

  @Override
  public Symptom getOneById(String id) {
    return null;
  }

  @Override
  public boolean updateValue(Symptom p) {
    return false;
  }

  @Override
  public boolean deleteRecord(Symptom p) {
    return false;
  }
}
