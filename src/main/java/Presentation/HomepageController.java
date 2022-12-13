package Presentation;

import Domain.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class HomepageController {
    @FXML
    private GridPane mediaGrid;
    @FXML
    private TextField SearchBar1;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Grid grid;
    private Operations o;

    private CurrentUserSingleton data;

    public HomepageController() throws FileNotFoundException {
        o = new Operations();
        data = CurrentUserSingleton.getInstance();
    }

    @FXML
    public void initialize(){
        grid = new Grid(mediaGrid);
        grid.gridLoader(o.getMix());
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
        grid = new Grid(mediaGrid);
        grid.gridLoader(o.search(SearchBar1.getText()));
    }
}