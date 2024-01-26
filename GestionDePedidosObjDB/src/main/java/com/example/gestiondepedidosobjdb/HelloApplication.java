package com.example.gestiondepedidosobjdb;

import clases.Producto;
import clases.Usuario;
import domain.PedidoDAOImp;
import domain.ProductoDAOImp;
import domain.UsuarioDAOImp;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {
    private static Stage myStage;

    @Override
    /**
     * Inicia la aplicación JavaFX configurando la escena principal con el archivo FXML de inicio (login.fxml).
     * Antes de cargar la interfaz gráfica, realiza algunas operaciones de inicialización, como la carga y
     * almacenamiento de productos y usuarios de ejemplo en la base de datos.
     *
     * @param stage El objeto Stage que representa la ventana principal de la aplicación.
     *
     * @throws IOException Si hay algún error al cargar el archivo FXML.
     */
    public void start(Stage stage) throws IOException {
        try {
            // Cargar la lista de productos desde la base de datos y guardarla nuevamente
            ArrayList<Producto> listaProducto = (new ProductoDAOImp()).traerLista();
            (new ProductoDAOImp()).saveAll(listaProducto);

            // Crear usuarios de ejemplo
            Usuario usuario1 = new Usuario("Manolo", "1234", "manolo@gmail.com", new ArrayList<>());
            Usuario usuario2 = new Usuario("Jose", "12345", "jose@gmail.com", new ArrayList<>());
            Usuario usuario3 = new Usuario("Carlos", "123456", "carlos@gmail.com", new ArrayList<>());

            // Almacenar los usuarios de ejemplo en la base de datos
            ArrayList<Usuario> usuarios = new ArrayList<>();
            usuarios.add(usuario1);
            usuarios.add(usuario2);
            usuarios.add(usuario3);
            (new UsuarioDAOImp()).saveAll(usuarios);

        } catch (Exception e) {
            // Manejar cualquier excepción que pueda ocurrir durante la inicialización
        }

        // Configurar la ventana principal con el archivo FXML de inicio (login.fxml)
        myStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Gestión de Pedidos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    /**
     * El método loadFXML carga una escena FXML en la ventana principal.
     *
     * @param ruta La ruta al archivo FXML que se desea cargar.
     * @throws IOException Si ocurre un error al cargar la escena FXML.
     */
    public static void loadFXML(String ruta) {
        try {
            Image imagen = new Image(HelloApplication.class.getClassLoader().getResource("icon.png").toExternalForm());
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(ruta));
            Scene scene = new Scene(fxmlLoader.load(), 1000, 650);
            myStage.getIcons().add(imagen);
            myStage.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}