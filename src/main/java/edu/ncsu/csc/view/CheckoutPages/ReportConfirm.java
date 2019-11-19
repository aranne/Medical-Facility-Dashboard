package edu.ncsu.csc.view.CheckoutPages;

import edu.ncsu.csc.DAO.MedicalFacilityDAO;
import edu.ncsu.csc.DAO.MedicalFacilityDAOImp;
import edu.ncsu.csc.DAO.NegativeExpeDAOImp;
import edu.ncsu.csc.DAO.StaffDAOImp;
import edu.ncsu.csc.controller.CheckoutPages.ReportManager;
import edu.ncsu.csc.model.NegativeExperience;
import edu.ncsu.csc.model.Reason;
import edu.ncsu.csc.model.ReferralStatus;
import edu.ncsu.csc.model.Report;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

import java.util.List;

public class ReportConfirm extends BasePage implements PageView {
    private Report report;
    private List<Reason> reasons;
    private List<NegativeExperience> negas;
    private ReportManager rpm;
    public ReportConfirm(Report report, ReportManager rpm, List<Reason> reasons, List<NegativeExperience> negas) {
        choicePrompt = "input your choice:";
        menuStrs.add("Confirm");
        menuStrs.add("Go Back");
        this.report = report;
        this.rpm = rpm;
        this.reasons = reasons;
        this.negas = negas;
    }

    public void submit(Report report, ReportManager rpm, List<Reason> reasons, List<NegativeExperience> negas) {
        if(negas.size() == 0){
            if (report.getReferFacilityId() == 0 && report.getReferrerId() == 0) {
                rpm.addOneValueWithoutRefer(report);
            } else{
                rpm.submitReport(report);
                rpm.submitReason(reasons);
            }
        }else{
            if (report.getReferFacilityId() == 0 && report.getReferrerId() == 0) {
                rpm.addOneValueWithoutRefer(report);
                rpm.submitNegativeExperience(negas);
            } else {
                rpm.submitReport(report);
                rpm.submitNegativeExperience(negas);
                rpm.submitReason(reasons);
            }

        }
    }


    @Override
    public void display() {
        running = true;
        while (running) {
            initPage();
            switch (getChoice()) {
                case 1:
                    submit(report, rpm, reasons, negas);
                    showReport();
                    running = false;
                    break;
                case 2:
                    show("the report may not be confirmed");
                    running = false;
                    break;
            }
        }
    }
    public void showReport() {
        String stat = report.getDischargeStatus();
        show("================ Report ================");
        show("Discharge Status:\t" + stat );
        System.out.println();
        System.out.println("Referral Status: ");
        if(report.getReferralStatus() == null){
            show("No referral status here");
        }else if(report.getReferralStatus() != null){
            ReferralStatus rs = report.getReferralStatus();
            int fid = report.getFacilityId();
            int employeeId = report.getEmployeeId();
            if (fid == 0) {
                show("Facility: unknown");
            } else {
                MedicalFacilityDAOImp facilityDao = new MedicalFacilityDAOImp();
                StaffDAOImp staffDao = new StaffDAOImp();
                show("Facility: " + facilityDao.getOneById(fid).getName());
                show("Referrer staff:" + staffDao.getOneById(employeeId));
            }
            for (Reason reason : reasons) {
                show("Reason Code: " + reason.getReasonCode());
                show("Reason Description: " + reason.getDescription());
            }
        }
        System.out.println();
        show("Treatment:\t" + report.getTreatment());
        show("Negative experiences: ");
        for (NegativeExperience nega : negas) {
            show("Code: " + nega.getNegativeCode());
            show("Negative Experience: " + nega.getDescription());
        }
    }
}
