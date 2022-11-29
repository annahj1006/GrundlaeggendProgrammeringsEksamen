package Presentation;

import Domain.Grid;
import javafx.fxml.FXML;
import javafx.scene.layout.GridPane;
import org.w3c.dom.Text;

import java.awt.*;
import java.awt.event.ActionEvent;


public class HomepageController {
    @FXML
    Button FilmButton;

    @FXML
    Button SerierButton;

    @FXML
    Button GenreButton;

    @FXML
    Button MinListeButton;

    @FXML
    Button AccountButton;

    @FXML
    Button HomeButton;

    @FXML
    TextField SearchBar;

    @FXML
    GridPane MediaGrid;

    private Grid grid;


    @FXML
    public void HomeButtonPressed(javafx.event.ActionEvent actionEvent){
        System.out.println("You clicked me!");

    }

    @FXML
    public void FilmButtonPressed(){

    }

    @FXML
    public void SerierButtonPressed(){

    }

    @FXML
    public void GenreButtonPressed(){

    }

    @FXML
    public void MinListeButtonPressed(){

    }

    @FXML
    public void AccountButtonPressed(){

    }

    public void GridMaker(){
        grid = new Grid(MediaGrid, this);

    }

}
