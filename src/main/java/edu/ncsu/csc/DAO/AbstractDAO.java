package edu.ncsu.csc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class AbstractDAO {
  private static final String URL = "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";
  private static final String USERNAME = "wfu4";
  private static final String PASSWORD = "fwroyf0312";
  Connection connection;
  PreparedStatement preparedStatement;
  ResultSet resultSet;

  AbstractDAO() {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      System.out.println("Class not found");
    }
  }

  protected void closeConnection() {
    if (resultSet != null) {
      try {
        resultSet.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (preparedStatement != null) {
      try {
        preparedStatement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
