package Domain;

import Presentation.HomepageController;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class Grid {
    private GridPane mediaGrid;
    private HomepageController homepageController;

    public Grid(GridPane mediaGrid,HomepageController homepageController){
        this.mediaGrid = mediaGrid;
        this.homepageController = homepageController;
    }

    public void mediaInGrid(List<Media> mix){
        mediaGrid.getChildren().clear();

        int placeRight = 0;
        int placeDown = 1;

        try{
            for (int i = 0; i < mix.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();

                fxmlLoader.setLocation(getClass().getResource("src/main/resources/MediaSkabelon.fxml"));

                VBox mediaBox = fxmlLoader.load();

                if(placeRight == 6){
                    placeRight = 0;
                    placeDown ++;
                }

                mediaGrid.add(mediaBox,placeRight++,placeDown);

                GridPane.setMargin(mediaBox, new Insets(8));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
