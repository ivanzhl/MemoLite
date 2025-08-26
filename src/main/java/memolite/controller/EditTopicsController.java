package memolite.controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import memolite.service.TopicsMemoryService;
import memolite.view.EditTopicsView;

public class EditTopicsController {
    private final EditTopicsView view;
    private final TopicsMemoryService service;

    public EditTopicsController(EditTopicsView view) {
        this.view = view;
        this.service = new TopicsMemoryService();

        initHandlers();
        loadTopics();
    }

    private void initHandlers() {
        view.getAddButton().setOnAction(e -> {
            String topic = view.getInputField().getText();
            if (topic != null && !topic.isBlank()) {
                service.addTopic(topic);
                loadTopics();
                view.getInputField().clear();
            }
        });

        view.getList().setCellFactory(lv -> new ListCell<>() {
            private final Label label = new Label();
            private final Button removeButton = new Button("-");
            private final Region spacer = new Region();
            private final HBox hbox = new HBox(label, spacer, removeButton);

            {
                removeButton.setId("removeButton");
                HBox.setHgrow(spacer, Priority.ALWAYS);
                hbox.setSpacing(10);

                removeButton.setOnAction(e -> {
                    String topic = getItem();
                    if (topic != null) {
                        service.removeTopic(topic);
                        loadTopics();
                    }
                });
            }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    label.setText(item);
                    setGraphic(hbox);
                }
            }
        });
    }

    private void loadTopics() {
        view.getItems().setAll(service.getTopics());
    }
}
