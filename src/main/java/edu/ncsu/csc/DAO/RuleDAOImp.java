package edu.ncsu.csc.DAO;

import edu.ncsu.csc.model.Rule;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RuleDAOImp extends AbstractDAO implements TemplateDAO<Rule> {


    @Override
    public boolean addOneValue(Rule p) {
        boolean rest=true;
        try {
            openConnection();
            preparedStatement = connection
                    .prepareStatement("INSERT INTO RULES " +
                            "(BODY_CODE, SYM_CODE, SCALE_LOW, SCALE_HIGH) " +
                            "values (?, ?, ?, ?)");
            preparedStatement.setString(1, p.getBodyCode());
            preparedStatement.setString(2, p.getSymCode());
            preparedStatement.setInt(3, p.getScaleLow());
            preparedStatement.setInt(4, p.getScaleHigh());
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
    public List<Rule> getAllValues() {
        List<Rule> rules=null;
        try {
            rules=new ArrayList<Rule>(0);
            openConnection();
            preparedStatement = connection
                    .prepareStatement("SELECT * FROM rules; ");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                rules.add(new Rule(
                        resultSet.getInt("id"),
                        resultSet.getString("body_code"),
                        resultSet.getString("sym_code"),
                        resultSet.getInt("scale_low"),
                        resultSet.getInt("scale_high")
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
    public List<Rule> getBatchByQuery(String queryStr) {
        List<Rule> rules=null;
        try {
            rules=new ArrayList<Rule>(0);
            openConnection();
            preparedStatement = connection
                    .prepareStatement("SELECT * FROM rules "+queryStr+";");
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                rules.add(new Rule(
                        resultSet.getInt("id"),
                        resultSet.getString("body_code"),
                        resultSet.getString("sym_code"),
                        resultSet.getInt("scale_low"),
                        resultSet.getInt("scale_high")
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
    public Rule getOneByQuery(String queryStr) {
        return null;
    }

    @Override
    public Rule getOneById(int id) {
        return null;
    }

    @Override
    public Rule getOneById(String id) {
        return null;
    }

    @Override
    public boolean updateValue(Rule p) {
        return false;
    }

    @Override
    public boolean deleteRecord(Rule p) {
        return false;
    }
}
