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
        HBox centeredButtons = new HBox(10, mainMenuButton, editTopicsButton);
        centeredButtons.setAlignment(Pos.CENTER);

        ToolBar topBar = new ToolBar(centeredButtons);
        topBar.setPrefHeight(50);
        topBar.setStyle("""
            -fx-background-color: linear-gradient(to right, #f8f9fa, #e9ecef);
            -fx-border-color: #dcdcdc;
            -fx-border-width: 0 0 1 0;
        """);

        // Button style
        mainMenuButton.setStyle(buttonStyle());
        editTopicsButton.setStyle(buttonStyle());

        root.setTop(topBar);
        root.setCenter(contentArea);
    }

    private String buttonStyle() {
        return """
            -fx-background-color: transparent;
            -fx-text-fill: #333;
            -fx-font-size: 14px;
            -fx-padding: 6 16;
        """;
    }

    public BorderPane getRoot() { return root; }
    public Button getMainMenuButton() { return mainMenuButton; }
    public Button getEditTopicsButton() { return editTopicsButton; }

    public void setContent(Node content) {
        contentArea.getChildren().setAll(content);
    }
}
