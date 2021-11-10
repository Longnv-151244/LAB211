/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author LongNVHE151244
 */
public class Validation {

    private static final Scanner scan = new Scanner(System.in);

    public static String checkString(String Mess, String regex, boolean Mode) {
        String text;
        do {
            System.out.print(Mess);
            text = scan.nextLine();
            if (text.equalsIgnoreCase("nope") && Mode) {
                return null;
            }
            if (text.matches(regex)) {
                break;
            }
            System.out.println("Invalid input, plz reenter by following: '" + regex + "'");
        } while (true);
        return text;
    }

//    public static Boolean checkBoolean(String Mess, String regex, boolean Mode) {
//        String boo;
//        do {
//            System.out.print(Mess);
//            boo = scan.nextLine();
//            if (boo.matches(regex)) {
//                break;
//            }
//            System.out.println("Invalid input, plz reenter by following: '" + regex + "'");
//        } while (true);
//        return Boolean.valueOf(boo);
//    }
    public static int checkInt(String Mess, int Min, int Max, boolean Mode) {
        int num;
        do {
            System.out.print(Mess);
            String temp = scan.nextLine();
            if (temp.equalsIgnoreCase("nope") && Mode) {
                return -1;
            }
            try {
                num = Integer.parseInt(temp);
                if (num >= Min && num <= Max) {
                    break;
                } else {
                    System.out.println("Out of range, plz enter in range (from " + Min + " to " + Max + ")");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, accept integer number only!");
            }
        } while (true);
        return num;
    }
    
    public static double checkDouble(String Mess, double Min, double Max, boolean Mode) {
        double num;
        do {
            System.out.print(Mess);
            String temp = scan.nextLine();
            if (temp.equalsIgnoreCase("nope") && Mode) {
                return -1.0;
            }
            try {
                num = Double.parseDouble(temp);
                if ((num >= Min && num <= Max) && num % 0.5 == 0) {
                    break;
                } else {
                    System.out.println("Out of range, plz enter in range (from " + Min + " to " + Max + ") and % 0.5");
                }
            } catch (Exception e) {
                System.out.println("Invalid input, accept integer number only!");
            }
        } while (true);
        return num;
    }

    public static Date CheckDate(String Mess, String format, boolean Mode) {
        Date date = new Date();
        SimpleDateFormat SD = new SimpleDateFormat(format, Locale.ENGLISH);
        SD.setLenient(false);
        do {
            System.out.print(Mess);
            String temp = scan.nextLine();
            if (temp.equalsIgnoreCase("nope") && Mode) {
                return null;
            }
            try {
                date = SD.parse(temp);
                break;
            } 
            catch (Exception e) {
                System.out.println("Invalid date input, plz reenter by following: '" + format + "'");
            }
        } while (true);
        return date;
    }
}
