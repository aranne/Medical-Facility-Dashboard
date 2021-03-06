package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.model.Vital;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

public class EnterVital extends BasePage implements PageView {
    private Vital vital;

    public EnterVital(Vital vital) {
        this.vital = vital;
        choicePrompt="input your choice:";
        menuStrs.add("Record");
        menuStrs.add("Go back");
    }
    @Override
    public void display() {
        vital.setTemperature(getRealValue("input Temperature:"));
        vital.setBloodPressureSystolic(getRealValue("input Systolic blood pressure:"));
        vital.setBloodPressureDiastolic(getRealValue("input Diastolic blood pressure:"));
        initPage();
        switch (getChoice()) {
            case 1:
                break;
            case 2:
                vital.setLastName(null);
                break;
        }
    }

}
