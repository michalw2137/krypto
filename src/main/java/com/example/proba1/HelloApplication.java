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

import static szyfr.Files.*;
import static szyfr.Files.getStringFromFile;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 600);
        stage.setTitle("KRYPTOGRAFIA");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException, InvalidResponseException {

        //D:\polibuda\sem4\repo\wspolbiezne\krypto\testFiles\test.txt
        byte[] arr;
        arr = Files.readFileIntoBytesAddExtension("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\test.txt");
        Szyfr s = new Szyfr(arr);
        System.out.println(Arrays.toString(s.getWiadomosc()));
        System.out.println(Arrays.toString(s.getKlucz()));
        Files.writeStringFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\klucz", convertBytesToString(s.getKlucz()));
        s.szyfruj();
        System.out.println(Arrays.toString(s.getOutcome()));
        System.out.println(Arrays.toString(s.getKlucz()));
        Files.writeStringFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\outcome", convertBytesToString(s.getOutcome()));
        System.out.println("HUJ");
        byte[] zaszyfrowane, klucz;
        zaszyfrowane = Files.readBytesfromString(getStringFromFile("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\outcome"));
        klucz = Files.readBytesfromString(getStringFromFile("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\klucz"));
        Szyfr s2 = new Szyfr(zaszyfrowane, klucz);
        s2.szyfruj();
        System.out.println(createFullPath("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\koniec", s.getOutcome()));

//
//        byte[] zaszyfrowane, klucz;
//        zaszyfrowane = Files.readFileIntoBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\outcome.txt");
//        klucz = Files.readFileIntoBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\klucz.txt");
//        s.setWiadomosc(zaszyfrowane);
//        s.setKlucz(klucz);
//        s.szyfruj();
//        Files.writeFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\wynik.txt", s.getOutcome());
//        System.out.println("odszyfrowanie done");

//        byte[] arr = {15,21};
//        Szyfr s = new Szyfr(arr);
//        Files.writeStringFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\testing.txt", arr);
//        System.out.println("huju");
//        byte[] arr2 = Files.readBytesfromString("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\testing.txt");
//        System.out.println(Arrays.toString(arr2));
//        System.out.println("cipa");

        launch();
    }
}