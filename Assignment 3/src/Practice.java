import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Practice extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        StackPane root = new StackPane();
        root.setAlignment(Pos.TOP_LEFT);

        ScrollPane scrollPane = new ScrollPane();
        Pane pane = new Pane();
        pane.setMinHeight(1000);
        pane.setMinWidth(1000);
        scrollPane.setContent(pane);

        root.getChildren().add(scrollPane);
        Label fixed = new Label("Fixed");
        root.getChildren().add(fixed);

        // Allow vertical scrolling of fixed element:
        scrollPane.hvalueProperty().addListener( (observable, oldValue, newValue) -> {
            double xTranslate = newValue.doubleValue() * (scrollPane.getViewportBounds().getWidth() - fixed.getWidth());
            fixed.translateXProperty().setValue(-xTranslate);
        });
        // Allow horizontal scrolling of fixed element:
        scrollPane.vvalueProperty().addListener( (observable, oldValue, newValue) -> {
            double yTranslate = newValue.doubleValue() * (scrollPane.getViewportBounds().getHeight() - fixed.getWidth());
            fixed.translateYProperty().setValue(-yTranslate);
        });

        Scene scene = new Scene(root, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}