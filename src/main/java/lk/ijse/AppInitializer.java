package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {

     @Override
     public void start(Stage primaryStage) throws Exception {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/Student.fxml"));
          Scene scene = new Scene(loader.load());
          primaryStage.setScene(scene);
          primaryStage.setTitle("Driving School Management System");
          primaryStage.setMaximized(true);
          primaryStage.show();
     }

     public static void main(String[] args) {
          launch(args);
     }
}
