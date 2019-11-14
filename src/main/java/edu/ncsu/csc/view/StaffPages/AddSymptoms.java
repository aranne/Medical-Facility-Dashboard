package edu.ncsu.csc.view.StaffPages;

import edu.ncsu.csc.controller.StaffPages.AddSymptom;
import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.ComboBoxPage;
import edu.ncsu.csc.view.PageView;

import java.util.List;

//
public class AddSymptoms extends BasePage implements PageView {

    public AddSymptoms() {
        menueStrs.add("Record");
        menueStrs.add("Go Back");
        choicePrompt="input your choice:";
        pageTitle="====================== AddSymptoms ==========================";
    }

    @Override
    public  void display() {
        running = true;
        while (running) {
            initPage();
            switch (getChoice()) {
                case 1:
                    //TODO
                    String name=getStringFromInput("input the symptom's name:");
                    String cdoe=getStringFromInput("input the symptom's code:");
                    AddSymptom symm=new  AddSymptom();
                    List<String> bodys=symm.getBodyPartsMenu();
                    List<Integer> indexS=ComboBoxPage.getInstance().mutilSelect(bodys,"choose the associated bodypart:(split by comma)");
                    symm.addSymptom(name,cdoe,indexS);
                    break;
                case 2:
                    running = false;
                    break;
            }
        }
    }
}
