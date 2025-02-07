package com.pfg2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import com.pfg2.component.customcombobox.CustomComboBox;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        List<CustomObject> customObjects = IntStream
            .range(1, 10)
            .mapToObj(CustomObject::new)
            .collect(Collectors.toCollection(ArrayList::new));
        StackPane root = new StackPane();
        root.getChildren().add(new CustomComboBox(customObjects));
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}