module com.mycompany.titulo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens com.mycompany.titulo to javafx.fxml;
    exports com.mycompany.titulo;
}
