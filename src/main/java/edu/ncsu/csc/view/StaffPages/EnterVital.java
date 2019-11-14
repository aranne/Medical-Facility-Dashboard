package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.controller.StaffPages.StaffMenuController;
import edu.ncsu.csc.model.CheckIn;
import edu.ncsu.csc.model.Vital;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

public class EnterVital extends BasePage implements PageView {
    private Vital vital;

    public EnterVital(Vital vital) {
        this.vital = vital;
        choicePrompt="input your choice:";
        menueStrs.add("Record");
        menueStrs.add("Go back");
    }
    @Override
    public  void display() {
        initPage();
        switch (getChoice()) {
            case 1:
                vital.setTemperature(getRealValue("input Temperature:"));
                vital.setBloodPressureSystolic(getRealValue("input Systolic blood pressure:"));
                vital.setBloodPressureDiastolic(getRealValue("input Diastolic blood pressure:"));                
                break;
            case 2:
                running = false;
                break;
        }
    }

}
