package com.company.todolist;

import datamodel.TodoData;
import datamodel.TodoItem;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Controller {
    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;      //We'll get an error in fxml if this is not public or @FXML
                                                //After I mention the item which is going to be used in ListView we
                                                //no need to cast it like we did in handleClickListView method
    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLabel;

    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private ContextMenu listContextMenu;

    @FXML
    private ToggleButton filterToggleButton;
    
    private FilteredList<TodoItem> filteredList;
    //Because we want to use this filteredList in the event handler we need to declare it as an instance variable.
    //This list is further passed to the sortedList

    private Predicate<TodoItem> wantAllItems;
    private Predicate<TodoItem> wantTodaysItems;

    public void initialize(){

        //This below code for the Context Menu and add the delete button to it. We create an anonymous
        // class (Event Handler) and override the handle method. One thing to note is that we haven't
        //associated the menu with the ListView. Since this is a context menu, meaning that it is going to
        //appear when the user right clicks on a particular item or cell, it makes sense to associate the
        //menu in our cell factory. Also thus, we only want non empty cells to have context menu in our case
        //Also notice that we haven't added any code to remove item from the ListView. This is because we are
        //using data binding (line 103) and the list view noticed that the item was deleted from the collection
        //automatically

        listContextMenu = new ContextMenu();
        MenuItem deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });
        listContextMenu.getItems().addAll(deleteMenuItem);

        //This is all just place hold sample data. We'll let the UI input the data by the users. This is
        //purely here for testing purposes
