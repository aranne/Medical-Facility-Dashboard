package edu.ncsu.csc.controller.StaffPages;

import edu.ncsu.csc.DAO.SeverityDAOImp;
import edu.ncsu.csc.model.Severity;

import java.util.List;

public class AddSeverityScale {
    public boolean addScale(List<Severity> severities) {
    	SeverityDAOImp serdao=new SeverityDAOImp();
    	return serdao.addSeverities(severities);
    }

}