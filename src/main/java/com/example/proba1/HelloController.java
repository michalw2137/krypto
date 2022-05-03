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

import static szyfr.Files.convertBytesToString;
import static szyfr.Files.getStringFromFile;

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

            Files.writeStringFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\klucz.txt", convertBytesToString(s.getKlucz()));
            s.szyfruj();
            Files.writeStringFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\outcome.txt", convertBytesToString(s.getOutcome()));
            output.setText("szyfrowanie pomyślnie zakończone");
            outputPath.setText("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\outcome.txt");
            kluczField.setText("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\klucz.txt");
        } else {
            arr = Files.stringToBytes(input.getText());
            Szyfr s = new Szyfr(arr);

            Files.writeStringFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\klucz.txt", convertBytesToString(s.getKlucz()));
            s.szyfruj();
            Files.writeStringFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\outcome.txt", convertBytesToString(s.getOutcome()));
            output.setText(convertBytesToString(s.getOutcome()));
            kluczField.setText(convertBytesToString(s.getKlucz()));
        }
    }
    @FXML
    protected void deszyfruj() throws IOException, InvalidResponseException {
        byte[] zaszyfrowane, klucz;
        if(input.getText().isEmpty()) {
            zaszyfrowane = Files.readBytesfromString(getStringFromFile(inputPath.getText()));
            klucz = Files.readBytesfromString(getStringFromFile(kluczField.getText()));
            Szyfr s = new Szyfr(zaszyfrowane, klucz);
            s.szyfruj();
            Files.writeFileFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\koniec.txt", s.getOutcome());
            output.setText("odszyfrowanie pomyślnie zakończone");
            outputPath.setText("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\koniec.txt");
        } else {
            zaszyfrowane = Files.readBytesfromString(input.getText());
            klucz = Files.readBytesfromString(kluczField.getText());
            Szyfr s = new Szyfr(zaszyfrowane, klucz);
            s.szyfruj();
            Files.writeStringFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\wynik.txt", convertBytesToString(s.getOutcome()));
            String test = new String(s.getOutcome(), StandardCharsets.UTF_8);
            output.setText(test);
        }
    }
}