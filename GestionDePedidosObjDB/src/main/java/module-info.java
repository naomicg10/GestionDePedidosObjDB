module com.example.gestiondepedidosobjdb {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires javax.persistence;
    requires java.logging;
    requires java.naming;
    requires java.sql;

    opens clases;
    opens domain;
    opens com.example.gestiondepedidosobjdb to javafx.fxml;
    exports com.example.gestiondepedidosobjdb;
}