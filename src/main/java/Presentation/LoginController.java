package Presentation;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Node;
import sun.awt.EventQueueItem;

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
    private ActionEvent savedEvent;

    public static void main(String[] args){
        Application.launch(args);
    }

    public void AccountButtonPressed(ActionEvent event) throws IOException {
        try{
            root = FXMLLoader.load(App.class.getResource("src/main/resources/HomePage.fxml"));
            stage = (Stage) ((Node).event.getSource()).getScene().getWindow();
        }
    }

}
