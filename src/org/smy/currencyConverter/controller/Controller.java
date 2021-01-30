package org.smy.currencyConverter.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
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
            // or any other
            URL url = new URL("[YOUR API]");
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
