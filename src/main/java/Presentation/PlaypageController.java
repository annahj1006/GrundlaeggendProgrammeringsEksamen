package Presentation;

import Domain.Media;
import Domain.TVshow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;

public class PlaypageController extends HomepageController{
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

    private Media media;



    @FXML
    public void homeButtonPressed(ActionEvent event) throws IOException {
        super.homeButtonPressed(event);
    }
    @FXML
    public void accountButtonPressedHomePage(ActionEvent event) throws IOException {
        super.accountButtonPressedHomePage(event);
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
