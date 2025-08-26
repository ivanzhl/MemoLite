package memolite.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.util.Duration;
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

        view.getShuffleButton().setOnMouseEntered(e -> {
            Timeline hoverAnim = new Timeline(
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(view.getShuffleButton().scaleXProperty(), 1),
                            new KeyValue(view.getShuffleButton().scaleYProperty(), 1)
                    ),
                    new KeyFrame(Duration.millis(200),
                            new KeyValue(view.getShuffleButton().scaleXProperty(), 1.05),
                            new KeyValue(view.getShuffleButton().scaleYProperty(), 1.05)
                    )
            );
            hoverAnim.play();
        });

        view.getShuffleButton().setOnMouseExited(e -> {
            Timeline exitAnim = new Timeline(
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(view.getShuffleButton().scaleXProperty(), view.getShuffleButton().getScaleX()),
                            new KeyValue(view.getShuffleButton().scaleYProperty(), view.getShuffleButton().getScaleY())
                    ),
                    new KeyFrame(Duration.millis(200),
                            new KeyValue(view.getShuffleButton().scaleXProperty(), 1),
                            new KeyValue(view.getShuffleButton().scaleYProperty(), 1)
                    )
            );
            exitAnim.play();
        });

    }


}
