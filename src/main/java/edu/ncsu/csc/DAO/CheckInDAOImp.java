package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CheckInDAOImp extends AbstractDAO implements TemplateDAO<CheckIn> {

  public List<BodyPart> getBodysByCheckin(CheckIn p) {
    List<BodyPart> bodys = new ArrayList<BodyPart>();
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
    boolean rest = true;
    try {
      openConnection();
      preparedStatement = connection
          .prepareStatement("INSERT INTO check_ins (LAST_NAME, DOB, START_TIME, END_TIME,FACILITY_ID) values (?, ?, ?, ?,?)");
      preparedStatement.setString(1, p.getLastName());
      preparedStatement.setDate(2, new Date(p.getDob().getTime()));
      preparedStatement.setDate(3, new Date(p.getStartTime().getTime()));
      preparedStatement.setDate(4, new Date(p.getEndTime().getTime()));
      preparedStatement.setInt(5, p.getFacilityId());
      preparedStatement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
      rest = false;
    } finally {
      closeConnection();
    }
    return rest;
  }

  //Checked-in patient list
  public List<CheckIn> finishCheckins() {
    List<CheckIn> rests = new ArrayList<CheckIn>();
    boolean rest = true;
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
    List<CheckIn> rests = new ArrayList<CheckIn>();
    boolean rest = true;
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
    boolean rest = false;
    try {
      openConnection();
      preparedStatement = connection
          .prepareStatement("update check_ins set START_TIME=?, END_TIME=? where LAST_NAME=? and DOB=? and FACILITY_ID=?");
      preparedStatement.setDate(1, new java.sql.Date(p.getStartTime().getTime()));
      preparedStatement.setDate(2, new java.sql.Date(p.getEndTime().getTime()));
      preparedStatement.setString(3, p.getLastName());
      preparedStatement.setDate(4, new java.sql.Date(p.getDob().getTime()));
      preparedStatement.setInt(5, p.getFacilityId());
      if (preparedStatement.executeUpdate() > 0)
        rest = true;
      ;
    } catch (SQLException e) {
      e.printStackTrace();
      rest = false;
    } finally {
      closeConnection();
    }
    return rest;
  }

  @Override
  public boolean deleteRecord(CheckIn p) {
    return false;
  }

  public boolean addSymptomMeta(ArrayList<SymptomMeta> symptomMetaList, Patient pd) {


    try {
      openConnection();
      for (SymptomMeta sm : symptomMetaList) {
        String bodyCode;
        if (sm.getBodyPart() == null) {
          bodyCode = null;
        } else {
          bodyCode = sm.getBodyPart().getBodyCode();
        }

//			String symCode = sm.getSymptom().getSymCode();
        String symCode;
        if (sm.getSymptom().getSymCode().equals("unknown")) {
          symCode = sm.getSymptom().getName();
        } else {
          symCode = sm.getSymptom().getSymCode();
        }

        String scale;
        if (sm.getSeverity() == null) {
          scale = null;
        } else {
          scale = sm.getSeverity().getScale();
        }
        String lastName = pd.getLastName();
        Date dob = (Date) pd.getDob();
        String duration = sm.getDuration();
        String incident = sm.getIncident();
        char isFirst;
        if (sm.getIsFirstTime()) {
          isFirst = '1';
        } else {
          isFirst = '0';
        }

        preparedStatement = connection
            .prepareStatement("insert into PATIENT_SYM_META " +
                "(BODY_CODE, SYM_CODE, SCALE, LAST_NAME,DOB,DURATION, CAUSE_INCIDENT, FIRST_OCCURRENCE) values " +
                "(?, ?, ?,?,?,?,?,?)");
        preparedStatement.setString(1, bodyCode);
        preparedStatement.setString(2, symCode);
        preparedStatement.setString(3, scale);
        preparedStatement.setString(4, lastName);
        preparedStatement.setDate(5, dob);
        preparedStatement.setString(6, duration);
        preparedStatement.setString(7, incident);
        preparedStatement.setString(8, String.valueOf(isFirst));
        resultSet = preparedStatement.executeQuery();
      }
    } catch (SQLException e) {
      e.printStackTrace();
      return false;
    } finally {
      closeConnection();
    }

    return true;
  }

  public boolean addCheckin(Patient p, MedicalFacility mf) {
    try {
      openConnection();
      preparedStatement = connection
          .prepareStatement("insert into CHECK_INS" +
              "(LAST_NAME, DOB, START_TIME, FACILITY_ID) values " +
              "(?,?,?,?)");
      preparedStatement.setString(1, p.getLastName());
      preparedStatement.setDate(2, (Date) p.getDob());
      preparedStatement.setDate(3, new java.sql.Date(Calendar.getInstance().getTime().getTime()));
      preparedStatement.setInt(4, mf.getFacilityId());
      resultSet = preparedStatement.executeQuery();
    } catch (SQLException e) {
      closeConnection();
      e.printStackTrace();
      return false;
    } finally {
      closeConnection();
    }
    return true;
  }

}
