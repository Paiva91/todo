package ToDo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TodoListApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        ListView<String> listView = new ListView<>();
        TextField taskInput = new TextField();
        Button addButton = new Button("Adicionar");
        Button removeButton = new Button("Remover");
        
        addButton.setOnAction(e -> {
            String task = taskInput.getText();
            if (!task.isEmpty()) {
                listView.getItems().add(task);
                taskInput.clear();
            }
        });
        
        removeButton.setOnAction(e -> {
            int selectedIdx = listView.getSelectionModel().getSelectedIndex();
            if (selectedIdx != -1) {
                listView.getItems().remove(selectedIdx);
            }
        });
        
        VBox layout = new VBox(10, taskInput, addButton, listView, removeButton);
        Scene scene = new Scene(layout, 300, 400);
        
        primaryStage.setScene(scene);
        primaryStage.setTitle("To-Do List");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
