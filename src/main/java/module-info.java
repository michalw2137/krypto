module com.example.proba1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires RandomNumberGenerator;


    opens com.example.proba1 to javafx.fxml;
    exports com.example.proba1;
}