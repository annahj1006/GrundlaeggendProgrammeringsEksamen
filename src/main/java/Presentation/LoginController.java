package Presentation;

import Domain.Bruger;
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
import java.util.ArrayList;
import java.util.List;

public class LoginController {

    @FXML
    private Button AccountButtonLoginPage1;

    @FXML
    private Button AccountButtonLoginPage2;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public List<Bruger> userList = new ArrayList<>();


    @FXML
    public void accountButtonPressed(ActionEvent event) throws IOException {

        String accountButtonID = ((Button)event.getSource()).getId();

        if(accountButtonID.equals("AccountButtonLoginPage1")) {
            Bruger x = new Bruger("Margrete");
        } else if (accountButtonID.equals("AccountButtonLoginPage2")) {
            Bruger x = new Bruger("Dorte");
        }

        root = FXMLLoader.load(App.class.getResource("/fxml/HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
}