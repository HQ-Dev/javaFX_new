package sample.FXUI控件.开关按钮ToggleButton;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


/**
 * @author Archy
 * @date Created at 2018/6/7
 *
 * ToggleButton 是可以组合在一个 Group 当中，只有一个 button 可以被选中
 * ToggleButton类是Labeled类的扩展，所以你可以为其指定一个文本标题、一个图像，或者同时指定二者。
 * 你可以通过Labeled类的setText和setGraphic方法来为ToggleButton指定文本或者图像内容。
 *
 * ToggleButton类的具体实现和RadioButton类非常相似。但是，和Radio Button不同的是，
 * 在一个组中并不试图强制选中至少一个Toggle Button。
 * 也就是说，点击一个选中状态的Toggle Button就会变为非选中状态，而点击一个组中选中状态的Radio Button则没有响应。
 *
 * ToggleButton类从Node类继承来的setUserData方法可以帮你为选中项关联一个特别的值
 **/
public class ToggleButtonTest extends Application{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Toggle Button Sample");
        primaryStage.setWidth(250);
        primaryStage.setHeight(180);

        HBox hBox = new HBox();
        VBox vBox = new VBox();

        Scene scene = new Scene(new Group(vBox));
        primaryStage.setScene(scene);
//        scene.getStylesheets().add("");

        Rectangle rect = new Rectangle();
        rect.setHeight(50);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.DARKGRAY);
        rect.setStrokeWidth(2);
        rect.setArcHeight(10);
        rect.setArcWidth(10);

        // 存放一组 ToggleButton 的 group
        final ToggleGroup group = new ToggleGroup();

        // 监听 group 中的 toggleButton, 根据 toggleButton 中各自的 userDate 来赋值
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                rect.setFill(Color.WHITE);
            } else {
                rect.setFill((Color) group.getSelectedToggle().getUserData());
            }
        });

//        // 一个不带任何文本和图标的 ToggleButton
//        ToggleButton tb1 = new ToggleButton();
//        // 一个带有文本的 ToggleButton
//        ToggleButton tb2 = new ToggleButton("Press me");
//        // 一个带有文本和图标的 ToggleButton
//        Image image = new Image(getClass().getResourceAsStream("/resources/images/logout.png"));
//        ToggleButton tb3 = new ToggleButton("Press me", new ImageView(image));

        ToggleButton tb1 = new ToggleButton("Minor");
        tb1.setToggleGroup(group);
        tb1.setUserData(Color.LIGHTGREEN);
        tb1.setSelected(true);
//        tb1.getStyleClass().add("toggle-button1");

        ToggleButton tb2 = new ToggleButton("Major");
        tb2.setToggleGroup(group);
        tb2.setUserData(Color.LIGHTBLUE);
        tb2.getStyleClass().add("toggle-button2");

        ToggleButton tb3 = new ToggleButton("Critical");
        tb3.setToggleGroup(group);
        tb3.setUserData(Color.SALMON);
        tb3.getStyleClass().add("toggle-button3");


        hBox.getChildren().addAll(tb1,tb2,tb3);

        vBox.getChildren().add(new Label("Priority:"));
        vBox.getChildren().add(hBox);
        vBox.getChildren().add(rect);
        vBox.setPadding(new Insets(20,10,10,20));

        primaryStage.show();
        rect.setWidth(hBox.getWidth());


    }
}
