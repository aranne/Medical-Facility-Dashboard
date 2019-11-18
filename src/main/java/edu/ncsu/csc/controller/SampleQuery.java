package edu.ncsu.csc.controller;

/*
1. Find all patients that were discharged but had negative experiences at any facility,
   list their names, facility, check-in date, discharge date and negative experiences
2. Find facilities that did not have a negative experience for a specific period (to be given).
3. For each facility, find the facility that is sends the most referrals to.
4. Find facilities that had no negative experience for patients with cardiac symptoms
5. Find the facility with the most number of negative experiences (overall i.e. of either kind)
6. Find each facility, list the patient encounters with the top five longest check-in phases
   (i.e. time from begin check-in to when treatment phase begins
   (list the name of patient, date, facility, duration and list of symptoms).
*/

import edu.ncsu.csc.DAO.*;
import edu.ncsu.csc.model.*;

import java.util.*;

public class SampleQuery {
    /** Find all patients that were discharged but had negative experiences
     * at any facility, list their names, facility, check-in date, discharge date and negative experiences.
     */
    public Set queryOne() {
        Set<Patient> patients = new HashSet<>();
        List<Report> reports;
        List<NegativeExperience> negas;
        ReportDAOImp reportDao = new ReportDAOImp();
        // Get all reports.
        reports = reportDao.getBatchByQuery("discharge_status = Treated Successfully");
        if (reports.size() != 0) {
            NegativeExpeDAOImp negaDao = new NegativeExpeDAOImp();
            PatientDAOImp patientDao = new PatientDAOImp();
            for (Report r : reports) {
                // For a report, get all negas by name, dob and time
                negas = negaDao.getAllByNameAndDob(r.getLastName(), r.getDob(), r.getTime());
                if (negas.size() != 0) {
                    Patient p = patientDao.patientExist(r.getLastName(), r.getDob());
                    patients.add(p);
                }
            }
        }
        return patients;
    }

    /** Find facilities that did not have a negative experience for a specific period (to be given). */
    public List queryTwo(Date start, Date end) {
        List<MedicalFacility> facilities;
        Set<MedicalFacility> negFacilities = new HashSet<>();
        List<MedicalFacility> posFacilities = new ArrayList<>();
        List<Report> reports;
        List<NegativeExperience> negas;
        ReportDAOImp reportDao = new ReportDAOImp();
        // Get all reports.
        reports = reportDao.getBatchByQuery("discharge_status = Treated Successfully");
        for (Report r : reports) {
            if (r.getTime().compareTo(start) < 0 || r.getTime().compareTo(end) > 0) {
                reports.remove(r);  // Filter reports.
            }
        }
        MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
        if (reports.size() != 0) {
            NegativeExpeDAOImp negaDao = new NegativeExpeDAOImp();
            for (Report r : reports) {
                negas = negaDao.getAllByNameAndDob(r.getLastName(), r.getDob(), r.getTime());
                if (negas.size() != 0) {
                    MedicalFacility f = facilityDao.getOneById(r.getFacilityId());
                    negFacilities.add(f); // Get all negative facilities.
                }
            }
        }
        facilities = facilityDao.getAllValues();
        for (MedicalFacility f : facilities) {
            if (!negFacilities.contains(f)) {
                posFacilities.add(f);  // Get all positive facilities.
            }
        }
        return posFacilities;
    }

