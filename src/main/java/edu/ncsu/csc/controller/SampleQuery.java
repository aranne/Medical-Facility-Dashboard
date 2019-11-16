package edu.ncsu.csc.controller;

/*
1. Find all patients that were discharged but had negative experiences at any facility, list their names, facility, check-in date, discharge date and negative experiences
2. Find facilities that did not have a negative experience for a specific period (to be given).
3. For each facility, find the facility that is sends the most referrals to.
4. Find facilities that had no negative experience for patients with cardiac symptoms
5. Find the facility with the most number of negative experiences (overall i.e. of either kind)
6. Find each facility, list the patient encounters with the top five longest check-in phases (i.e. time from begin check-in to when treatment phase begins (list the name of patient, date, facility, duration and list of symptoms).
*/

import edu.ncsu.csc.DAO.ReportDAOImp;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.model.Report;

import java.util.ArrayList;
import java.util.List;

public class SampleQuery {
    public boolean queryOne() {
        boolean result = false;
        List<Patient> patients = new ArrayList<>();
        List<Report> reports = new ArrayList<>();
        ReportDAOImp reportDao = new ReportDAOImp();
        reports = reportDao.getBatchByQuery("where ");
        return result;
    }
}
