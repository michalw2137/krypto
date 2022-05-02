package com.example.proba1;

import szyfr.Files;
import szyfr.Szyfr;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Arrays;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
//        byte[] arr;
//        arr = Files.readIntoBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\jaszczur.jpg");
////        for(byte item : arr) {
////            System.out.println(item);
////        }
//        Files.writeFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\dzialaj.jpg", arr);
//        System.out.println("EYO");
//        launch();
        byte[] arr = {15,21};
        Szyfr s = new Szyfr(arr);
        System.out.println(Arrays.toString(s.getWiadomosc()));
        System.out.println(Arrays.toString(s.getKlucz()));
        s.szyfruj();
        System.out.println(Arrays.toString(s.getOutcome()));

    }
}