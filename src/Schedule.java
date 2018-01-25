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
            System.out.println("quarter index: " + quarterINDEX);
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
        String choiceLETTER = null;
        while (choiceLETTER == null){
            System.out.println("Enter the initial for the program: ");
            choiceLETTER = scIN.nextLine();
        }

        String qtrYEAR = choiceQTR + choiceYR;
        System.out.println(qtrYEAR);
        String URLquarter = page + "/" + qtrYEAR;
        String textQTR;
        textQTR = URLget.URLcontent(URLquarter);

        System.out.println("textQTR length: " + textQTR.length());
//        System.out.println(textQTR.toString());


        //============================================================  ++
        //  this will concatenate the regular expression
        //        Pattern pattern3 = Pattern.compile("<a\\shref=.+/classes/.+>(A.+)</a>");  // starts with "A"
        String regExpSearch_3;
        String part1 = "<a\\shref=.+/classes/.+>(";
        String part3 = ".+)</a>";
        regExpSearch_3 = part1 + choiceLETTER + part3;

        //  list all programs that start with a letter "A"
        //"<a\\shref=.+/classes/.+>(A.+)</a>"
//        Pattern pattern3 = Pattern.compile("<a\\shref=.+/classes/.+>(A.+)</a>");  // starts with "A"

        //  this will search based on the letter chosen earlier
        Pattern pattern3 = Pattern.compile(regExpSearch_3);


        Matcher matcher3 = pattern3.matcher(textQTR);
        int progINDEX = 0;
        while(matcher3.find()){
            System.out.println(matcher3.group(1));
            progINDEX++;
        }
        System.out.println("progINDEX = " + progINDEX);
        //============================================================  ++





        //  MAKE MENU AGAIN
        //      choose program
        //      choose class
        //          send new string, concat URL, to get new website text
        //          make new reg exp, to grab the schedule
        String choicePROG = null;
        while (choicePROG == null){
            System.out.println("Enter the program's name: ");
            choicePROG = scIN.nextLine();
        }
        String choiceCID = null;
        while (choiceCID == null){
            System.out.println("Enter the course ID: ");
            choiceCID = scIN.nextLine();
        }
        //  use reg exp to grab the URL associated with the program name
        String regExpSearch_4;
//        regExpSearch_4 = "<a\\shref=.(.+).>" + choicePROG + "</a>";
        regExpSearch_4 = "<a\\shref=./classes(.+).>" + choicePROG + "</a>";

        Pattern pattern4 = Pattern.compile(regExpSearch_4);
        Matcher matcher4 = pattern4.matcher(textQTR);
        String URLclass ="";
        String classURLext;
        int urlINDEX = 0;
        while(matcher4.find()){
            System.out.println("matching URL extension is: " + matcher4.group(1));
            classURLext = matcher4.group(1);
            System.out.println("URL of page is: " + page);
            URLclass = page + classURLext;
            System.out.println("Program URL is: " + URLclass);
            urlINDEX++;
        }

        text = URLget.URLcontent(URLclass);

        System.out.println("FINAL PAGE: \n\n" + text);


        String regExpSearch_5;
        


    }


}
