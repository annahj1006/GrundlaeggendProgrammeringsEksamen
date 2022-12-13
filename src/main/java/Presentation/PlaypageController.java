package Presentation;

import Domain.Media;
import Domain.TVshow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class PlaypageController{
    @FXML
    private ImageView playScreen;
    @FXML
    private Text mediaTitle;
    @FXML
    private Text genreText;
    @FXML
    private Text rating;
    @FXML
    private Text seasons;

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
        mediaTitle.setText(media.getName() + " (" + media.getReleaseYear() + ")");
        genreText.setText("Genres: " + media.getGenre());
        rating.setText("Rating: " + media.getRating());

        if(media instanceof TVshow){
            seasons.setText("Episodes: " + ((TVshow) media).getSeriesEpisodes());
        }
    }
    @FXML
    public void playButtonPressed(){
        playScreen.setImage(new Image("file:src/main/resources/Images/white.png"));
    }

}
