import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HelloFX extends Application{

    public void startApp(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Croissant alpha 0.0.1");
//        Button btn = new Button();
//        btn.setText("Say 'Hello World'");
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World!");
//            }
//        });


/*
        ObservableList<String> langs = FXCollections.observableArrayList("Java", "JavaScript", "C#", "Python");
        ListView<String> test = new ListView(langs);
        test.setPrefSize(150,150);
*/
        TabPane pane = new TabPane();
        Tab tab1 = new Tab("Settings",new Label("Settings"));

        pane.getTabs().add(tab1);

        FlowPane root = new FlowPane();
        //root.getChildren().add(btn);
        //root.getChildren().add(test);
        primaryStage.setScene(new Scene(pane, 1200, 800));
        primaryStage.show();
    }

}
