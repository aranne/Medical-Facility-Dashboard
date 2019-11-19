package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.DAO.*;
import edu.ncsu.csc.controller.PatientPages.PatientCheckProceed;
import edu.ncsu.csc.model.*;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;
import edu.ncsu.csc.view.PatientPages.PatientRoutingPage;
import edu.ncsu.csc.model.MedicalFacility;
import edu.ncsu.csc.model.Patient;

import java.util.List;

public class Acknowledgement extends BasePage implements PageView {
    Report report;
    Patient pd;
    MedicalFacility f;
    private List<Reason> reasons;
    private List<NegativeExperience> negas;

    public Acknowledgement(Report report) {
        this.report = report;
        choicePrompt = "Enter Choice (1-3)";
        pageTitle = "=========== Check-out Acknowledgement ===============";
        menuStrs.add("Yes");
        menuStrs.add("No");
        menuStrs.add("Go back");
    }

    @Override
    public void display() {
        // show report
        show("=========== Here is your report ===========");
        PatientCheckProceed pcp = new PatientCheckProceed(f);
        String stat = pcp.getReport(pd).getDischargeStatus();
        show("================ Report ================");
        show("Discharge Status:\t" + stat );
        System.out.println();
        System.out.println("Referral Status: ");
        if(pcp.getReport(pd).getReferralStatus() == null){
            show("No referral status here");
        }else if(pcp.getReport(pd).getReferralStatus() != null){
            ReferralStatus rs = pcp.getReport(pd).getReferralStatus();
            int fid = pcp.getReport(pd).getFacilityId();
            int employeeId = pcp.getReport(pd).getEmployeeId();
            if (fid == 0) {
                show("Facility: unknown");
            } else {
                MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
                StaffDAOImp staffDao = new StaffDAOImp();
                show("Facility: " + facilityDao.getOneById(fid).getName());
                show("Referrer staff:" + staffDao.getOneById(employeeId));
            }
            ReasonDAOImp reasonDao = new ReasonDAOImp();
            reasons = reasonDao.getAllByNameAndDob(pcp.getReport(pd).getLastName(), pcp.getReport(pd).getDob(), pcp.getReport(pd).getTime());
            for (Reason reason : reasons) {
                show("Reason Code: " + reason.getReasonCode());
                show("Reason Description: " + reason.getDescription());
            }
        }
        System.out.println();
        show("Treatment:\t" + pcp.getReport(pd).getTreatment());
        show("Negative experiences: ");
        NegativeExpeDAOImp negaDao = new NegativeExpeDAOImp();
        negas = negaDao.getAllByNameAndDob(pcp.getReport(pd).getLastName(), pcp.getReport(pd).getDob(), pcp.getReport(pd).getTime());
        for (NegativeExperience nega : negas) {
            show("Code: " + nega.getNegativeCode());
            show("Negative Experience: " + nega.getDescription());
        }
        initPage();
        int index = getChoice();
        switch (index) {
            case 1:
            case 3:
                PatientRoutingPage up = new PatientRoutingPage(pd, f);
                up.display();
                break;
            case 2:
                String reason = getStringFromInput("input your reasons:");
                while(null == reason || reason.length() <= 0)
                {
                    show("reason must not be empty!!!");
                    reason = getStringFromInput("input your reasons:");

                }
                ReportDAOImp reportDao = new ReportDAOImp();
                reportDao.updateReason(report.getTime(), report.getDob(), report.getLastName());
                break;
        }

    }

}