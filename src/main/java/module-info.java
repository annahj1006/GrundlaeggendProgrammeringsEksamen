module com.example.grundlggendeprogrammeringeksamene {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.grundlggendeprogrammeringeksamene to javafx.fxml;
    exports com.example.grundlggendeprogrammeringeksamene;
}