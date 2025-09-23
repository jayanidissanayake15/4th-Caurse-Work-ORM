package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AppInitializer extends Application {

     public static void main(String[] args) {
          launch(args);
     }

     @Override
     public void start(Stage stage) throws IOException {
          Parent root = FXMLLoader.load(getClass().getResource("/view/course.fxml"));

          Scene scene = new Scene(root);

          stage.setScene(scene);
          stage.setTitle("Driving School Management System");
          stage.setMaximized(true);
          stage.show();
     }
}