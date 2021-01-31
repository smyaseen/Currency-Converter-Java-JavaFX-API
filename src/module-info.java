module Currency.Converter.Java.JavaFX.and.API {

    requires javafx.fxml;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.controls;
    requires org.json;
    opens org.smy.currencyConverter.controller;
    opens org.smy.currencyConverter;
    opens org.smy.currencyConverter.view;


}