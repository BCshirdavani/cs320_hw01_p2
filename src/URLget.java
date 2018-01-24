//============================================================
//
//  Author:         Beau Shirdavani
//  Date:           1-23-2018
//  Description:    cs320 - prog languages
//                  HW 01 - part 2
//                  BC schedule from URL with reg Exp
//  File:           URLget.java
//                      returns text from webpage or URL
//
//============================================================

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class URLget {

    public static String URLcontent(String urlADDRESS) throws IOException {

        URL bc = new URL(urlADDRESS);
        BufferedReader in = new BufferedReader(new InputStreamReader((bc.openStream())));

        String inputLine = "";

        String text = "";
        while ((inputLine = in.readLine()) != null){
            text += inputLine + "\n";
        }
        in.close();

        return text;

    }


}

