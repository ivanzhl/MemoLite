package memolite.controller;

import memolite.service.TopicService;
import memolite.view.MainView;

public class TopicController {
    private final TopicService service;
    private final MainView view;

    public TopicController(TopicService service, MainView view) {
        this.service = service;
        this.view = view;
        initHandlers();
    }

    private void initHandlers() {
        view.getShuffleButton().setOnAction(e -> {
            String topic = service.shuffleTopic();
            view.getResultLabel().setText(topic);
        });
    }
}
