package Presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class GenrepageController extends HomepageController {

    @FXML
    private Text chosenGenre;

    public GenrepageController()  {
        super();

    }
    @FXML
    public void initialize() {
        super.initialize();
        chosenGenre.setText("All genres");
    }

    @FXML
    public void homeButtonPressed(ActionEvent event) {
        super.homeButtonPressed(event);
    }
    @FXML
    public void accountButtonPressed(ActionEvent event) { super.accountButtonPressedHomePage(event); }
    @FXML
    public void genreButtonPressed(ActionEvent event){
        Button button = (Button) event.getSource();
        grid.gridLoader(o.searchByGenre(button.getText().toLowerCase()));
        chosenGenre.setText(button.getText());
    }
}
