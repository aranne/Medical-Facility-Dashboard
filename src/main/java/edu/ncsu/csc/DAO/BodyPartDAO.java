package edu.ncsu.csc.DAO;
import edu.ncsu.csc.model.BodyPart;
import edu.ncsu.csc.model.Symptom;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BodyPartDAO extends AbstractDAO implements TemplateDAO<BodyPart>{

    public List<BodyPart> getSymptomBodies(Symptom s){
        List<BodyPart> bodyparts = null;
        try {
            bodyparts = new ArrayList<BodyPart>(0);
            openConnection();
            preparedStatement = connection
                    .prepareStatement("SELECT * FROM sym_has_body_part where sym_code="+s.getSymCode()+";");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bodyparts.add(new BodyPart(
                        resultSet.getString("body_code"),
                        resultSet.getString("body_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return bodyparts;
    }
    @Override
    public boolean addOneValue(BodyPart p) {
        boolean rest=true;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("INSERT INTO BODY_PARTS (BODY_CODE, BODY_NAME) values (?, ?)");
            preparedStatement.setString(1, p.getBodyCode());
            preparedStatement.setString(2, p.getBodyName());
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
    public List<BodyPart> getAllValues() {
        List<BodyPart> bodyparts = null;
        try {
            bodyparts = new ArrayList<BodyPart>(0);
            openConnection();
            preparedStatement = connection
                    .prepareStatement("SELECT * FROM body_parts");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                bodyparts.add(new BodyPart(
                        resultSet.getString("body_code"),
                        resultSet.getString("body_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return bodyparts;
    }

    @Override
    public List<BodyPart> getBatchByQuery(String queryStr) {
        return null;
    }

    @Override
    public BodyPart getOneByQuery(String queryStr) {
        return null;
    }

    @Override
    public BodyPart getOneById(int id) {
        return null;
    }

    @Override
    public BodyPart getOneById(String id) {
        return null;
    }

    @Override
    public boolean updateValue(BodyPart p) {

        return false;
    }

    @Override
    public boolean deleteRecord(BodyPart p) {

        return false;
    }
}
