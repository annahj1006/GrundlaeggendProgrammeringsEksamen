/* AUTOGENERATED CODE */
module controller {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires javafx.media;
    //requires org.testfx;
    //requires org.testfx.junit;


/*    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;*/

    exports Presentation;
    exports Test;
    exports Domain;

    //exports com.example.test;


    opens Presentation to javafx.fxml;
    opens Test to javafx.fxml;

    //opens controller;
} // THIS IS WORKING

