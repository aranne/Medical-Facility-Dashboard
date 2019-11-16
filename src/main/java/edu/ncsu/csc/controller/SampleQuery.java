package edu.ncsu.csc.controller;

/*
1. Find all patients that were discharged but had negative experiences at any facility, list their names, facility, check-in date, discharge date and negative experiences
2. Find facilities that did not have a negative experience for a specific period (to be given).
3. For each facility, find the facility that is sends the most referrals to.
4. Find facilities that had no negative experience for patients with cardiac symptoms
5. Find the facility with the most number of negative experiences (overall i.e. of either kind)
6. Find each facility, list the patient encounters with the top five longest check-in phases (i.e. time from begin check-in to when treatment phase begins (list the name of patient, date, facility, duration and list of symptoms).
*/

import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.DAO.NegativeExpeDAOImp;
import edu.ncsu.csc.DAO.PatientDAOImp;
import edu.ncsu.csc.DAO.ReportDAOImp;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.NegativeExperience;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.model.Report;

import java.util.*;

public class SampleQuery {
    public Set queryOne() {
        Set<Patient> patients = new HashSet<>();
        List<Report> reports;
        List<NegativeExperience> negas;
        ReportDAOImp reportDao = new ReportDAOImp();
        reports = reportDao.getBatchByQuery("where discharge_status = Treated Successfully");
        if (reports.size() != 0) {
            NegativeExpeDAOImp negaDao = new NegativeExpeDAOImp();
            PatientDAOImp patientDao = new PatientDAOImp();
            for (Report r : reports) {
                negas = negaDao.getAllByNameAndDob(r.getLastName(), r.getDob(), r.getTime());
                if (negas.size() != 0) {
                    Patient p = patientDao.patientExist(r.getLastName(), r.getDob());
                    patients.add(p);
                }
            }
        }
        return patients;
    }

    public List queryTwo(Date start, Date end) {
        List<MedicalFacility> facilities;
        Set<MedicalFacility> negFacilities = new HashSet<>();
        List<MedicalFacility> posFacilities = new ArrayList<>();
        List<Report> reports;
        List<NegativeExperience> negas;
        ReportDAOImp reportDao = new ReportDAOImp();
        reports = reportDao.getBatchByQuery("where discharge_status = Treated Successfully");
        for (Report r : reports) {
            if (r.getTime().compareTo(start) < 0 || r.getTime().compareTo(end) > 0) {
                reports.remove(r);
            }
        }
        MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
        if (reports.size() != 0) {
            NegativeExpeDAOImp negaDao = new NegativeExpeDAOImp();
            for (Report r : reports) {
                negas = negaDao.getAllByNameAndDob(r.getLastName(), r.getDob(), r.getTime());
                if (negas.size() != 0) {
                    MedicalFacility f = facilityDao.getOneById(r.getFacilityId());
                    negFacilities.add(f);
                }
            }
        }

        facilities = facilityDao.getAllValues();
        for (MedicalFacility f : facilities) {
            if (!negFacilities.contains(f)) {
                posFacilities.add(f);
            }
        }
        return posFacilities;
    }

    public Map queryThree() {
        Map<MedicalFacility, MedicalFacility> map = new HashMap<>();
        Map<Integer, Integer> count;
        List<MedicalFacility> facilities;
        MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
        facilities = facilityDao.getAllValues();
        ReportDAOImp reportDao = new ReportDAOImp();
        List<Report> reports;
        for (MedicalFacility f : facilities) {
            MedicalFacility mostReferFacility = null;
            int id = f.getFacilityId();
            reports = reportDao.getBatchByQuery("where discharge_status = Referred and facility_id = " + id);
            if (reports.size() != 0) {
                count = new HashMap<>();
                int max = 0;
                int mostReferId = 0;
                for (Report r : reports) {
                    int referId = r.getReferFacilityId();
                    count.put(referId, count.getOrDefault(referId, 0) + 1);
                    if (max < count.get(referId)) {
                        mostReferId = referId;
                        max = count.get(referId);
                    }
                }
                mostReferFacility = facilityDao.getOneById(mostReferId);
            }
            map.put(f, mostReferFacility);
        }
        return map;
    }
}
