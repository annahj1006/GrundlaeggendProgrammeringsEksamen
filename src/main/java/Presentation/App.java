package Presentation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


abstract class App extends Application {

    private Stage startingStage;

    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage startingStage) throws IOException {
        this.startingStage = startingStage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("src/main/resources/LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        startingStage.setTitle("L");
        startingStage.setScene(scene);
        startingStage.show();
    }

}
