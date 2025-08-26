package memolite.controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Button;
import javafx.util.Duration;
import memolite.service.TopicsMemoryService;
import memolite.view.ShuffleView;


public class ShuffleController {
    private final ShuffleView view;
    private final TopicsMemoryService service;

    public ShuffleController(ShuffleView view) {
        this.view = view;
        this.service = new TopicsMemoryService();

        initHandlers();
    }

    private void initHandlers() {
        final Button shuffleButton = view.getShuffleButton();

        shuffleButton.setOnAction(e -> {
            String topic = service.shuffleTopic();
            view.getResultLabel().setText(topic);
        });

        shuffleButton.setOnMouseEntered(e -> {
            Timeline hoverAnim = new Timeline(
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(shuffleButton.scaleXProperty(), 1),
                            new KeyValue(shuffleButton.scaleYProperty(), 1)
                    ),
                    new KeyFrame(Duration.millis(200),
                            new KeyValue(shuffleButton.scaleXProperty(), 1.05),
                            new KeyValue(shuffleButton.scaleYProperty(), 1.05)
                    )
            );
            hoverAnim.play();
        });

        shuffleButton.setOnMouseExited(e -> {
            Timeline exitAnim = new Timeline(
                    new KeyFrame(Duration.ZERO,
                            new KeyValue(shuffleButton.scaleXProperty(), shuffleButton.getScaleX()),
                            new KeyValue(shuffleButton.scaleYProperty(), shuffleButton.getScaleY())
                    ),
                    new KeyFrame(Duration.millis(200),
                            new KeyValue(shuffleButton.scaleXProperty(), 1),
                            new KeyValue(shuffleButton.scaleYProperty(), 1)
                    )
            );
            exitAnim.play();
        });
    }
}
