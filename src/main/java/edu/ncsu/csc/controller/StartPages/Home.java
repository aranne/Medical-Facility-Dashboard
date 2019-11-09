package edu.ncsu.csc.controller.StartPages;

import edu.ncsu.csc.view.StartPages.SignIn;
import edu.ncsu.csc.view.StartPages.SignUp;

import java.text.ParseException;

public class Home {
  public static void signIn() {
    SignIn.display();
  }

  public static void signUp() throws ParseException {
    SignUp.display();
  }

  public static void demoQueries() {

  }

  public static void exit() {

  }
}
