package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Report;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ReportDAOImp extends AbstractDAO implements TemplateDAO<Report> {
    @Override
    public boolean addOneValue(Report p) {
    	 boolean rest = true;
         try {
             openConnection();
             preparedStatement = connection
                     .prepareStatement("INSERT INTO reports " +
                             "(time, dob, last_name, discharge_status,treatment,reason,facility_id,employee_id,REFERRER_ID, REFER_FACILITY_ID) " +
                             "values (?, ?, ?, ?,?,?,?,?,?,?)");
             preparedStatement.setTimestamp(1, new java.sql.Timestamp(p.getTime().getTime()));
             preparedStatement.setDate(2, new java.sql.Date(p.getDob().getTime()));
             preparedStatement.setString(3, p.getLastName());
             preparedStatement.setString(4, p.getDischargeStatus());
             preparedStatement.setString(5, p.getTreatment());
             preparedStatement.setString(6, p.getReason());
             preparedStatement.setInt(7, p.getFacilityId());
             preparedStatement.setInt(8, p.getEmployeeId());
             preparedStatement.setInt(9, p.getReferrerId());
             preparedStatement.setInt(10, p.getReferFacilityId());
             preparedStatement.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
             rest = false;
         } finally {
             closeConnection();
         }
         return rest;
    }

    public boolean addOneValueWithoutRefer(Report p) {
        boolean rest = true;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("INSERT INTO reports " +
                            "(time, dob, last_name, discharge_status,treatment,reason,facility_id,employee_id) " +
                            "values (?, ?, ?, ?,?,?,?,?)");
            preparedStatement.setTimestamp(1, new java.sql.Timestamp(p.getTime().getTime()));
            preparedStatement.setDate(2, new java.sql.Date(p.getDob().getTime()));
            preparedStatement.setString(3, p.getLastName());
            preparedStatement.setString(4, p.getDischargeStatus());
            preparedStatement.setString(5, p.getTreatment());
            preparedStatement.setString(6, p.getReason());
            preparedStatement.setInt(7, p.getFacilityId());
            preparedStatement.setInt(8, p.getEmployeeId());
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
    public List<Report> getAllValues() {
        List<Report> reports = new ArrayList<>();
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select * from reports");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                reports.add(new Report(
                        resultSet.getInt("id"),
                        resultSet.getDate("time"),
                        resultSet.getDate("dob"),
                        resultSet.getString("last_name"),
                        resultSet.getString("discharge_status"),
                        resultSet.getString("treatment"),
                        resultSet.getInt("facility_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getString("reason"),
                        resultSet.getInt("referrer_id"),
                        resultSet.getInt("REFER_FACILITY_ID")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return reports;
    }

    @Override
    public List<Report> getBatchByQuery(String queryStr) {
        List<Report> reports = new ArrayList<>();
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select * from reports where " + queryStr);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                reports.add(new Report(
                        resultSet.getInt("id"),
                        resultSet.getDate("time"),
                        resultSet.getDate("dob"),
                        resultSet.getString("last_name"),
                        resultSet.getString("discharge_status"),
                        resultSet.getString("treatment"),
                        resultSet.getInt("facility_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getString("reason"),
                        resultSet.getInt("referrer_id"),
                        resultSet.getInt("REFER_FACILITY_ID")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return reports;
    }

    @Override
    public Report getOneByQuery(String queryStr) {
        Report reports = null;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select * from REPORTS where " + queryStr);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                reports = new Report(
                        resultSet.getInt(1),
                        resultSet.getDate(2),
                        resultSet.getDate(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getInt(7),
                        resultSet.getInt(8),
                        resultSet.getString(9),
                        resultSet.getInt(10),
                        resultSet.getInt(11)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return reports;
    }

    @Override
    public Report getOneById(int id) {
        return null;
    }

    public Report getReportByTimeNameAndDob(Date time, String lastName, Date dob) {
        Report report = null;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select * from REPORTS where time = ? and last_name = ? and dob = ?");
            preparedStatement.setDate(1, new java.sql.Date(time.getTime()));
            preparedStatement.setString(2, lastName);
            preparedStatement.setDate(3, new java.sql.Date(dob.getTime()));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                report = new Report(
                        resultSet.getInt("id"),
                        resultSet.getDate("time"),
                        resultSet.getDate("dob"),
                        resultSet.getString("last_name"),
                        resultSet.getString("discharge_status"),
                        resultSet.getString("treatment"),
                        resultSet.getInt("facility_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getString("reason"),
                        resultSet.getInt("referrer_id"),
                        resultSet.getInt("REFER_FACILITY_ID")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return report;
    }

    public Report getReportByNameAndDob(String lastName, Date dob) {
        Report report = null;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("select * from REPORTS where last_name = ? and dob = ?");
            preparedStatement.setString(1, lastName);
            preparedStatement.setDate(2, new java.sql.Date(dob.getTime()));
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                report = new Report(
                        resultSet.getInt("id"),
                        resultSet.getDate("time"),
                        resultSet.getDate("dob"),
                        resultSet.getString("last_name"),
                        resultSet.getString("discharge_status"),
                        resultSet.getString("treatment"),
                        resultSet.getInt("facility_id"),
                        resultSet.getInt("employee_id"),
                        resultSet.getString("reason"),
                        resultSet.getInt("referer_id"),
                        resultSet.getInt("refer_facility_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return report;
    }

    @Override
    public Report getOneById(String id) {
        return null;
    }
    @Override
    public boolean updateValue(Report p) {
        return false;
    }

    public Report updateReason(Date time, Date dob, String lastname) {
        Report report = null;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("UPDATE reports " +
                            " SET REASON = ? " +
                            " WHERE TIME = ? AND DOB = ? AND LAST_NAME = ?");
            preparedStatement.setString(1, report.getReason());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return report;
    }



    @Override
    public boolean deleteRecord(Report p) {
        return false;
    }
}
