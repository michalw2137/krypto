package com.example.proba1;

import com.github.iarks.RandomOrgAPI.InvalidResponseException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import szyfr.Files;
import szyfr.Szyfr;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class HelloController {
    @FXML
    private TextField input;
    @FXML
    private TextField output;
    @FXML
    private TextField inputPath;
    @FXML
    private TextField outputPath;
    @FXML
    private TextField kluczField;
    @FXML
    private Button szyfruj;
    @FXML
    private Button deszyfruj;

    @FXML
    protected void szyfruj() throws IOException, InvalidResponseException {
        byte[] arr;
        if(input.getText().isEmpty()) {
            arr = Files.readFileIntoBytes(inputPath.getText());
            Szyfr s = new Szyfr(arr);

            Files.writeFileFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\klucz.txt", s.getKlucz());
            s.szyfruj();
            Files.writeFileFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\outcome.txt", s.getOutcome());
            output.setText("szyfrowanie pomyślnie zakończone");
            outputPath.setText("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\outcome.txt");
            kluczField.setText("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\klucz.txt");
        } else {
            arr = Files.stringToBytes(input.getText());
            Szyfr s = new Szyfr(arr);

            Files.writeFileFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\klucz.txt", s.getKlucz());
            s.szyfruj();
            Files.writeFileFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\outcome.txt", s.getOutcome());
            String test = new String(s.getOutcome(), StandardCharsets.UTF_8);
            output.setText(test);
        }
    }
    @FXML
    protected void deszyfruj() throws IOException, InvalidResponseException {
        byte[] zaszyfrowane, klucz;
        if(input.getText().isEmpty()) {
            zaszyfrowane = Files.readFileIntoBytes(inputPath.getText());
            klucz = Files.readFileIntoBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\klucz.txt");
            Szyfr s = new Szyfr(zaszyfrowane, klucz);
            s.szyfruj();
            Files.writeFileFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\koniec.txt", s.getOutcome());
            output.setText("odszyfrowanie pomyślnie zakończone");
            outputPath.setText("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\koniec.txt");
        } else {
            zaszyfrowane = Files.stringToBytes(input.getText());
            klucz = Files.stringToBytes(kluczField.getText());
            Szyfr s = new Szyfr(zaszyfrowane, klucz);
            s.szyfruj();
            Files.writeFileFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\wynik.txt", s.getOutcome());
            String test = new String(s.getOutcome(), StandardCharsets.UTF_8);
            output.setText(test);
        }
    }
}