package edu.ncsu.csc.view.StartPages;

import edu.ncsu.csc.view.BasePage;
import edu.ncsu.csc.view.PageView;


public class Home extends BasePage implements PageView {
    public Home() {
        super();
        menuStrs.add("Sign in");
        menuStrs.add("Sign Up(Patient)");
        menuStrs.add("Demo Queries");
        menuStrs.add("Go Back");
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
                    running = false;
                	break;
                case 4:
                    running = false;
                    break;
            }
        }
    }

}
