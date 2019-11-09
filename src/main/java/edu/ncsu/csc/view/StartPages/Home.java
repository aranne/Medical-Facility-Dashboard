package edu.ncsu.csc.view.StartPages;

import java.util.Scanner;

import static edu.ncsu.csc.controller.StartPages.Home.*;

public class Home {

  public static void display() {
    Scanner input = new Scanner(System.in);
    int choice = -1 ;
    while (choice != 4) {
      System.out.println("1. Sign In");
      System.out.println("2. Sign Up(Patient)");
      System.out.println("3. Demo Queries");
      System.out.println("4. Exit");
      choice = input.nextInt();
      while (choice < 0 || choice > 5) {
        System.out.println("Wrong input");
        choice = input.nextInt();
      }
      switch (choice) {
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
