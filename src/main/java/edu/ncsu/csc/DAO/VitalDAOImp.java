package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.Staff;
import edu.ncsu.csc.model.Vital;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

public class VitalDAOImp extends AbstractDAO implements TemplateDAO<Vital> {

    public boolean addVitalStaff(Vital p,Staff staff, CheckIn checkin) {
	 boolean rest=true;
	    try {
	      openConnection();
	      preparedStatement = connection
	              .prepareStatement("INSERT INTO vitals (LAST_NAME, DOB, temperature, blood_pressure_systolic,blood_pressure_diastolic, CHECKIN_TIME) values (?, ?, ?, ?,?,?)");
	      preparedStatement.setString(1, p.getLastName());
	      preparedStatement.setDate(2, new Date( p.getDob().getTime()));
	      preparedStatement.setFloat(3,p.getTemperature());
	      preparedStatement.setFloat(4, p.getBloodPressureSystolic());
	      preparedStatement.setFloat(5, p.getBloodPressureDiastolic());
				preparedStatement.setTimestamp(6, new java.sql.Timestamp(checkin.getStartTime().getTime()));
	      preparedStatement.executeUpdate();
	      preparedStatement = connection
	              .prepareStatement("INSERT INTO staff_records_vital (employee_id,last_name, DOB, temperature, blood_pressure_systolic,blood_pressure_diastolic, CHECKIN_TIME) values (?,?, ?, ?, ?,?,?)");
	      preparedStatement.setInt(1, staff.getEmployeeId());
	      preparedStatement.setString(2, p.getLastName());
	      preparedStatement.setDate(3, new Date( p.getDob().getTime()));
	      preparedStatement.setFloat(4,p.getTemperature());
	      preparedStatement.setFloat(5, p.getBloodPressureSystolic());
	      preparedStatement.setFloat(6, p.getBloodPressureDiastolic());
        preparedStatement.setTimestamp(7, new java.sql.Timestamp(checkin.getStartTime().getTime()));
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
    public boolean addOneValue(Vital p) {
	 boolean rest=true;
	    try {
	      openConnection();
	      preparedStatement = connection
	              .prepareStatement("INSERT INTO vitals (LAST_NAME, DOB, temperature, blood_pressure_systolic,blood_pressure_diastolic) values (?, ?, ?, ?,?)");
	      preparedStatement.setString(1, p.getLastName());
	      preparedStatement.setDate(2, new Date( p.getDob().getTime()));
	      preparedStatement.setFloat(3,p.getTemperature());
	      preparedStatement.setFloat(4, p.getBloodPressureSystolic());
	      preparedStatement.setFloat(5, p.getBloodPressureDiastolic());
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
    public List<Vital> getAllValues() {
        return null;
    }

    @Override
    public List<Vital> getBatchByQuery(String queryStr) {
        return null;
    }

    @Override
    public Vital getOneByQuery(String queryStr) {
        return null;
    }


    @Override
    public Vital getOneById(int id) {
        return null;
    }

    @Override
    public Vital getOneById(String id) {
        return null;
    }

    @Override
    public boolean updateValue(Vital p) {

        return false;
    }

    @Override
    public boolean deleteRecord(Vital p) {

        return false;
    }
}
