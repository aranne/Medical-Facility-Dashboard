package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Severity;
import edu.ncsu.csc.model.Staff;
import edu.ncsu.csc.model.Symptom;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeverityDAOImp extends AbstractDAO implements TemplateDAO<Severity> {

  public List<Severity> getAllBySymCode(String symCode) {
    List<Severity> severities = new ArrayList<Severity>();

    try {
      openConnection();
      preparedStatement = connection
          .prepareStatement("select * from severities where SYM_CODE = ?");
      preparedStatement.setString(1, symCode);
      resultSet = preparedStatement.executeQuery();
      System.out.println(resultSet.toString());
      while (resultSet.next()) {
        severities.add(new Severity(resultSet.getInt(1), resultSet.getInt(2)
            , resultSet.getString(3), resultSet.getString(4)));
      }

    } catch (SQLException e) {
      System.out.println("SQL Expection");
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return severities;
  }

  public boolean addSeverity(Severity severity) {
    boolean rest = false;
    try {
      openConnection();
      preparedStatement = connection
          .prepareStatement("INSERT INTO severities (SYM_CODE, SCALE) values (?,?)");

      preparedStatement.setString(1, severity.getName());
      preparedStatement.setString(2, severity.getScale());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      rest = false;
    } finally {
      closeConnection();
    }
    return rest;
  }

  @Override
  public boolean addOneValue(Severity p) {
    return false;
  }

  @Override
  public List<Severity> getAllValues() {
    List<Severity> severities = new ArrayList<Severity>();

    try {
      openConnection();
      preparedStatement = connection
          .prepareStatement("select * from severities");
      resultSet = preparedStatement.executeQuery();
      System.out.println(resultSet.toString());
      while (resultSet.next()) {
        severities.add(new Severity(resultSet.getInt(1), resultSet.getInt(2)
            , resultSet.getString(3), resultSet.getString(4)));
      }

    } catch (SQLException e) {
      System.out.println("SQL Expection");
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return severities;
  }

  @Override
  public List<Severity> getBatchByQuery(String queryStr) {
    return null;
  }

  @Override
  public Severity getOneByQuery(String queryStr) {
    return null;
  }

  @Override
  public Severity getOneById(int id) {
    return null;
  }

  @Override
  public Severity getOneById(String id) {
    return null;
  }

  @Override
  public boolean updateValue(Severity p) {
    return false;
  }

  @Override
  public boolean deleteRecord(Severity p) {
    return false;
  }
}
