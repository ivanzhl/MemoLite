package memolite.controller;

import javafx.scene.layout.BorderPane;
import memolite.service.TopicService;
import memolite.view.*;

public class RootController {

    private final RootLayout rootLayout;
    private final MainView mainView;
    private final EditTopicsView editTopicsView;

    public RootController(RootLayout rootLayout, TopicService service) {
        this.rootLayout = rootLayout;

        this.mainView = new MainView();
        this.editTopicsView = new EditTopicsView();

        new TopicController(service, mainView);

        initHandlers();
        rootLayout.setContent(mainView.getRoot());
    }

    private void initHandlers() {
        rootLayout.getMainMenuButton().setOnAction(e ->
                rootLayout.setContent(mainView.getRoot())
        );
        rootLayout.getEditTopicsButton().setOnAction(e ->
                rootLayout.setContent(editTopicsView.getRoot())
        );
    }

    public BorderPane getRoot() {
        return rootLayout.getRoot();
    }
}
