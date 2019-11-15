package edu.ncsu.csc.view.StaffPages;

import java.util.ArrayList;
import java.util.List;
import edu.ncsu.csc.model.Severity;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;

public class AddSeverityScale extends BasePage implements PageView {
    public AddSeverityScale() {
        choicePrompt="input your choice:";
        menuStrs.add("There's another level for this scale");
        menuStrs.add("There's no more levels");
        menuStrs.add("Go back");
    }


    @Override
    public void display() {
        running = true;
        initPage();
        List<Severity> levels=new ArrayList<Severity>(0);
        AddSeverityScale staffmm=new AddSeverityScale();
        while (running) {
            int index = getChoice();
            switch (index) {
                case 1:
                    Severity sev=new Severity();
                    sev.setName(getStringFromInput("input severity's name:"));
                    sev.setScale(getStringFromInput("input severity's scale:"));
                    sev.setBleeding(getStringFromInput("input severity's bleeding:"));
                    sev.setValue(getNum("input severity's value:"));
                    levels.add(sev);
                    break;
                case 2:
                    if(levels.size()>0) {
                        if(staffmm.addScale(levels)) {
                            show("add severities successfully");
                        }else{
                            show("faild to add severities");
                        }

                    }
                    running = false;
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
    }


	private boolean addScale(List<Severity> levels) {
		// TODO Auto-generated method stub
		return false;
	}
}
