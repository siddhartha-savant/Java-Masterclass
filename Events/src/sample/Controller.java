package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label ourLabel;

    public void initialize(){
        helloButton.setDisable(true);
        byeButton.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent e){
      if(e.getSource().equals(helloButton)){
          System.out.println("Hello, " + nameField.getText());
      }else if(e.getSource().equals(byeButton)){
          System.out.println("Bye " + nameField.getText());
      }
      Runnable task = new Runnable() {
          @Override
          public void run() {
              try{
                  String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                  System.out.println("I'm going to sleep on this " + s);
                  Thread.sleep(10000);    //Here we are putting the thread to sleep. Note: After putting this
                  Platform.runLater(new Runnable() {//in run method we are putting the background thread to sleep
                      @Override                     //and not the UI thread
                      public void run() {
                          String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                          System.out.println("I'm updating the label on the " + s);
                          ourLabel.setText("We did something!");
                      }
                  });
              }catch (InterruptedException event){
                  //We don't care about this
              }
          }
      };

      new Thread(task).start();

      if(ourCheckBox.isSelected()){
          nameField.clear();
          helloButton.setDisable(true);
          byeButton.setDisable(true);
      }
    }
    @FXML
    public void handleKeyRelease(){
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        //The text.trim() basically ignores the white spaces i.e. when we just have spaces pressed in the text.
        //We are checking this to make sure that the text is empty so as to disable the helloButton and the byeButton
       //However, initially when the application first runs we also need to disable the buttons for that the initialize
        //method is written
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }
    public void handleChange(){
        System.out.println("The Checkbox is " + (ourCheckBox.isSelected() ? "checked" : "not checked"));
    }
}
