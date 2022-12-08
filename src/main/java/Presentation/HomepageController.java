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

import java.io.IOException;


public class HomepageController {
    @FXML
    private GridPane mediaGrid;

    @FXML
    private Button MinListeButton1;

    @FXML
    private TextField SearchBar1;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Grid grid;

    @FXML
    public void initialize(){
        grid = new Grid(mediaGrid);
        Operations o = new Operations();
        grid.gridLoader(o.mix);
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
    public void filmButtonPressed(ActionEvent event){
        grid = new Grid(mediaGrid);
        Operations o = new Operations();
        grid.gridLoader(o.getMovies());
    }
    @FXML
    public void serierButtonPressed(ActionEvent event){
        grid = new Grid(mediaGrid);
        Operations o = new Operations();
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
    @FXML
    public void searching(ActionEvent event){

    }

}