package memolite.view;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;

public class RootLayout {
    private final BorderPane root = new BorderPane();

    private final Button mainMenuButton = new Button("Main Menu");
    private final Button editTopicsButton = new Button("Edit Topics");

    public RootLayout() {
        VBox sidebar = new VBox(10);
        sidebar.setPadding(new Insets(10));
        sidebar.getChildren().addAll(mainMenuButton, editTopicsButton);
        root.setLeft(sidebar);
    }

    public BorderPane getRoot() { return root; }
    public Button getMainMenuButton() { return mainMenuButton; }
    public Button getEditTopicsButton() { return editTopicsButton; }

    public void setContent(Pane content) {
        root.setCenter(content);
    }
}
