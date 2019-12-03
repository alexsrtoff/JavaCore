package Lesson_6.Chat.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Chat");
        primaryStage.getIcons().add(new Image("Lesson_6/Chat/client/resourses/icon.png"));
        primaryStage.setScene(new Scene(root, 350, 375));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
