package memolite.controller;

import javafx.scene.layout.BorderPane;
import memolite.service.TopicsMemoryService;
import memolite.view.*;

public class NavigationController {
    private final NavigationView navigationView;
    private final ShuffleView shuffleView;
    private final EditTopicsView editTopicsView;
    private final ShuffleController shuffleController;
    private final EditTopicsController editTopicsController;

    public NavigationController(NavigationView navigationView) {
        this.navigationView = navigationView;
        this.shuffleView = new ShuffleView();
        this.editTopicsView = new EditTopicsView();

        TopicsMemoryService topicsMemoryService = new TopicsMemoryService();

        this.shuffleController = new ShuffleController(shuffleView, topicsMemoryService);
        this.editTopicsController = new EditTopicsController(editTopicsView, topicsMemoryService);

        initHandlers();
        navigationView.setContent(shuffleView.getRoot());
    }

    private void initHandlers() {
        navigationView.getMainMenuButton().setOnAction(e ->
                navigationView.setContent(shuffleView.getRoot())
        );
        navigationView.getEditTopicsButton().setOnAction(e ->
                navigationView.setContent(editTopicsView.getRoot())
        );
    }

    public BorderPane getRoot() {
        return navigationView.getRoot();
    }
}
