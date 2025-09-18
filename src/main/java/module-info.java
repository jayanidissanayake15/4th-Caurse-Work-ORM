module org.example.drivingschool {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens lk.ijse to javafx.fxml;
    exports lk.ijse;
}