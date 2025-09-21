module org.example.drivingschool {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.persistence;
    requires java.naming;

    opens lk.ijse to javafx.fxml;
    opens lk.ijse.controller to javafx.fxml;

    exports lk.ijse;
}
