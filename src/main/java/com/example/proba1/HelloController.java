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

import static szyfr.Files.*;

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
            arr = Files.readFileIntoBytesAddExtension(inputPath.getText());
            System.out.println(inputPath.getText());
            Szyfr s = new Szyfr(arr);

            Files.writeStringFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\klucz", convertBytesToString(s.getKlucz()));
            s.szyfruj();
            Files.writeStringFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\outcome", convertBytesToString(s.getOutcome()));
            output.setText("odkodowanie pomyślnie zakończone");
            outputPath.setText("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\outcome");
            kluczField.setText("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\klucz");
        } else {
            arr = Files.stringToBytes(input.getText());
            Szyfr s = new Szyfr(arr);

            Files.writeStringFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\klucz", convertBytesToString(s.getKlucz()));
            s.szyfruj();
            Files.writeStringFromBytes("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\outcome", convertBytesToString(s.getOutcome()));
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
            Files.writeFileFromBytesWithExtension("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\koniec", s.getOutcome());
            output.setText("odkodowanie pomyślnie zakończone");
            outputPath.setText(createFullPath("D:\\polibuda\\sem4\\repo\\wspolbiezne\\krypto\\testFiles\\koniec", s.getOutcome()));
        } else {
            zaszyfrowane = Files.readBytesfromString(input.getText());
            klucz = Files.readBytesfromString(kluczField.getText());
            Szyfr s = new Szyfr(zaszyfrowane, klucz);
            s.szyfruj();
            String test = new String(s.getOutcome(), StandardCharsets.UTF_8);
            output.setText(test);
        }
    }
}