package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("StackPane.fxml"));

        //The parent root node which we have in our case is the sample.fxml file. This file contains the Grid Pane
        //layout container node which contains the different buttons which are the children nodes.
        //Also we have 10 10 pixel gap between the rows of the buttons as it is set in fxml file

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 500, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
