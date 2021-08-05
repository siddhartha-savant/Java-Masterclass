package com.company.todolist;

import datamodel.TodoData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
        primaryStage.setTitle("Todo List");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        try{
            TodoData.getInstance().storeTodoItems();   //Also note we are not specifying the directory of the file
        }catch(IOException e){                          //it just stores it in the root folder of the project
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init() throws Exception {      //This is the method that runs first. So when we want to load
        try{                                    //the previous data, the load method must be called over here
            TodoData.getInstance().loadTodoItems();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}

//The stop method of the Application class would be a logical place to store our data. (i.e. when the application
//is closed, the data that was inputted will be saved for further reference and won't be lost).
//However, the controller will need the data to populate the ListView, and it already has ready access to the
//ListViews contents when we want to store them.

//For this, we will add a singleton class (TodoData) that both our main class and controller can access
//where only 1 instance of the class is created for the entire run of the application.
//This is not the right way to do it. However, for the sake of achieving this functionality we are doing it.
//We would more likely don't do this. Instead we would store the items in XML format or perhaps even use
// the database
