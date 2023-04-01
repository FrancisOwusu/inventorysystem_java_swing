/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inventorysystem;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author FrancisOwusu
 */
public class SMSAPI {

    /**
     *
     * @author FrancisOwusu
     */
    protected String API_key = "xxxxxxxxxxxxxxxxxxxxxxxx";
    protected String message = "Sending SMS has never been this fun!";
    protected String phone_number ="02xxxxxxxx";
    protected String sender_id = "xxxxxxxxxx"; //11 characters

    protected void sendSms(String msg) throws Exception {

        URL url = new URL("http://clientlogin.bulksmsgh.com/smsapi?key=" + API_key + "&to=" + phone_number + "&msg=" + msg + "&sender_id=" + sender_id);

        /**
         * **************API URL TO CHECK BALANCE***************
         */
//        URL url = new URL("http://clientlogin.bulksmsgh.com/api/smsapibalance?key=" + API_key);
        URLConnection connection = url.openConnection();
        try ( BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String inputLine;

            inputLine = in.readLine();
            if (inputLine != null) {
                inputLine = inputLine.trim();
                // process the trimmed line here
            }

            switch (inputLine) {
                case "1000" -> System.out.println("Message sent");
                case "1002" -> System.out.println("Message not sent");
                case "1003" -> System.out.println("You don't have enough balance");
                case "1004" -> System.out.println("Invalid API Key");
                case "1005" -> System.out.println("Phone number not valid");
                case "1006" -> System.out.println("Invalid Sender ID");
                case "1008" -> System.out.println("Empty message");
                default -> {
                }
            }
        }

    }
}
