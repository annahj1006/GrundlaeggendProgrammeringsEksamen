package Presentation;

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
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    public void HomeButtonPressed(ActionEvent event) throws IOException {
        root = FXMLLoader.load(App.class.getResource("/fxml/HomePage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    public void FilmButtonPressed(ActionEvent event){

    }

    @FXML
    public void SerierButtonPressed(ActionEvent event){

    }

    @FXML
    public void GenreButtonPressed(ActionEvent event){

    }

    @FXML
    public void MinListeButtonPressed(ActionEvent event){

    }

    @FXML
    public void AccountButtonPressedHomePage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(App.class.getResource("/fxml/LoginPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void GridMaker(ActionEvent event){

    }

    public void Searching(ActionEvent event){

    }

}