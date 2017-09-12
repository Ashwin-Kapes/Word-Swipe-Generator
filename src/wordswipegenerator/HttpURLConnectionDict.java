/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordswipegenerator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * @author HP
 */
public class HttpURLConnectionDict {

  private final static String USER_ENTRIES = "http://api.pearson.com/v2/dictionaries/entries";
  private final static String USER_AGENT = "Mozilla/5.0";

  public static void isGibbrish(String s) throws Exception {
    sentGetRequest(s);
  }

  private static void sentGetRequest(String gp) throws Exception {
    String finalUrl = USER_ENTRIES.concat("?&search=" + gp);
    URL url = new URL(finalUrl);

    HttpURLConnection con = (HttpURLConnection) url.openConnection();

    con.setRequestMethod("GET");
    con.setRequestProperty("User-Agent", USER_AGENT);

    int responseCode = con.getResponseCode();
    //System.out.println("Sending 'GET' request to URL : " + url);
    //System.out.println("Response Code : " + responseCode);

    BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response = new StringBuffer();

    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();

    //System.out.println(response.toString());

    JSONObject jo = new JSONObject(response.toString());
    Integer countKey = (Integer) jo.get("count");
    if (countKey > 0) {
      System.out.print("########################\n" + gp + "\n########################\n");
    }
    //System.out.println("count: " + tsmresponse);

  }

}
