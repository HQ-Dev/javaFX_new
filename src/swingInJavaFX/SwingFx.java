package swingInJavaFX;

import javafx.application.Application;
import javafx.embed.swing.SwingNode;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * @author Archy
 * @date Created at 2018/5/5
 **/
public class SwingFx extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        final SwingNode swingNode = new SwingNode();
        createSwingNodeContent(swingNode);

        StackPane stackPane = new StackPane();
        stackPane.getChildren().add(swingNode);

        primaryStage.setTitle("Swing in JavaFX");
        primaryStage.setScene(new Scene(stackPane, 300, 350));
        primaryStage.show();
    }

    private void createSwingNodeContent(final SwingNode swingNode) {
        SwingUtilities.invokeLater(() -> {
            swingNode.setContent(new JButton("swing button: click me!"));
        });
    }
}
