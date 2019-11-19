package edu.ncsu.csc.view.SampleQuery;

import edu.ncsu.csc.controller.SampleQuery.SampleQuery;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.NegativeExperience;
import edu.ncsu.csc.model.Patient;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class SampleQueryPage extends BasePage implements PageView {
    @Override
    public void display() {
        pageTitle = "==================== SAMPLE QUERIES ====================";
        menuStrs.add("Query one");
        menuStrs.add("Query two");
        menuStrs.add("Query three");
        menuStrs.add("Query four");
        menuStrs.add("Query five");
        menuStrs.add("Query six");
        menuStrs.add("Go back");
        choicePrompt = "Please select a sample query";

        SampleQuery sampleQuery = new SampleQuery();
        running = true;
        while (running) {
            initPage();
            switch (getChoice()) {
                case 1:
                    int i = 1;
                    List<SampleQuery.ReturnOne> returnOnes = sampleQuery.queryOne();
                    for (SampleQuery.ReturnOne r : returnOnes) {
                        System.out.println(i + ". "  + r.getPatient().toString() + " in " + r.getFacilityName() + " checks at " + r.getCheckDate() + " discharges at " + r.getDischargeDate());
                        for (NegativeExperience n : r.getNegas()) {
                            System.out.println(n);
                        }
                        i += 1;
                    }
                    break;
                case 2:
                    Date start = getDateFromInput("Please input start date in format mm/dd/yyyy");
                    Date end = getDateFromInput("Please input end date in format mm/dd/yyyy");
                    List<MedicalFacility> facilities = sampleQuery.queryTwo(start, end);
                    for (MedicalFacility f : facilities) {
                        System.out.println(f);
                    }
                    break;
                case 3:
                    Map<MedicalFacility, MedicalFacility> map = sampleQuery.queryThree();
                    for (MedicalFacility f : map.keySet()) {
                        System.out.println(f + " sends most referrals to " + map.get(f));
                    }
                    break;
                case 4:
                    System.out.println(sampleQuery.queryFour());
                    break;
                case 5:
                    System.out.println(sampleQuery.queryFive());
                    break;
                case 6:
                    Map<MedicalFacility, List<Patient>> map2 = sampleQuery.querySix();
                    System.out.println("Top five longest check-in phases for each facility");
                    for (MedicalFacility f : map2.keySet()) {
                        System.out.println("Five patients for " + f + " are: " + map2.get(f));
                    }
                    break;
                case 7:
                    running = false;
                    break;
            }
         }
    }
}
