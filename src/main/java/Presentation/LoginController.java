package Presentation;

import Domain.Bruger;
import Domain.CurrentUserSingleton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;


public class LoginController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private CurrentUserSingleton data;

    public LoginController() {
        data = CurrentUserSingleton.getInstance();
    }

    @FXML
    public void accountButtonPressed(ActionEvent event) throws IOException, NullPointerException {

        String accountButtonID = ((Button)event.getSource()).getId();

        try {
            if(accountButtonID.equals("AccountButtonLoginPage1")) {
                data.setUser(new Bruger("Margrete"));
            } else if (accountButtonID.equals("AccountButtonLoginPage2")) {
                data.setUser(new Bruger("Dorte"));
            }
        } catch (NullPointerException e) {
            System.out.println("You suck");
        }

        root = FXMLLoader.load(App.class.getResource("/fxml/HomePage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}