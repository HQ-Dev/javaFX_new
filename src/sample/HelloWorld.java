package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author Archy
 * @date
 * # JavaFX 应用需要继承自 javafx.application.Application.class
 * # JavaFX 应用通过 stage 和 scene 来定义用户界面容器。 JavaFX Stage 是最顶层的 JavaFX 容器。JavaFX Scene 是所有内容的容器。
 * # 在 JavaFX 应用中，the content 表示节点的分层场景图。在此案例中，root node 是一个 StackPane 对象，它是一个可伸缩的布局节点。这意味着，它的大小可以随用户调整后的 scene (场景)的大小而改变大小。
 * # root node 根节点有一个子节点，一个 button 按钮（有字体）,增加了事件监听
 * # 当使用 javafx 包装器工具创建应用程序的 jar 文件时, javafx 应用程序不需要 main () 方法, 它将 javafx 启动器嵌入到 jar 文件中。
 *
 **/
public class HelloWorld extends Application {

    // start 方法是 JavaFX 程序的入口，在 init 方法返回以及系统准备好让应用运行后才会调用。 Note: 这个方法在 JavaFX Application 线程中被调用
    @Override
    public void start(Stage primaryStage) throws Exception {
        /**
         * Stage 是 JavaFX 最顶层的容器。the primary stage 是被平台构建的。后续的 Stage 对象可以被应用所创建.它的很多属性是只读的。
         * Owner:
         * Modality:
         * 有 NONE, WINDOW_MODAL, APPLICATION_MODAL
         */
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

        // 样式必须需在显示之前设置
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
