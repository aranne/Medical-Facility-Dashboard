package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Severity;
import edu.ncsu.csc.model.Staff;
import edu.ncsu.csc.model.Symptom;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SeverityDAOImp extends AbstractDAO implements TemplateDAO<Severity> {

    public boolean addSeverities(List<Severity> severities) {
	 boolean rest=false;
	    try {
	      openConnection();
	      preparedStatement = connection
	              .prepareStatement("INSERT INTO severities (value, name, scale, bleeding) values (?, ?, ?,?)");
	      connection.setAutoCommit(false);
	      for(int i=0;i<severities.size();i++) {
	    	  preparedStatement.setInt(1, severities.get(i).getValue());
		      preparedStatement.setString(2,  severities.get(i).getName());
		      preparedStatement.setString(3,  severities.get(i).getScale());
		      preparedStatement.setString(4,  severities.get(i).getBleeding());
		      preparedStatement.addBatch();
	      }
	      preparedStatement.executeBatch();
	      connection.commit();
	      connection.setAutoCommit(true);
	      rest=true;
	    } catch (SQLException e) {
	      e.printStackTrace();
	      rest=false;
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
        	  severities.add( new Severity(resultSet.getInt(1),resultSet.getInt(2)
        			  ,resultSet.getString(3),resultSet.getString(4),resultSet.getString(5)));
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
