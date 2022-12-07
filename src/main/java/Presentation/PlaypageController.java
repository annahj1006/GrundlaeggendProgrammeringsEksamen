package Presentation;

import Domain.Media;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class PlaypageController {
    @FXML
    private Button AccountButton1;

    @FXML
    private Button HomeButton1;
    @FXML
    private Text mediaTitle;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Media media;

    @FXML
    public void homeButtonPressed(ActionEvent event) throws IOException {
        root = FXMLLoader.load(App.class.getResource("/fxml/HomePage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void accountButtonPressedHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(App.class.getResource("/fxml/LoginPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setMedia(Media media){
        this.media = media;
        mediaTitle.setText(media.getName());
    }

}
