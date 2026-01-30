package edu.aau;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{
//    @override

    public void start(Stage stage) {
        Label label = new Label("Airline Ticket System is Running!");
        Scene scene = new Scene(new StackPane(label), 600, 400);

        stage.setTitle("Airline Ticket System");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        System.out.println("random print statement");
    }
}