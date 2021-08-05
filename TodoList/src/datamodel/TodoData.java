package datamodel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class TodoData {
    private static TodoData instance = new TodoData();
    private static String filename = "TodoItems.txt";
    private ObservableList<TodoItem> todoItems;  //This is changed from just List<TodoItem> to ObservableList<..> for data binding
    private DateTimeFormatter formatter; //So that we can manipulate the date

    public static TodoData getInstance(){
        return instance;
    }

    private TodoData(){
        formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void addTodoItem(TodoItem item){
        todoItems.add(item);
    }

    public void setTodoItems(ObservableList<TodoItem> todoItems) {  //This is temporary. We only need it when we run the
        this.todoItems = todoItems;                 //application then close it to save the hard coded items
    }

    public void loadTodoItems() throws IOException{

        todoItems= FXCollections.observableArrayList();
        Path path = Paths.get(filename);    //This will save the path to the file. It is a way to access data
        BufferedReader br = Files.newBufferedReader(path);  //It is creating newBufferedReader for the path
                                                    // pointing to the location where the file is

        String input;                       //This will contain the data for each line

        try {
            while ((input = br.readLine()) != null){
                String[] itemPieces = input.split("\t");

                String shortDescription = itemPieces[0];
                String details = itemPieces[1];
                String dateString = itemPieces[2];

                LocalDate date = LocalDate.parse(dateString,formatter);
                //Converting the date to a format that we can read
                TodoItem todoItem = new TodoItem(shortDescription,details,date);
                todoItems.add(todoItem);
            }

        }finally {
            if(br!=null){       //This makes sure that we have a valid object before we try to close it
                br.close();
            }
        }
    }

    public void storeTodoItems() throws IOException{

        Path path = Paths.get(filename);        //The path where we will save the file
        BufferedWriter bw = Files.newBufferedWriter(path);
        try {
            Iterator<TodoItem> iter = todoItems.iterator();
            while(iter.hasNext()){
                TodoItem item = iter.next();
                bw.write(String.format("%s\t%s\t%s",
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadline().format(formatter)));
                bw.newLine();
            }

        }finally {
            if(bw != null){  //Testing to make sure we have an valid object before closing it
                bw.close();
            }
        }

    }

    public void deleteTodoItem(TodoItem item){
        todoItems.remove(item);
    }

}

