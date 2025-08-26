package memolite;

import atlantafx.base.theme.CupertinoLight;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import memolite.controller.RootController;
import memolite.service.TopicService;
import memolite.view.RootLayout;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        TopicService service = new TopicService();
        RootLayout rootLayout = new RootLayout();
        RootController rootController = new RootController(rootLayout, service);

        Scene scene = new Scene(rootController.getRoot(), 600, 400);
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
