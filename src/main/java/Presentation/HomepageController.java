package Presentation;

import Domain.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import java.util.List;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class HomepageController {
    @FXML
    private Button AccountButton1;

    @FXML
    private Button FilmButton1;

    @FXML
    private Button GenreButton1;

    @FXML
    private Button HomeButton1;

    @FXML
    private GridPane MediaGrid;

    @FXML
    private Button MinListeButton1;

    @FXML
    private TextField SearchBar1;

    @FXML
    private Button SerierButton1;
    @FXML
    private AnchorPane anchorpane;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Grid grid;
    private Bruger bruger;

    @FXML
    public void homeButtonPressed(ActionEvent event) throws IOException {
        root = FXMLLoader.load(App.class.getResource("/fxml/HomePage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void filmButtonPressed(ActionEvent event){
        grid = new Grid(MediaGrid, this);
        Operations o = new Operations("src/main/resources/Data/film.txt", "src/main/resources/Data/filmplakater");
        grid.mediaInGrid(o.movies);
    }

    @FXML
    public void serierButtonPressed(ActionEvent event){
    }

    @FXML
    public void genreButtonPressed(ActionEvent event){
    }

    @FXML
    public void minListeButtonPressed(ActionEvent event){

    }

    @FXML
    public void accountButtonPressedHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(App.class.getResource("/fxml/LoginPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /*@FXML
    public void gridMaker(URL location, ResourceBundle resources) throws IOException {
        grid = new Grid(MediaGrid, this);
        bruger = new Bruger(anchorpane);
        homeButtonPressed(new ActionEvent());
    }*/

    @FXML
    public void searching(ActionEvent event){

    }

}