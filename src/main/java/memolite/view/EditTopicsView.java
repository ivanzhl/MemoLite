package memolite.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class EditTopicsView {

    private final BorderPane root = new BorderPane();
    private final TextField inputField = new TextField();
    private final Button addButton = new Button("+");

    public EditTopicsView() {
        inputField.setPromptText("New topic...");

        HBox inputRow = new HBox(5, inputField, addButton);
        inputRow.setAlignment(Pos.CENTER);
        inputRow.setPadding(new Insets(10));

        ListView<String> list = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList (
                "Single", "Double", "Suite", "Family App");
        list.setItems(items);

        root.setTop(inputRow);
        root.setCenter(list);
    }

    public BorderPane getRoot() { return root; }

    public TextField getInputField() { return inputField; }
    public Button getAddButton() { return addButton; }
}
