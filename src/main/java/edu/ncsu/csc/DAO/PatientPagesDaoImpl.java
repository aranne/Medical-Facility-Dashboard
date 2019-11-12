package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Symptom;

import java.sql.SQLException;
import java.util.ArrayList;

public class PatientPagesDaoImpl extends AbstractDAO implements PatientPagesDao {

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
}
