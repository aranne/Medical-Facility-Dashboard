package edu.ncsu.csc.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InteractiveTool {
    protected Scanner scanner;
    protected DateFormat dateFormat;
    protected DateFormat timeFormat;
    protected String pageTitle;
    protected String choicePrompt;

    public InteractiveTool() {
        scanner = new Scanner(System.in);
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        timeFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    }


    public void show(String s) {
        if (s.length() > 0)
            System.out.printf(s + ":\n");
    }

    public void show(List<String> menus) {
        for (int i = 0; i < menus.size(); i++) {
            System.out.printf("%d.\t%s\n", i + 1, menus.get(i));
        }
    }

    public int getChoice(int maxv) {
        int index = -1;
        while (true) {
            try {
                index = Integer.parseInt(getStringFromInput(choicePrompt));
            } catch (Exception e) {
                System.out.println("Invalid Menue id");
                continue;
            }
            if (index < 1 || index > maxv) {
                System.out.println("Invalid Menue id");
            } else {
                break;
            }
        }
        return index;
    }

    public String getStringFromInput(String prompt) {
        show(prompt);
        return scanner.nextLine();
    }

    public int getNum(String prompt) {
        int rest = 0;
        while (true) {
            try {
                System.out.print(prompt);
                rest = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date");
                continue;
            }
            return rest;
        }
    }

    public float getRealValue(String prompt) {
        float rest = 0.0f;
        while (true) {
            try {
                System.out.print(prompt);
                rest = Float.parseFloat(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid date");
                continue;
            }
            return rest;
        }
    }

    public Date getDateFromInput(String prompt) {
        Date date;

        while (true) {
            System.out.print(prompt);

            try {
                date = dateFormat.parse(scanner.nextLine());
            } catch (ParseException e) {
                System.out.println("Invalid date");
                continue;
            }

            return date;
        }
    }

    public String getPhoneFromInput(String prompt) {
        while (true) {
            String phone = getStringFromInput(prompt);
            Pattern pattern = Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$");
            Matcher matcher = pattern.matcher(phone);

            if (matcher.matches()) {
                return phone;
            } else {
                System.out.println("Invalid phone number");
            }
        }
    }

    public String getEmailFromInput(String prompt) {
        while (true) {
            String email = getStringFromInput(prompt).toLowerCase();
            Pattern pattern = Pattern.compile("^[\\w.%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");
            Matcher matcher = pattern.matcher(email);

            if (matcher.matches()) {
                return email;
            } else {
                System.out.println("Invalid email address");
            }
        }
    }

}
