package memolite.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class EditTopicsView {
    private final BorderPane root = new BorderPane();
    private final TextField inputField = new TextField();
    private final Button addButton = new Button("+");
    private final ListView<String> list = new ListView<>();
    private final ObservableList<String> items = FXCollections.observableArrayList();

    public EditTopicsView() {
        final HBox inputRow = new HBox(5, inputField, addButton);

        inputField.setPromptText("New topic...");
        inputRow.setAlignment(Pos.CENTER);
        inputRow.setPadding(new Insets(10));
        list.setItems(items);
        root.setTop(inputRow);
        root.setCenter(list);
    }

    public BorderPane getRoot() {
        return root;
    }

    public Button getAddButton() {
        return addButton;
    }

    public TextField getInputField() {
        return inputField;
    }

    public ListView<String> getList() {
        return list;
    }

    public ObservableList<String> getItems() {
        return items;
    }
}
