package Presentation;

import Domain.Bruger;
import Domain.Grid;
import Domain.Media;
import Domain.Movie;
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
    private ImageView mediaImage;

    @FXML
    private Label mediaTitle;

    private Media media;
    private Stage stage;
    private Scene scene;
    private Parent root;



    public void setMedia(Media media) {
        this.media = media;
        if (media instanceof Movie){
            mediaImage.setImage(new Image("file:src/main/resources/Data/filmplakater/" + media.getPoster() + ".jpg"));
        }else {
            mediaImage.setImage(new Image("file:src/main/resources/Data/serieforsider/" + media.getPoster() + ".jpg"));
        }
        mediaTitle.setText(media.getName());
    }

    @FXML
    public void playButtonPressed(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(App.class.getResource("/fxml/Playpage.fxml"));
        root = fxmlLoader.load();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        PlaypageController playpageController = fxmlLoader.getController();
        playpageController.setMedia(media);
        stage.setScene(scene);
        stage.show();
    }

    public void addToMyListButtonPressed(ActionEvent event) {
        try {
            if(!(x.mediaExsists(media))) {
                x.addMedia(media);
            } else {
                x.removeMedia(media);
            }
        } catch (NullPointerException e) {
            System.out.println("No user found");
        }
    }
}
