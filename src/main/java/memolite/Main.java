package memolite;

import atlantafx.base.theme.CupertinoLight;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import memolite.controller.NavigationController;
import memolite.view.NavigationView;
import javafx.scene.image.Image;


public class Main extends Application {
    @Override
    public void start(Stage stage) {
        final NavigationView navigationView = new NavigationView();
        final NavigationController navigationController = new NavigationController(navigationView);
        final Scene scene = new Scene(navigationController.getRoot(), 600, 400);

        stage.setResizable(false);
        scene.getStylesheets().add(new CupertinoLight().getUserAgentStylesheet());
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("MemoLite");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/icon.png")));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
