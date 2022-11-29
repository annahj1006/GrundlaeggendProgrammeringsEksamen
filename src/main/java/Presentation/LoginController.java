package Presentation;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginController {
    @FXML
    Button AccountButtonLoginPage1;

    @FXML
    Button AccountButtonLoginPage2;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void accountButtonPressed(ActionEvent event) throws IOException {
        root = FXMLLoader.load(App.class.getResource("src/main/resources/HomePage.fxml"));
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
