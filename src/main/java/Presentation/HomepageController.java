package Presentation;

import Domain.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HomepageController {
    @FXML
    private GridPane mediaGrid;
    @FXML
    private TextField SearchBar1;
    @FXML
    private Text noResultsFound;
    @FXML
    private Text noConnectionToDatabase;

    private Stage stage;
    private Scene scene;
    private Parent root;
    protected Grid grid;
    protected Operations o;


    private CurrentUserSingleton data;

    public HomepageController() {
        data = CurrentUserSingleton.getInstance();
    }
    @FXML
    public void initialize(){
        try {
            o = new Operations();
            grid = new Grid(mediaGrid);
            grid.gridLoader(o.getMix());
        } catch (Exception e) {
            noConnectionToDatabase.setText("No connection to database");
        }

    }
    @FXML
    public void homeButtonPressed(ActionEvent event) throws IOException {
        root = FXMLLoader.load(App.class.getResource("/fxml/HomePage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void filmButtonPressed(){
        grid = new Grid(mediaGrid);
        grid.gridLoader(o.getMovies());
    }
    @FXML
    public void serierButtonPressed(){
        grid = new Grid(mediaGrid);
        grid.gridLoader(o.getTvShow());
    }
    @FXML
    public void genreButtonPressed(ActionEvent event) throws IOException {
        root = FXMLLoader.load(App.class.getResource("/fxml/GenrePage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void minListeButtonPressed(){
        grid = new Grid(mediaGrid);
        grid.gridLoader(o.getMyList());
    }
    @FXML
    public void accountButtonPressedHomePage(ActionEvent event) throws IOException {
        data.getUser().saveMyList();
        root = FXMLLoader.load(App.class.getResource("/fxml/LoginPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void searching(){
        try {
            grid = new Grid(mediaGrid);
            grid.gridLoader(o.search(SearchBar1.getText()));
            noResultsFound.setText("");
        } catch (NoResultsFoundException e) {
            grid.gridLoader(e.getEmptyList());
            noResultsFound.setText(e.getMessage());
        }
    }
}