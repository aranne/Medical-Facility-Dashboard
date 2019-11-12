package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.BodyPart;
import edu.ncsu.csc.model.Symptom;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SymptomDAO extends AbstractDAO implements TemplateDAO<Symptom> {
    public boolean addSymptomWithBody(Symptom p, List<BodyPart> bodyParts) {
        boolean rest=false;
        rest=addOneValue( p);
        for(int i=0;i<bodyParts.size();i++){
            try {
                openConnection();
                preparedStatement = connection
                        .prepareStatement("INSERT INTO SYM_HAS_BODY_PART (SYM_CODE, BODY_CODE) values (?, ?)");
                preparedStatement.setString(1, p.getSymCode());
                preparedStatement.setString(2, bodyParts.get(i).getBodyCode());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                rest=false;
            } finally {
                closeConnection();
            }
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
        List<Symptom> symptoms=null;
        try {
            symptoms=new ArrayList<Symptom>(0);
            openConnection();
            preparedStatement = connection
                    .prepareStatement("SELECT * FROM symptoms");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                symptoms.add(new Symptom(
                        resultSet.getString("name"),
                        resultSet.getString("sym_code")
                ));
            }
        } catch (SQLException e) {
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
