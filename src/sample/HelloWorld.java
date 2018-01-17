package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * @author Archy
 * @date
 **/
public class HelloWorld extends Application {

    // start 方法是 JavaFX 程序的入口，在 init 方法返回以及系统准备好让应用运行后才会调用。 Note: 这个方法在 JavaFX Application 线程中被调用
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Stage 是 JavaFX 最顶层的
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        // 给按钮增加事件监听
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        Scene scene = new Scene(root, 300,250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
