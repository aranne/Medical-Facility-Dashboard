package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Symptom;

import java.sql.SQLException;
import java.util.ArrayList;

public class SymptomDAOImpl extends AbstractDAO implements SymptomDAO {
  @Override
  public ArrayList<Symptom> getAllSymptoms() {
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
}
