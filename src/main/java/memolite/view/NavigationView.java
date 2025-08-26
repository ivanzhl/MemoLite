package memolite.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class NavigationView {
    private final BorderPane root = new BorderPane();

    private final Button mainMenuButton = new Button("Main Menu");
    private final Button editTopicsButton = new Button("Edit Topics");

    private final StackPane contentArea = new StackPane();

    public NavigationView() {
        HBox topBar = new HBox(10, mainMenuButton, editTopicsButton);
        topBar.setAlignment(Pos.CENTER);
        topBar.setPadding(new Insets(10));

        root.setTop(topBar);
        root.setCenter(contentArea);
    }

    public BorderPane getRoot() { return root; }
    public Button getMainMenuButton() { return mainMenuButton; }
    public Button getEditTopicsButton() { return editTopicsButton; }

    public void setContent(Node content) {
        contentArea.getChildren().setAll(content);
    }
}
