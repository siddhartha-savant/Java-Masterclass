package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class Main extends Application { //This will be the entry point for the application. The Application class
                                        //manages the lifecycle of a JavaFX application

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        //This loads the UI from the fxml file. As per the fxml file, the only node that we have is the
        //GridPane. Therefore, the GridPane node will be the root of the scene graph and that was returned from
        //the FXMLLoader load call.

//        GridPane root = new GridPane();
//        root.setAlignment(Pos.CENTER);
//        root.setVgap(10);
//        root.setHgap(10);
//
//        Label greetings = new Label("Welcome to JavaFX!");
//        greetings.setTextFill(Color.GREEN);
//        greetings.setFont(Font.font("Comic Sans", FontWeight.BOLD,70));
//        root.getChildren().add(greetings);

        primaryStage.setTitle("Hello JavaFX!");
        primaryStage.setScene(new Scene(root, 700, 275));

        //When we construct Scene, we have to pass in the root of the scene graph that will back the scene

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
