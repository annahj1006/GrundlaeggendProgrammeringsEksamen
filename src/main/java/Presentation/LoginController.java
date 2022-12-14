package Presentation;

import Domain.Bruger;
import Domain.Media;
import Domain.CurrentUserSingleton;
import Domain.Operations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;


public class LoginController {

    @FXML
    private Text errorMsgException;
    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    protected CurrentUserSingleton data;
    protected static Operations o;

    public LoginController() {


        data = CurrentUserSingleton.getInstance();
    }

    @FXML
    public void accountButtonPressed(ActionEvent event) throws IOException {

            String accountButtonID = ((Button)event.getSource()).getId();
            if(accountButtonID.equals("AccountButtonLoginPage1")) {
                data.setUser(new Bruger("Margrete"));

            } else if (accountButtonID.equals("AccountButtonLoginPage2")) {
                data.setUser(new Bruger("Dorte"));
            }

        try {
            try {
                o = new Operations();
                System.out.println("1");
            } catch (FileNotFoundException e) {
                errorMsgException.setText("No connection to database");
            }
            root = FXMLLoader.load(App.class.getResource("/fxml/HomePage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


            System.out.println("1");
        } catch (NullPointerException | IOException e) {
            errorMsgException.setText("Could not retrive the page");
        }


    }
}