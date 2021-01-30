package org.smy.currencyConverter.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.ImageView;

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

        convert();
    }

    @FXML
    public void convert() {
        rate.setText("" + getRate(
                convertFrom.getSelectionModel().getSelectedItem(),
                convertTo.getSelectionModel().getSelectedItem()
                )*amount.getValue());
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
                String inline = "";
                while (sc.hasNext()) {
                    inline += sc.nextLine();
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
