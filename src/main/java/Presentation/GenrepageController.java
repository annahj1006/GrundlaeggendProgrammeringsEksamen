package Presentation;

import Domain.Grid;
import Domain.Operations;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class GenrepageController {

    @FXML
    private GridPane mediaGrid;
    @FXML
    private Text chosenGenre;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Grid grid;

    @FXML
    public void initialize(){
        grid = new Grid(mediaGrid);
        Operations o = new Operations();
        grid.gridLoader(o.mix);
        chosenGenre.setText("All genres");
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
    public void accountButtonPressed(ActionEvent event) throws IOException {
        root = FXMLLoader.load(App.class.getResource("/fxml/LoginPage.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void genreButtonPressed(ActionEvent event){
        Button button = (Button) event.getSource();
        Operations o = new Operations();
        grid.gridLoader(o.searchByGenre(button.getText().toLowerCase()));
        chosenGenre.setText(button.getText());
    }
}
