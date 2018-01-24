//============================================================
//
//  Author:         Beau Shirdavani
//  Date:           1-23-2018
//  Description:    cs320 - prog languages
//                  HW 01 - part 2
//                  BC schedule from URL with reg Exp
//  File:           Schedule.java
//                      main
//
//============================================================

// this class will implement the menus
// and call the URL class
// and run the Reg Exp

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Schedule {

    public static void main(String[] args) throws Exception{


        // testing the get URL function and class
        String page = "https://www.bellevuecollege.edu/classes";
        String text;

        text = URLget.URLcontent(page);
//        System.out.println(text);

//        Pattern pattern = Pattern.compile("<td>(.*)\\s*</td>\\s*<td>(.*)\\s*</td>\\s*<td>(.*)\\s*</td>");
//        Matcher matcher = pattern.matcher(text);
//        while(matcher.find()){
//            System.out.println("Class Time: " + matcher.group(1));
//            System.out.println("Exam Day: " + matcher.group(2));
//            System.out.println("Exam Time: " + matcher.group(3));
//            System.out.println("++++++++++++++++++++");
//        }


        // Grab the Quarters available on the website
        Pattern pattern = Pattern.compile("<a\\sclass=.*/classes(.*)\">.*</a>");
        Matcher matcher = pattern.matcher(text);
        int matchCounter = 0;
        while(matcher.find()){
            System.out.println(matcher.group(1));
            matchCounter++;
        }
        System.out.println("match count: " + matchCounter);

        // Now grab the available quarters and put into a string array list
        Pattern pattern2 = Pattern.compile("<a\\sclass=.*/classes(.*)\">.*</a>");
        Matcher matcher2 = pattern2.matcher(text);
        String[] quarters = new String[matchCounter];
        int quarterINDEX = 0;
        while(matcher2.find()){
            System.out.println("quarter indes: " + quarterINDEX);
            quarters[quarterINDEX] = matcher2.group(1);
            quarterINDEX++;
        }



        System.out.println("Available quarter + Year combos listed on page:");
        System.out.println(Arrays.toString(quarters));



        //  MAKE MENU HERE
        //      choose a quarter
        //          send new string, concat URL, to get new website text
        Scanner scIN = new Scanner(System.in);
        String choiceQTR = null;
        while (choiceQTR == null){
            System.out.println("Enter a quarter: ");
            choiceQTR = scIN.nextLine();
        }
        String choiceYR = null;
        while (choiceYR == null){
            System.out.println("Enter a year: ");
            choiceYR = scIN.nextLine();
        }

        String qtrYEAR = choiceQTR + choiceYR;
        System.out.println(qtrYEAR);
        String URLquarter = page + "/" + qtrYEAR;
        String textQTR;
        textQTR = URLget.URLcontent(URLquarter);

        System.out.println("textQTR length: " + textQTR.length());
        System.out.println(textQTR.toString());

        //============================================================  ++
        //  list all programs that start with a letter "A"
        Pattern pattern3 = Pattern.compile("href=\"/classes/Spring2018/A\\w*\"(A.*)</a>");  // starts with "A"
//        Pattern pattern3 = Pattern.compile("<h1.*pageTitle(\\w*)</h1>");
        Matcher matcher3 = pattern3.matcher(textQTR);
        int progINDEX = 0;
        while(matcher3.find()){
            System.out.println("program index: " + progINDEX);
//            System.out.println(matcher3.group(0));
            System.out.println(matcher3.group(1));
//            quarters[progINDEX] = matcher3.group(0);
//            quarters[progINDEX] = matcher3.group(1);
            progINDEX++;
        }
        //============================================================  ++

//        <a href="/classes/Spring2018/ACCT">Accounting</a>


        

        //  MAKE MENU AGAIN
        //      choose program
        //      choose class
        //          send new string, concat URL, to get new website text
        //          make new reg exp, to grab the schedule





    }


}
