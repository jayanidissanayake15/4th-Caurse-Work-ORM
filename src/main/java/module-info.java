module org.example.drivingschool {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.drivingschool to javafx.fxml;
    exports org.example.drivingschool;
}