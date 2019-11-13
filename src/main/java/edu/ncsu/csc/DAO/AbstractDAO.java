package edu.ncsu.csc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

class AbstractDAO {
  private static final String URL = "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";
  private static final String USERNAME = "jcai3";
  private static final String PASSWORD = "200315852";
  Connection connection;
  PreparedStatement preparedStatement;
  ResultSet resultSet;

  void openConnection() throws SQLException {
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
    } catch (ClassNotFoundException e) {
      System.out.println("Class not found");
    }
  }

  void closeConnection() {
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
