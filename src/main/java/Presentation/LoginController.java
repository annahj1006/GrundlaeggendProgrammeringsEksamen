package Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {

    @FXML
    private Button AccountButtonLoginPage1;

    @FXML
    private Button AccountButtonLoginPage2;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private ActionEvent savedEvent;

    @FXML
    public void accountButtonPressed(ActionEvent event) throws IOException {
        root = FXMLLoader.load(App.class.getResource("/fxml/HomePage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onActionLogin(KeyEvent keyEvent) throws IOException {
        accountButtonPressed(savedEvent);
    }

}
