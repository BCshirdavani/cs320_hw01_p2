import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import java.net.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Schedule {

    public static void main(String[] args) throws Exception{



        URL bc = new URL("https://www.bellevuecollege.edu/courses/exams/");
        BufferedReader in = new BufferedReader(new InputStreamReader((bc.openStream())));

        String inputLine = "";

        String text = "";
        while ((inputLine = in.readLine()) != null){
            text += inputLine + "\n";
        }
        in.close();

        Pattern pattern = Pattern.compile("<td>(.*)\\s*</td>\\s*<td>(.*)\\s*</td>\\s*<td>(.*)\\s*</td>");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            System.out.println("Class Time: " + matcher.group(1));
            System.out.println("Exam Day: " + matcher.group(2));
            System.out.println("Exam Time: " + matcher.group(3));
            System.out.println("++++++++++++++++++++");
        }


    }


}
