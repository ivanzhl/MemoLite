package memolite.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class MainView {
    private final BorderPane root = new BorderPane();

    private final Button shuffleButton = new Button("Shuffle");
    private final Label resultLabel = new Label("");

    public MainView() {

        shuffleButton.setStyle("-fx-font-size: 18px; -fx-padding: 10 20;");
        resultLabel.setStyle("-fx-font-size: 40px;");

        VBox box = new VBox(10, shuffleButton, resultLabel);
        box.setAlignment(Pos.CENTER);

        StackPane centerPane = new StackPane(box);
        centerPane.setAlignment(Pos.CENTER);
        StackPane.setMargin(box, new Insets(0, 0, 50, 0));

        root.setCenter(centerPane);
    }

    public BorderPane getRoot() { return root; }
    public Button getShuffleButton() { return shuffleButton; }
    public Label getResultLabel() { return resultLabel; }
}
