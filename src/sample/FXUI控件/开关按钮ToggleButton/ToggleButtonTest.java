package sample.FXUI�ؼ�.���ذ�ťToggleButton;

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
 * ToggleButton �ǿ��������һ�� Group ���У�ֻ��һ�� button ���Ա�ѡ��
 * ToggleButton����Labeled�����չ�����������Ϊ��ָ��һ���ı����⡢һ��ͼ�񣬻���ͬʱָ�����ߡ�
 * �����ͨ��Labeled���setText��setGraphic������ΪToggleButtonָ���ı�����ͼ�����ݡ�
 *
 * ToggleButton��ľ���ʵ�ֺ�RadioButton��ǳ����ơ����ǣ���Radio Button��ͬ���ǣ�
 * ��һ�����в�����ͼǿ��ѡ������һ��Toggle Button��
 * Ҳ����˵�����һ��ѡ��״̬��Toggle Button�ͻ��Ϊ��ѡ��״̬�������һ������ѡ��״̬��Radio Button��û����Ӧ��
 *
 * ToggleButton���Node��̳�����setUserData�������԰���Ϊѡ�������һ���ر��ֵ
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

        // ���һ�� ToggleButton �� group
        final ToggleGroup group = new ToggleGroup();

        // ���� group �е� toggleButton, ���� toggleButton �и��Ե� userDate ����ֵ
        group.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                rect.setFill(Color.WHITE);
            } else {
                rect.setFill((Color) group.getSelectedToggle().getUserData());
            }
        });

//        // һ�������κ��ı���ͼ��� ToggleButton
//        ToggleButton tb1 = new ToggleButton();
//        // һ�������ı��� ToggleButton
//        ToggleButton tb2 = new ToggleButton("Press me");
//        // һ�������ı���ͼ��� ToggleButton
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
