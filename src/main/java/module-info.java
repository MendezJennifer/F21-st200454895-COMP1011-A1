module com.example.f21st200454895comp1011a1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.f21st200454895comp1011a1 to javafx.fxml;
    exports com.example.f21st200454895comp1011a1;
}