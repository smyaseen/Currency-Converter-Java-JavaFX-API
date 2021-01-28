package org.smy.currencyConverter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class mvp {

    public static void main(String[] args) {
        try {
            URL url = new URL("[api from currencyconverter");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("" + responsecode);
            } else {
                Scanner sc = new Scanner(url.openStream());
                String inline = "";
                while (sc.hasNext()) {
                    inline += sc.nextLine();
                }

                System.out.println(inline);

            }




        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