    /** For each facility, find the facility that is sends the most referrals to. */
    public Map queryThree() {
        Map<MedicalFacility, MedicalFacility> map = new HashMap<>();
        Map<Integer, Integer> count;
        List<MedicalFacility> facilities;
        MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
        facilities = facilityDao.getAllValues();
        ReportDAOImp reportDao = new ReportDAOImp();
        List<Report> reports;
        // For each facility
        for (MedicalFacility f : facilities) {
            MedicalFacility mostReferFacility = null;
            int id = f.getFacilityId();
            // Get all reports.
            reports = reportDao.getBatchByQuery("discharge_status = Referred and facility_id = " + id);
            if (reports.size() != 0) {
                // Count how many times this facility refers to another facility.
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
            // Get the most referred facility.
            map.put(f, mostReferFacility);
        }
        return map;
    }

    /** Find facilities that had no negative experience for patients with cardiac symptoms. */
    public List queryFour() {
        List<MedicalFacility> facilities;
        MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
        // Get all facilities.
        facilities = facilityDao.getAllValues();
        Set<Integer> negaIds = new HashSet<>();

        SymptomDAOImp symptomDao = new SymptomDAOImp();
        Symptom symptom = symptomDao.getOneByQuery("name = cardiac");
        String symCode = symptom.getSymCode();
        SymptomMetaDAOImp symMetaDao = new SymptomMetaDAOImp();
        // Get all symMetas.
        List<PatientSymMeta> symMetas = symMetaDao.getBatchByQuery("sym_code = " + symCode);
        ReportDAOImp reportDao = new ReportDAOImp();
        NegativeExpeDAOImp negaDao = new NegativeExpeDAOImp();
        List<NegativeExperience> negas;
        for (PatientSymMeta sm : symMetas) {
            // Get all reports for a certain patient.
            List<Report> reports = reportDao.getBatchByQuery("discharge_status = Treated Successfully " +
                    "and last_name = " + sm.getLastName() + "and dob = " + sm.getDob());
            for (Report r : reports) {
                negas = negaDao.getAllByNameAndDob(r.getLastName(), r.getDob(), r.getTime());
                if (negas.size() != 0) {
                    negaIds.add(r.getFacilityId());
                }
            }
        }
        List<MedicalFacility> posFacilities = new ArrayList<>();
        for (MedicalFacility f : facilities) {
            int id = f.getFacilityId();
            if (!negaIds.contains(id)) {
                posFacilities.add(f);  // Get all positive facilities.
            }
        }
        return posFacilities;
    }

    /** Find the facility with the most number of negative experiences (overall i.e. of either kind). */
    public MedicalFacility queryFive() {
        // Count how many times a facility shows up.
        Map<Integer, Integer> count = new HashMap<>();
        ReportDAOImp reportDao = new ReportDAOImp();
        NegativeExpeDAOImp negaDao = new NegativeExpeDAOImp();
        // Get all negative experiences.
        List<NegativeExperience> negas = negaDao.getAllValues();
        for (NegativeExperience n : negas) {
            // For a negative experience, find its report.
            Report report = reportDao.getReportByTimeNameAndDob(n.getTime(), n.getLastName(), n.getDob());
            if (report.getDischargeStatus().equals("Treated Successfully")) {
                int facilityId = report.getFacilityId();
                count.put(facilityId, count.getOrDefault(facilityId, 0) + 1);
            }
        }
        List<MedicalFacility> facilities;
        MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
        facilities = facilityDao.getAllValues();
        int maxFacilityId = 0;
        int max = 0;
        for (MedicalFacility f : facilities) {
            if (max < count.get(f.getFacilityId())) {
                max = count.get(f.getFacilityId());
                maxFacilityId = f.getFacilityId();
            }
        }
        if (maxFacilityId == 0) {
            System.out.println("There doesn't exist any experience for any facility.");
        }
        return facilityDao.getOneById(maxFacilityId);
    }

    /** Find each facility, list the patient encounters with the top five longest check-in phases
     (i.e. time from begin check-in to when treatment phase begins
     (list the name of patient, date, facility, duration and list of symptoms).
     */
    public Map querySix() {
        Map<MedicalFacility, List<Patient>> map = new HashMap<>();
        PriorityQueue<CheckIn> pq;
        List<MedicalFacility> facilities;
        MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
        facilities = facilityDao.getAllValues();
        CheckInDAOImp checkInDao = new CheckInDAOImp();
        List<CheckIn> checkIns;
        PatientDAOImp patientDao = new PatientDAOImp();
        for (MedicalFacility f : facilities) {
            checkIns = checkInDao.getBatchByQuery("facility_id = " + f.getFacilityId());
            pq = new PriorityQueue<>();
            for (CheckIn c : checkIns) {
                pq.offer(c);
                if (pq.size() > 5) {
                    pq.poll();
                }
            }
            List<Patient> patients = new ArrayList<>();
            for (CheckIn c : pq) {
                Patient p = patientDao.patientExist(c.getLastName(), c.getDob());
                patients.add(0, p);
            }
            map.put(f, patients);
        }
        return map;
    }
}