//        TodoItem item1 = new TodoItem("Mail Birthday Card","Buy a 30th birthday card for John",
//                LocalDate.of(2020,7,28));
//        TodoItem item2 = new TodoItem("Doctor's Appointment","See Dr. Smith at Main Street. Bring paperwork",
//                LocalDate.of(2020,8,14));
//        TodoItem item3 = new TodoItem("Finish design proposal for client","Promised Mike I'll email mockups by Friday 22nd April",
//                LocalDate.of(2020, Month.APRIL,22));
//        TodoItem item4 = new TodoItem("Pickup Doug at train station","Doug is arriving on March 23 on the 5:00 train",
//                LocalDate.of(2020,Month.JUNE,28));
//        TodoItem item5 = new TodoItem("Pickup dry cleaning","Clothes should be ready by 31st",
//                LocalDate.of(2020,Month.JULY,31));
//
//        todoItems = new ArrayList<>();
//        todoItems.add(item1);
//        todoItems.add(item2);
//        todoItems.add(item3);
//        todoItems.add(item4);
//        todoItems.add(item5);
//
//        TodoData.getInstance().setTodoItems(todoItems);  //This line is just so that the data is arraylist is
                                                            //copied from the controller to the TodoItem. Check
                                                            //the storeTodoItems() method in TodoData

        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem oldValue, TodoItem newValue) {
                if(newValue!=null){
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });
        wantAllItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem item) {
                return true; //return true is actually doing nothing but passing all the items through the filter
            }
        };

        wantTodaysItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem item) {
                return (item.getDeadline().equals(LocalDate.now()));
            }
        };

        filteredList = new FilteredList<>(TodoData.getInstance().getTodoItems(),wantAllItems);

        SortedList<TodoItem> sortedList = new SortedList<TodoItem>(filteredList,   //the filtered list is used as parameter
                new Comparator<TodoItem>() {
                    @Override
                    public int compare(TodoItem o1, TodoItem o2) {
                        return o1.getDeadline().compareTo(o2.getDeadline());
                    }
                });
        //The above code is used to sort the TodoItems according to the deadlines. For that we are still
        //going to use the ObservableArrayList for the TodoItems, but instead of using it to populate the
        //ListView directly (given on line 119), we will first wrap it in a sorted list instance and then
        //use the sorted list itself to populate the ListView.

      //  todoListView.getItems().setAll(todoItems);  //This was for earlier when the todoItems were hardcoded in the controller itself

      //  todoListView.getItems().setAll(TodoData.getInstance().getTodoItems()); 2nd time - This explicitly adds the item. Instead of
                                                                                //using the getItems() we instead use below statement
      //  todoListView.setItems(TodoData.getInstance().getTodoItems()); //This is all we need to data bind the observable list in the todoData class
                                                                        //to the ListView
        todoListView.setItems(sortedList);

        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);

        todoListView.getSelectionModel().selectFirst();
        //This will select the first as the default. However, we are not getting its details selected.
        //This is because details are selected by the event handler onMouseClicked. But over here we are selecting
        //the default pragmatically. So there are two ways. We could just directly set the text area here itself
        //by passing in the details of the first item. Or we could change the event handler from onMouseClicked
        //property to an event handler when the selected item property of the selection model changes.
        //For that we have to set our event handler in code rather than in the fxml. And we have to do that before
        //it selects the first item.
        //Our Event handler will be an instance of the Change Listener class. For that we have used an anonymous
        //class and we are overriding the change method.
        //When running a code that creates and sets event listeners, its very common to use lambda expressions
        //But as we don't know lambda expressions yet, we'll write one ourselves.

        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> param) {
                ListCell<TodoItem> cell = new ListCell<>(){
                    @Override
                    protected void updateItem(TodoItem item, boolean empty) {
                        super.updateItem(item, empty); //We won't remove this, because we want default appearance provided by the parent class
                        if(empty){                      //(i.e. the grey and white alternate shading of the ListView)
                            setText(null);
                        }else{
                            setText(item.getShortDescription());
                            if(item.getDeadline().isBefore(LocalDate.now().plusDays(1))){
                                setTextFill(Color.RED);
                            }else if(item.getDeadline().equals(LocalDate.now().plusDays(1))){
                                setTextFill(Color.DARKBLUE);
                            }
                        }
                    }
                };
                cell.emptyProperty().addListener(//We have added a listener to the cell empty property
                        (obs, wasEmpty, isNowEmpty) -> {  //This is an anonymous method also called as the lambda expression
                            if(isNowEmpty){
                                cell.setContextMenu(null);  //for empty cells we will set context menu as null
                            }else{
                                cell.setContextMenu(listContextMenu);
                            }
                        }
                );

                return cell;
            }
        });
    }

    //We are passing an anonymous class that implements the callback interface. The 1st parameter is the type
    //of argument provided by the call method and that's a single method within the interface. In our case we
    //are passing it ListView controller and the 2nd parameter is the type that is going to be returned from
    //the call method. In our case, instance of the class ListCell is going to be returned (return cell;)
    //We also created another anonymous class to create our list cell instances. The updateItem method is
    //going to run whenever the ListView wants to paint a single cell. So our callback method is going to
    //return the cell instance that we created and the ListView will use that instance to paint the cell.
    //As a result, this allows us to paint every cell based on the todoItem that it contained
    //This is basically cell factories of the ListView layout
    @FXML
    public void showNewItemDialog(){
        //This is when the user click File-->New. The event when the Ok or Cancel button is pressed must be
        //handled in Controller class and not in the DialogController class. The whole class is written so as
        //to load and assign the dialog pane

        Dialog<ButtonType> dialog = new Dialog<>();
        //We create an instance of the dialog class. Also we need the dialog to be modul. That means it
        //is not possible for the user to interact with other applications UI when this dialog is on screen
        //By default the dialog class is modul. As the loading and assigning part for the main window was done
        //in Main.java, similarly the dialog panes loading and assigning is done here and not in the
        //DialogController class

        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add new Todo Item");
        dialog.setHeaderText("Use this dialog to create a new todo Item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));

        //The reason for creating an instance of the FXML loader class is written in the notebook. It is
        //basically we can't create instance of the Dialog controls in this Controller class, but we somehow need
        //a way to get the dialogController (where we'll create the instances of the Dialog controls as that is
        //the fx:controller mentioned in the todoItemDialog.fxml file) to process the data when the user presses
        //the OK button (which is assigned over here). Thus we won't be needing the parent root anymore
        try{
          //  Parent root = FXMLLoader.load(getClass().getResource("todoItemDialog.fxml"));
            dialog.getDialogPane().setContent(fxmlLoader.load());
          // We can now get our DialogController from the FXML Loader instances from the above statement

        }catch (IOException e){
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }
        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if(result.isPresent() && result.get() == ButtonType.OK){
            DialogController controller = fxmlLoader.getController();
            TodoItem newItem = controller.processResult();
         //   todoListView.getItems().setAll(TodoData.getInstance().getTodoItems()); //This line will update the list spontaneously
         // We don't need this line now as we have data bind the observable list from the todoData class to the ListView
         // As a result, no need to explicitly mention this line as when there is a change, automatically the change is reflected

            todoListView.getSelectionModel().select(newItem);  //This will select the newly added item
        }
    }

    //The below code is for KeyEvent when we press the delete button on the keyboard
    @FXML
    public void handleKeyPressed(KeyEvent keyEvent){
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if(selectedItem != null){
            if(keyEvent.getCode().equals(KeyCode.DELETE)){
                deleteItem(selectedItem);
            }
        }
    }

    @FXML
    public void handleClickListView(){
        //TodoItem item = (TodoItem) todoListView.getSelectionModel().getSelectedItem();

        //If we remove this casting we will get an error. The reason that's coming up because we didn't specify
        //the type (generic of list view) when we declared our list view

        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
        //System.out.println("The selected item is " + item);
//        StringBuilder sb = new StringBuilder(item.getDetails());
//        sb.append("\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline().toString());
//        itemDetailsTextArea.setText(sb.toString());
        //We are using StringBuilder as we want to append not just the .getDetails but also the .getDeadline
    }

    public void deleteItem(TodoItem item){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);  //In built Java class for alerting the user before an action
        alert.setTitle("Delete Todo Item");
        alert.setHeaderText("Delete item : " + item.getShortDescription());
        alert.setContentText("Are you sure ? Press OK to confirm, or Cancel to back");
        //No need to set buttons, the Alert class does that automatically
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK){
            TodoData.getInstance().deleteTodoItem(item);
        }
    }

    //What we want to do with the filter (toggleButton in fxml) is show only the items that are due for today
    //when the toggle button is selected
    @FXML
    public void handleFilterButton(){
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if(filterToggleButton.isSelected()){
            filteredList.setPredicate(wantTodaysItems);
            if(filteredList.isEmpty()){
                itemDetailsTextArea.clear();
                deadlineLabel.setText("");
            }else if(filteredList.contains(selectedItem)){
                todoListView.getSelectionModel().select(selectedItem);
            }else {
                todoListView.getSelectionModel().selectFirst();
            }
        }else{
            filteredList.setPredicate(wantAllItems);
            todoListView.getSelectionModel().select(selectedItem);
        }//The filtering is working fine, However as you can see we are creating the predicate each time.
    }    //So instead we can just create a field of Predicate in this class

    @FXML
    public void handleExit(){
        Platform.exit();
    }
}
