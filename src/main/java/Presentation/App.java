package Presentation;

import Domain.Operations;
import Domain.Media;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class App /*extends Application*/ {



    public static void main(String[] args){
        //launch();

        Operations x = new Operations();
        for(Media m : x.mix) {
            System.out.println(m.toString());
        }

    }

    /*@Override
    public void start(Stage startingStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/fxml/LoginPage.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        startingStage.setTitle("L");
        startingStage.setScene(scene);
        startingStage.show();
    }*/

}
