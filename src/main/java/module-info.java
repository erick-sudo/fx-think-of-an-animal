module com.animal.guessing {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
            
    requires org.controlsfx.controls;
                            
    opens com.animal.guessing to javafx.fxml;
    exports com.animal.guessing;
}