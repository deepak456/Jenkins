package com.test;

import org.testng.log4testng.Logger;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

public class demo2
{
    final static Logger logger = Logger.getLogger(demo2.class);
    private static StringBuilder response = new StringBuilder();
    private static String output = null;
    private static Map<String, String> apiResponse = new HashMap<String, String> ();
    public static Map<String, String> doGet(HttpURLConnection conn) {
        response.setLength(0);
        try {
            conn.connect();
            Integer status = conn.getResponseCode();
            BufferedReader br = new BufferedReader(new InputStreamReader (conn.getInputStream()));

            while ((output = br.readLine()) != null) {
                response.append(output);
            }
            apiResponse.put("status", status.toString());
            apiResponse.put("body", response.toString());
            apiResponse.put("contentType",conn.getContentType().substring(0,conn.getContentType().lastIndexOf(";")));
            br.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return apiResponse;
    }


    public static Map<String, String> doPost(HttpURLConnection conn, Map<String, String> input) {
        response.setLength(0);
        try {
            conn.connect();
            if (input.containsKey("payload")) {
                DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
                wr.writeBytes(input.get("payload"));
                wr.flush();
                wr.close();
            }
            InputStream is = null;

            Integer status = conn.getResponseCode();

            if (!(status == HttpURLConnection.HTTP_OK || status == HttpURLConnection.HTTP_CREATED
                    || status == HttpURLConnection.HTTP_NO_CONTENT)) {
                // redirect = true;
                System.out.println("Failed : HTTP error code : " + status);
                is = conn.getErrorStream();
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(is));
                while ((output = br.readLine()) != null) {
                    //System.out.println(conn.getErrorStream());
                    response.append(output);
                }
                throw new RuntimeException("Failed : HTTP error code : " +
                        status +"\n" + "Error Message: "+ response.toString());
            }
            else {
                is = conn.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                // System.out.println("Output from Server .... \n");
                while ((output = br.readLine()) != null) {
                    // System.out.println(output);
                    response.append(output);
                }
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            while ((output = br.readLine()) != null) {
                response.append(output);
            }
            apiResponse.put("status", status.toString());
            apiResponse.put("body", response.toString());
            apiResponse.put("contentType",conn.getContentType().substring(0,conn.getContentType().lastIndexOf(";")));


            br.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return apiResponse;
    }

}
