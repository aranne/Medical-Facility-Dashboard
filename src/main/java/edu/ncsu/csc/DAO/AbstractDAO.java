package edu.ncsu.csc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;

public class AbstractDAO {
    protected static final String URL = "jdbc:oracle:thin:@orca.csc.ncsu.edu:1521:orcl01";
    protected static final String USERNAME = "wfu4";
    protected static final String PASSWORD = "fwroyf0312";
    protected Connection connection;
    protected PreparedStatement preparedStatement;
    protected ResultSet resultSet;

    public AbstractDAO() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
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
