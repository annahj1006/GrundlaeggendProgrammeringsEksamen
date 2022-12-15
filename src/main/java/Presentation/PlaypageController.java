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

public class PlaypageController {
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
    @FXML
    private Text errorMsgForUser;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Media media;

    @FXML
    public void homeButtonPressed(ActionEvent event) {
        try {
            root = FXMLLoader.load(App.class.getResource("/fxml/HomePage.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (NullPointerException | IOException e) {
            System.out.println("1");
            errorMsgForUser.setText("Could not retrive the page");
        }
    }
    @FXML
    public void accountButtonPressedHomePage(ActionEvent event) {
        try {
            root = FXMLLoader.load(App.class.getResource("/fxml/LoginPage.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (NullPointerException | IOException e) {
            System.out.println("2");
            errorMsgForUser.setText("Could not logout");
        }
    }
    public void setMedia(Media media) {
        this.media = media;
        mediaTitle.setText(media.getName() + " (" + media.getReleaseYear() + ")");
        genreText.setText("Genres: " + media.getGenre());
        rating.setText("Rating: " + media.getRating());

        if(media.getId().equals("tvShow")) {
            seasons.setText("Episodes: " + ((TVshow) media).getSeriesEpisodes());
        }
    }
    @FXML
    public void playButtonPressed(){
        playScreen.setImage(new Image("file:src/main/resources/Images/white.png"));
    }

}
