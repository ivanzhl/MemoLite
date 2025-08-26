package memolite.controller;

import memolite.service.TopicService;
import memolite.view.ShuffleView;

public class ShuffleController {
    private final TopicService service;
    private final ShuffleView view;

    public ShuffleController(TopicService service, ShuffleView view) {
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
