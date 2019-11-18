package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.BodyPart;
import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.Staff;
import edu.ncsu.csc.model.Symptom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SymptomDAOImp extends AbstractDAO implements TemplateDAO<Symptom> {

	public Symptom getSymptomByCheckin(CheckIn checkin) {
		Symptom symptom=null;
		    try {
		      openConnection();
		      preparedStatement = connection
		              .prepareStatement("SELECT * FROM SYMPTOMS WHERE sym_code IN (SELECT BODY_CODE FROM patient_has_sym_serverity WHERE last_name=? AND dob=?)");
		      preparedStatement.setString(1, checkin.getLastName());
		      preparedStatement.setDate(2, new java.sql.Date(checkin.getDob().getTime()));
		      resultSet = preparedStatement.executeQuery();
		      if(resultSet.next()) {
		    	  symptom= new Symptom(
		                  resultSet.getString(1),
		                  resultSet.getString(2));
		      }
		      
		    } catch (SQLException e) {
		      e.printStackTrace();
		    } finally {
		      closeConnection();
		    }
		    return symptom;
	}
	 public List<BodyPart> getBodysbySymptom(Symptom symptom){
	    	List<BodyPart> bodys=new ArrayList<BodyPart>();
	    	try {
	            openConnection();
	            preparedStatement = connection
	                    .prepareStatement("select * from body_parts \n UNION \n"
	                    		+ "select * from body_parts where body_code in "
	                    		+ "(select body_code from sym_has_body_part where sym_code=?)");
	            preparedStatement.setString(1, symptom.getSymCode());
	            resultSet = preparedStatement.executeQuery();
	            while (resultSet.next()) {
	            	bodys.add(new BodyPart(resultSet.getString("body_code"),resultSet.getString("body_name")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            closeConnection();
	        }
	        return bodys;
	    }
  public boolean addSymptomWithBody(Symptom s, List<BodyPart> bodies) {
    boolean rest=true;
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("INSERT INTO SYMPTOMS (NAME, SYM_CODE) values (?, ?)");
      preparedStatement.setString(1, s.getName());
      preparedStatement.setString(2, s.getSymCode());
      preparedStatement.executeUpdate();
      connection.setAutoCommit(false);
      preparedStatement = connection
              .prepareStatement("INSERT INTO sym_has_body_part (sym_code, body_code) values (?, ?)");
      for(int i=0;i<bodies.size();i++){
        preparedStatement.setString(1,s.getSymCode());
        preparedStatement.setString(2,bodies.get(i).getBodyCode() );
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

  // TODO for sample query
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
