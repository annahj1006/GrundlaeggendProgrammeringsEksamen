package Presentation;

import Domain.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;


public class HomepageController extends LoginController {
    @FXML
    private GridPane mediaGrid;
    @FXML
    private TextField SearchBar1;

    @FXML
    protected Text errorMsgForUser;
    protected Grid grid;

    public HomepageController() {
        super();
    }
    @FXML
    public void initialize(){
        grid = new Grid(mediaGrid);
        grid.gridLoader(super.o.getMix());
    }
    @FXML
    public void homeButtonPressed(ActionEvent event) {
        try {
            root = FXMLLoader.load(App.class.getResource("/fxml/HomePage.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (NullPointerException | IOException e) {
            returnNullList();
            errorMsgForUser.setText("Could not retrive the page");
        }
    }
    @FXML
    public void filmButtonPressed(){
        grid.gridLoader(o.getMovies());
    }
    @FXML
    public void serierButtonPressed(){
        grid.gridLoader(o.getTvShow());
    }
    @FXML
    public void genreButtonPressed(ActionEvent event) {
        try {
            root = FXMLLoader.load(App.class.getResource("/fxml/GenrePage.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (NullPointerException | IOException e) {
            returnNullList();
            errorMsgForUser.setText("Could not retrive the page");
        }
    }
    @FXML
    public void minListeButtonPressed(){
        grid.gridLoader(o.getMyList());
    }
    @FXML
    public void accountButtonPressedHomePage(ActionEvent event) {
        data.getUser().saveMyList();
        try {
            root = FXMLLoader.load(App.class.getResource("/fxml/LoginPage.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (NullPointerException | IOException e) {
            returnNullList();
            errorMsgForUser.setText("Could not logout");
        }
    }
    @FXML
    public void searching(){
        try {
            grid.gridLoader(o.search(SearchBar1.getText()));
            errorMsgForUser.setText("");
        } catch (NoResultsFoundException e) {
            grid.gridLoader(e.getEmptyList());
            errorMsgForUser.setText(e.getMessage());
        }
    }
    protected void returnNullList() {
        grid.gridLoader(Collections.emptyList());
    }
}