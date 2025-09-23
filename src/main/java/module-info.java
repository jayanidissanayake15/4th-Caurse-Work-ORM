module org.example.drivingschool {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires org.hibernate.orm.core;
    // This is the correct module for Jakarta Persistence
    requires jakarta.persistence;
    requires java.naming;
    requires static lombok;

    opens lk.ijse to javafx.fxml;
    opens lk.ijse.controller to javafx.fxml;
    opens lk.ijse.entity to org.hibernate.orm.core;
    opens lk.ijse.dto to javafx.base;
    opens lk.ijse.dto.tm to javafx.base;

    exports lk.ijse;
}