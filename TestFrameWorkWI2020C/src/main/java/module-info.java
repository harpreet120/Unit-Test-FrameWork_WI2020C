module com.example.testframeworkwi2020c {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires javafx.graphics;
    requires java.compiler;

    exports com.example.testframeworkwi2020c.testSammlung;
    opens com.example.testframeworkwi2020c.testSammlung to javafx.fxml;
    exports com.example.testframeworkwi2020c.CoreSystem;
    opens com.example.testframeworkwi2020c.CoreSystem to javafx.fxml;
}