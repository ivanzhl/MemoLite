package memolite.view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView {
    private final BorderPane root = new BorderPane();

    private final TextField inputField = new TextField();
    private final Button addButton = new Button("+");
    private final Button shuffleButton = new Button("Shuffle");
    private final Label resultLabel = new Label("No topic selected yet");

    public MainView() {
        inputField.setPromptText("Add a new Topic");
        Platform.runLater(root::requestFocus);

        HBox inputRow = new HBox(5, inputField, addButton);
        inputRow.setFillHeight(true);
        inputRow.setAlignment(Pos.TOP_CENTER);

        VBox box = new VBox(10, inputRow, shuffleButton, resultLabel);
        box.setPadding(new Insets(30));
        box.setAlignment(Pos.TOP_CENTER);

        root.setCenter(box);
    }

    public BorderPane getRoot() { return root; }
    public TextField getInputField() { return inputField; }
    public Button getAddButton() { return addButton; }
    public Button getShuffleButton() { return shuffleButton; }
    public Label getResultLabel() { return resultLabel; }
}
