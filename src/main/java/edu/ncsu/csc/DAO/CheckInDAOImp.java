package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.BodyPart;
import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.Staff;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckInDAOImp extends AbstractDAO implements TemplateDAO<CheckIn> {

	 public List<BodyPart> getBodysByCheckin(CheckIn p){
    	List<BodyPart> bodys=new ArrayList<BodyPart>();
//    	try {
//            openConnection();
//            preparedStatement = connection
//                    .prepareStatement("select * from body_parts where body_code in "
//                    		+ "(select body_code from dept_has_body_part where dept_code in "
//                    		+ "(select dept_code=? \n unionall \n select dept_code from staff_seco_works_dept where staff_code=? \n)"
//                    		+ ")");
//            preparedStatement.setInt(1, staff.getEmployeeId());
//            preparedStatement.setInt(2, staff.getEmployeeId());
//            resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//            	bodys.add(new BodyPart(resultSet.getString("body_code"),resultSet.getString("body_name")));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            closeConnection();
//        }
        return bodys;
	  }
  @Override
  public boolean addOneValue(CheckIn p) {
    boolean rest=true;
    try {
      openConnection();
      preparedStatement = connection
              .prepareStatement("INSERT INTO check_ins (LAST_NAME, DOB, START_TIME, END_TIME,FACILITY_ID) values (?, ?, ?, ?,?)");
      preparedStatement.setString(1, p.getLastName());
      preparedStatement.setDate(2, new Date( p.getDob().getTime()));
      preparedStatement.setDate(3,new Date( p.getStartTime().getTime()));
      preparedStatement.setDate(4,new  Date( p.getEndTime().getTime()));
      preparedStatement.setInt(5, p.getFacilityId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      rest=false;
    } finally {
      closeConnection();
    }
    return rest;
  }
  //Checked-in patient list
  public List<CheckIn> finishCheckins() {
	    List<CheckIn> rests=new ArrayList<CheckIn>();
	    boolean rest=true;
	    try {
	      openConnection();
	      preparedStatement = connection
	              .prepareStatement("SELECT * FROM check_ins where start_time is not null and end_time is not null");
	      resultSet = preparedStatement.executeQuery();
	      while (resultSet.next()) {
	    	  rests.add(new CheckIn(
	                resultSet.getInt("id"),
	                resultSet.getString("last_name"),
	                resultSet.getDate("dob"),
	                resultSet.getDate("start_time"),
	                resultSet.getDate("end_time"),
	                resultSet.getInt("facility_id")
	        ));
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      closeConnection();
	    }
	    return rests;
	  }
  //Threated patient list
  public List<CheckIn> treatedCheckins() {
	  List<CheckIn> rests=new ArrayList<CheckIn>();
	    boolean rest=true;
	    try {
	      openConnection();
	      preparedStatement = connection
	              .prepareStatement("SELECT * FROM check_ins where start_time is not null and end_time is not null");
	      resultSet = preparedStatement.executeQuery();
	      while (resultSet.next()) {
	    	  rests.add(new CheckIn(
	                resultSet.getInt("id"),
	                resultSet.getString("last_name"),
	                resultSet.getDate("dob"),
	                resultSet.getDate("start_time"),
	                resultSet.getDate("end_time"),
	                resultSet.getInt("facility_id")
	        ));
	      }
	    } catch (SQLException e) {
	      e.printStackTrace();
	    } finally {
	      closeConnection();
	    }
	    return rests;
	  }
  @Override
  public List<CheckIn> getAllValues() {
    List<CheckIn> rules = null;
    try {
      rules = new ArrayList<CheckIn>(0);
      openConnection();
      preparedStatement = connection
              .prepareStatement("SELECT * FROM check_ins");
      resultSet = preparedStatement.executeQuery();
      while (resultSet.next()) {
        rules.add(new CheckIn(
                resultSet.getInt("id"),
                resultSet.getString("last_name"),
                resultSet.getDate("dob"),
                resultSet.getDate("start_time"),
                resultSet.getDate("end_time"),
                resultSet.getInt("facility_id")
        ));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeConnection();
    }
    return rules;
  }

  @Override
  public List<CheckIn> getBatchByQuery(String queryStr) {
    return null;
  }

  @Override
  public CheckIn getOneByQuery(String queryStr) {
    return null;
  }

  @Override
  public CheckIn getOneById(int id) {
    return null;
  }

  @Override
  public CheckIn getOneById(String id) {
    return null;
  }

  @Override
  public boolean updateValue(CheckIn p) {
	  boolean rest=false;
	    try {
	      openConnection();
	      preparedStatement = connection
	              .prepareStatement("update check_ins set LAST_NAME=?, DOB=?, START_TIME=?, END_TIME=?,FACILITY_ID=?");
	      preparedStatement.setString(1, p.getLastName());
	      preparedStatement.setDate(2, (Date) p.getDob());
	      preparedStatement.setDate(3, (Date) p.getStartTime());
	      preparedStatement.setDate(4, (Date) p.getEndTime());
	      preparedStatement.setInt(5, p.getFacilityId());
	      if(preparedStatement.executeUpdate()>0)
	    	  rest=true;;
	    } catch (SQLException e) {
	      e.printStackTrace();
	      rest=false;
	    } finally {
	      closeConnection();
	    }
	    return rest;
  }

  @Override
  public boolean deleteRecord(CheckIn p) {
    return false;
  }
}
