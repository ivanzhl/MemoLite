package memolite.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import memolite.service.TopicService;

public class EditTopicsView {

    private final BorderPane root = new BorderPane();
    private final TextField inputField = new TextField();
    private final Button addButton = new Button("+");
    private final ListView<String> list = new ListView<>();
    private final ObservableList<String> items = FXCollections.observableArrayList();

    public EditTopicsView(TopicService service) {
        inputField.setPromptText("New topic...");

        HBox inputRow = new HBox(5, inputField, addButton);
        inputRow.setAlignment(Pos.CENTER);
        inputRow.setPadding(new Insets(10));

        items.setAll(service.getTopics());
        list.setItems(items);

        addButton.setOnAction(e -> {
            String topic = inputField.getText();
            service.addTopic(topic);
            items.setAll(service.getTopics());
            inputField.clear();
        });

        inputField.setOnAction(e -> {
            String topic = inputField.getText();
            service.addTopic(topic);
            items.setAll(service.getTopics());
            inputField.clear();
        });

        list.setCellFactory(lv -> new ListCell<>() {
            private final Label label = new Label();
            private final Button removeButton = new Button("–"); // nicer dash
            private final HBox cellBox = new HBox();

            {
                // Let label expand, center its text
                label.setMaxWidth(Double.MAX_VALUE);
                label.setStyle("-fx-font-size: 14px; -fx-alignment: center;");

                HBox.setHgrow(label, Priority.ALWAYS);
                cellBox.setAlignment(Pos.CENTER_LEFT);
                cellBox.setSpacing(10);
                cellBox.setPadding(new Insets(5, 10, 5, 10));

                // Style remove button to look like plain text
                removeButton.setStyle("""
            -fx-background-color: transparent;
            -fx-text-fill: #cc0000;
            -fx-font-size: 16px;
            -fx-font-weight: bold;
            -fx-cursor: hand;
            -fx-padding: 0;
        """);

                removeButton.setOnAction(e -> {
                    String topic = getItem();
                    if (topic != null) {
                        service.removeTopic(topic);
                        items.setAll(service.getTopics());
                    }
                });

                cellBox.getChildren().addAll(label, removeButton);
            }

            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setGraphic(null);
                } else {
                    label.setText(item);
                    setGraphic(cellBox);
                }
            }
        });

        root.setTop(inputRow);
        root.setCenter(list);
    }

    public BorderPane getRoot() { return root; }
}
