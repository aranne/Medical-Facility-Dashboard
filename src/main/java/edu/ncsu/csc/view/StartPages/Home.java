package edu.ncsu.csc.view.StartPages;

import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.ComboBoxPage;
import edu.ncsu.csc.view.PageView;

import java.util.List;


public class Home extends BasePage implements PageView {
    public Home() {
        super();
        menueStrs.add("Sign in");
        menueStrs.add("Sign Up(Patient)");
        menueStrs.add("Demo Queries");
        menueStrs.add("Go Back");
        pageTitle = "==================== HOME ====================";
        choicePrompt = "input your choice:";
    }

    public void display() {
        running = true;
        while (running) {
            initPage();
            PageView p = null;
            switch (getChoice()) {
                case 1:
                    p = new SignIn();
                    p.display();
                    break;
                case 2:
                    p = new SignUp();
                    p.display();
                    break;
                case 3:
                //TODO
                	break;
                case 4:
                    running = false;
                    break;
            }
        }
    }

}
