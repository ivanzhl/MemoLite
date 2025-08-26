package memolite.controller;

import javafx.scene.layout.BorderPane;
import memolite.service.TopicService;
import memolite.view.*;

public class NavigationController {

    private final NavigationView navigationView;
    private final ShuffleView shuffleView;
    private final EditTopicsView editTopicsView;

    public NavigationController(NavigationView navigationView, TopicService service) {
        this.navigationView = navigationView;

        this.shuffleView = new ShuffleView();
        this.editTopicsView = new EditTopicsView();

        new ShuffleController(service, shuffleView);

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
