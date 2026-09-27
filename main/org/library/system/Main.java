package org.library.system;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.library.system.utils.AlertUtils;
import org.library.system.utils.AppStatus;
import org.library.system.utils.SceneManager;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        SceneManager.getInstanciaSceneManager().setPrimaryStage(stage);

        // Cargar el icono
        try {
            java.net.URL iconUrl = getClass().getResource(
                    "/org/library/system/resources/images/library-book.png"
            );

            if (iconUrl != null) {
                Image icon = new Image(iconUrl.toExternalForm());
                stage.getIcons().add(icon);
            }
        } catch (Exception e) {
            AlertUtils.instanceAlert().show(AppStatus.UNEXPECTED_ERROR,
                    "Problemas al cargar algunos recursos visuales, continué con normalidad la ejecución del programa.");
        }

        // Cargar la vista inicial (Login)
        SceneManager.getInstanciaSceneManager().goTo(
                "/org/library/system/view/LoginView.fxml"
        );
    }

    public static void main(String[] args) {
        launch(args);
    }
}