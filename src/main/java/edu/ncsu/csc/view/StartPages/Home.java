package edu.ncsu.csc.view.StartPages;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import static edu.ncsu.csc.controller.StartPages.Home.*;

public class Home {

  public static void display() {
    Scanner input = new Scanner(System.in);
    ArrayList<String> choices = new ArrayList<>();
    choices.add("1");
    choices.add("2");
    choices.add("3");
    choices.add("4");
    String choice = "-1";

    while (!choice.equals("4") && !choice.equals("3") && !choice.equals("2") && !choice.equals("1")) {
      System.out.println("1. Sign In");
      System.out.println("2. Sign Up(Patient)");
      System.out.println("3. Demo Queries");
      System.out.println("4. Exit");
      choice = input.next();
      while (!choices.contains(choice)) {
        System.out.println("Invalid Input, please try again");
        System.out.println("1. Sign In");
        System.out.println("2. Sign Up(Patient)");
        System.out.println("3. Demo Queries");
        System.out.println("4. Exit");
        choice = input.next();
      }
      switch (Integer.parseInt(choice)) {
        case 1:
          signIn();
          break;
        case 2:
          signUp();
          break;
        case 3:
          demoQueries();
          break;
        case 4:
          exit();
          break;
      }
    }
  }
}
