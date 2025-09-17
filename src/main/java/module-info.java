module org.example.drivingschool {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens org.example.drivingschool to javafx.fxml;
    exports org.example.drivingschool;
}