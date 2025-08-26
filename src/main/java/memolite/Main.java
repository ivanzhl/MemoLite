package memolite;

import atlantafx.base.theme.CupertinoLight;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import memolite.controller.NavigationController;
import memolite.service.TopicService;
import memolite.view.NavigationView;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        TopicService service = new TopicService();
        NavigationView navigationView = new NavigationView();
        NavigationController navigationController = new NavigationController(navigationView, service);

        Scene scene = new Scene(navigationController.getRoot(), 600, 400);
        stage.setResizable(false);
        scene.getStylesheets().add(new CupertinoLight().getUserAgentStylesheet());
        stage.setScene(scene);
        stage.setTitle("MemoLite");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
