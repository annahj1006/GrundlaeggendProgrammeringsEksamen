package Presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class App extends Application {

    public static void main(String[] args){
        launch();
    }
    @Override
    public void start(Stage startingStage) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/LoginPage.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            startingStage.setTitle("L");
            startingStage.setScene(scene);
            startingStage.show();
        } catch (IOException e ) {
            System.out.println("xd");
        }
    }

}
