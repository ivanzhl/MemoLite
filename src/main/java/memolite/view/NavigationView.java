package memolite.view;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.*;

public class NavigationView {
    private final BorderPane root = new BorderPane();

    private final Button mainMenuButton = new Button("Shuffle Topics");
    private final Button editTopicsButton = new Button("Edit Topics");
    private final StackPane contentArea = new StackPane();

    public NavigationView() {
        final HBox centeredButtons = new HBox(10, mainMenuButton, editTopicsButton);
        final ToolBar topBar = new ToolBar(centeredButtons);

        centeredButtons.setAlignment(Pos.CENTER);
        topBar.setPrefHeight(50);
        topBar.setId("topBar");

        mainMenuButton.setId("topBarButtons");
        editTopicsButton.setId("topBarButtons");

        root.setTop(topBar);
        root.setCenter(contentArea);
    }

    public BorderPane getRoot() {
        return root;
    }

    public Button getMainMenuButton() {
        return mainMenuButton;
    }

    public Button getEditTopicsButton() {
        return editTopicsButton;
    }

    public void setContent(Node content) {
        contentArea.getChildren().setAll(content);
    }
}
