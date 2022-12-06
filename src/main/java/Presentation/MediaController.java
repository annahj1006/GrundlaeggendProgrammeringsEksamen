package Presentation;

import Domain.Grid;
import Domain.Media;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class MediaController {

    @FXML
    private Button addToMyListButton;

    @FXML
    private ImageView mediaImage;

    @FXML
    private Label mediaTitle;

    @FXML
    private Button playButton;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setMedia(Media media) {
        mediaImage.setImage(new Image("file:src/main/resources/Data/filmplakater/" + media.getPoster() + ".jpg"));
        mediaTitle.setText(media.getName());
    }

    @FXML
    public void playButtonPressed(ActionEvent event) throws IOException {
        root = FXMLLoader.load(App.class.getResource("fxml/Playpage.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
