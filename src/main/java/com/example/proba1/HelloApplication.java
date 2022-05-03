package com.example.proba1;

import com.github.iarks.RandomOrgAPI.InvalidResponseException;
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
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException, InvalidResponseException {
//        byte[] arr;
        //D:\polibuda\sem4\repo\wspolbiezne\krypto\testFiles\test.txt
//        arr = Files.readFileIntoBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\test.txt");
//        Szyfr s = new Szyfr(arr);
//
//        Files.writeFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\klucz.txt", s.getKlucz());
//        s.szyfruj();
//        Files.writeFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\outcome.txt", s.getOutcome());
//        System.out.println("szyfrowanie done");
//
//        byte[] zaszyfrowane, klucz;
//        zaszyfrowane = Files.readFileIntoBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\outcome.txt");
//        klucz = Files.readFileIntoBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\klucz.txt");
//        s.setWiadomosc(zaszyfrowane);
//        s.setKlucz(klucz);
//        s.szyfruj();
//        Files.writeFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\wynik.txt", s.getOutcome());
//        System.out.println("odszyfrowanie done");

        byte[] arr = {15,21};
        Szyfr s = new Szyfr(arr);
        Files.writeStringFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\testing.txt", arr);
        System.out.println("huju");
        byte[] arr2 = Files.readBytesfromString("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\testing.txt");
        System.out.println(Arrays.toString(arr2));
        System.out.println("cipa");

        //launch();
    }
}