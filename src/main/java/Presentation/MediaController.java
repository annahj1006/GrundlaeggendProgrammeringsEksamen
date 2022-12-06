package Presentation;

import Domain.Media;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MediaController {

    @FXML
    private Button addToMyListButton;

    @FXML
    private ImageView mediaImage;

    @FXML
    private Label mediaTitle;

    @FXML
    private Button playButton;

    public void setMedia(Media media){
        mediaImage.setImage(new Image("file:src/main/resources/Data/filmplakater/" + media.getPoster() + ".jpg"));
    }

}
