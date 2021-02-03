package org.smy.currencyConverter.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Controller {

    @FXML
    private Label rate;

    @FXML
    private Spinner<Integer> amount;

    @FXML
    private ChoiceBox<String> convertFrom;


    @FXML
    private ChoiceBox<String> convertTo;

    public void initialize() {
        ArrayList<String> currencyList = new ArrayList<>();
        currencyList.add("PKR");
        currencyList.add("USD");
        currencyList.add("ALL");
        currencyList.add("XCD");
        currencyList.add("EUR");
        currencyList.add("BBD");
        currencyList.add("BTN");
        currencyList.add("BND");
        currencyList.add("XAF");
        currencyList.add("CUP");
        currencyList.add("FKP");
        currencyList.add("GIP");
        currencyList.add("HUF");
        currencyList.add("IRR");
        currencyList.add("JMD");
        currencyList.add("AUD");
        currencyList.add("LAK");
        currencyList.add("LYD");
        currencyList.add("MKD");
        currencyList.add("XOF");
        currencyList.add("NZD");
        currencyList.add("OMR");
        currencyList.add("PGK");
        currencyList.add("RWF");
        currencyList.add("WST");
        currencyList.add("RSD");
        currencyList.add("SEK");
        currencyList.add("TZS");
        currencyList.add("AMD");
        currencyList.add("BSD");
        currencyList.add("BAM");
        currencyList.add("CVE");
        currencyList.add("CNY");
        currencyList.add("CRC");
        currencyList.add("CZK");
        currencyList.add("ERN");
        currencyList.add("GEL");
        currencyList.add("HTG");
        currencyList.add("INR");
        currencyList.add("JOD");
        currencyList.add("KRW");
        currencyList.add("LBP");
        currencyList.add("MWK");
        currencyList.add("MRO");
        currencyList.add("MZN");
        currencyList.add("ANG");
        currencyList.add("PEN");
        currencyList.add("QAR");
        currencyList.add("STD");
        currencyList.add("SLL");
        currencyList.add("SOS");
        currencyList.add("SDG");
        currencyList.add("SYP");
        currencyList.add("AOA");
        currencyList.add("AWG");
        currencyList.add("BHD");
        currencyList.add("BZD");
        currencyList.add("BWP");
        currencyList.add("BIF");
        currencyList.add("KYD");
        currencyList.add("COP");
        currencyList.add("DKK");
        currencyList.add("GTQ");
        currencyList.add("HNL");
        currencyList.add("IDR");
        currencyList.add("ILS");
        currencyList.add("KZT");
        currencyList.add("KWD");
        currencyList.add("LSL");
        currencyList.add("MYR");
        currencyList.add("MUR");
        currencyList.add("MNT");
        currencyList.add("MMK");
        currencyList.add("NGN");
        currencyList.add("PAB");
        currencyList.add("PHP");
        currencyList.add("RON");
        currencyList.add("SAR");
        currencyList.add("SGD");
        currencyList.add("ZAR");
        currencyList.add("SRD");
        currencyList.add("TWD");
        currencyList.add("TOP");
        currencyList.add("VEF");
        currencyList.add("DZD");
        currencyList.add("ARS");
        currencyList.add("AZN");
        currencyList.add("BYR");
        currencyList.add("BOB");
        currencyList.add("BGN");
        currencyList.add("CAD");
        currencyList.add("CLP");
        currencyList.add("CDF");
        currencyList.add("DOP");
        currencyList.add("FJD");
        currencyList.add("GMD");
        currencyList.add("GYD");
        currencyList.add("ISK");
        currencyList.add("IQD");
        currencyList.add("JPY");
        currencyList.add("KPW");
        currencyList.add("LVL");
        currencyList.add("CHF");
        currencyList.add("MGA");
        currencyList.add("MDL");
        currencyList.add("MAD");
        currencyList.add("NPR");
        currencyList.add("NIO");
        currencyList.add("PYG");
        currencyList.add("SHP");
        currencyList.add("SCR");
        currencyList.add("SBD");
        currencyList.add("LKR");
        currencyList.add("THB");
        currencyList.add("TRY");
        currencyList.add("AED");
        currencyList.add("VUV");
        currencyList.add("YER");
        currencyList.add("AFN");
        currencyList.add("BDT");
        currencyList.add("BRL");
        currencyList.add("KHR");
        currencyList.add("KMF");
        currencyList.add("HRK");
        currencyList.add("DJF");
        currencyList.add("EGP");
        currencyList.add("ETB");
        currencyList.add("XPF");
        currencyList.add("GHS");
        currencyList.add("GNF");
        currencyList.add("HKD");
        currencyList.add("XDR");
        currencyList.add("KES");
        currencyList.add("KGS");
        currencyList.add("LRD");
        currencyList.add("MOO");
        currencyList.add("MVR");
        currencyList.add("MXN");
        currencyList.add("NOK");
        currencyList.add("NAD");
        currencyList.add("PLN");
        currencyList.add("RUB");
        currencyList.add("SZL");
        currencyList.add("TJS");
        currencyList.add("TTD");
        currencyList.add("UGX");
        currencyList.add("UYU");
        currencyList.add("VND");
        currencyList.add("TND");
        currencyList.add("UAH");
        currencyList.add("UZS");
        currencyList.add("TMT");
        currencyList.add("GBP");
        currencyList.add("ZMW");
        currencyList.add("BTC");
        currencyList.add("BYN");
        currencyList.add("BMD");
        currencyList.add("GGP");
        currencyList.add("CLF");
        currencyList.add("CUC");
        currencyList.add("IMP");
        currencyList.add("JEP");
        currencyList.add("SVC");
        currencyList.add("ZMK");
        currencyList.add("XAG");
        currencyList.add("ZWL");

        Collections.sort(currencyList);

        convertFrom.getItems().addAll(currencyList);
        convertTo.getItems().addAll(currencyList);

        convertFrom.getSelectionModel().select("USD");
        convertTo.getSelectionModel().select("PKR");



        amount.getValueFactory().setValue(1);

    }

    @FXML
    public void reverseConversion() {

        String convertToString = convertFrom.getSelectionModel().getSelectedItem();

        convertFrom.getSelectionModel().select(
                convertTo.getSelectionModel().getSelectedItem()
        );

        convertTo.getSelectionModel().select(convertToString);

        try {
        convert();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void convert() throws Exception {

        double exchangeRate = getRate(
                convertFrom.getSelectionModel().getSelectedItem(),
                convertTo.getSelectionModel().getSelectedItem()
        );

        if (exchangeRate >= 0)
            rate.setText("" + exchangeRate*amount.getValue());

        else
            throw new Exception("getRate() error");

    }

    private double getRate(String from, String to) {
        try {
            // get free api from https://free.currencyconverterapi.com/
            URL url = new URL("Your api");
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responsecode = conn.getResponseCode();

            if (responsecode != 200) {
                throw new RuntimeException("" + responsecode);
            } else {
                Scanner sc = new Scanner(url.openStream());
                StringBuilder inline = new StringBuilder();
                while (sc.hasNext()) {
                    inline.append(sc.nextLine());
                }

                String exchangeRateString = inline.substring(inline.indexOf(":") + 1, inline.indexOf("}"));
                return Double.parseDouble(exchangeRateString);

            }
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }



}
