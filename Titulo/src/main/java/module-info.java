module com.mycompany.titulo {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.sql;
    requires org.postgresql.jdbc;
    requires java.base;

    opens com.mycompany.titulo to javafx.fxml;
    exports com.mycompany.titulo;
}
