package sons.mamoun;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    int x ,y , width , height , gab;
    final private String Fxml = "sons/mamoun/sample.fxml";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage myStage = new Stage();
        x =200 ; y =50 ; width = 600 ; height = 475 ; gab= 50;


        VBox pane =  FXMLLoader.load(getClass().getResource("myfxml.fxml")) ;
        VBox pane2 = FXMLLoader.load(getClass().getResource("myfxml.fxml")) ;


        primaryStage.setTitle("Player 1");
        Scene primaryScene =new Scene(pane, width, height);
        primaryStage.setX(x); primaryStage.setY(x);
        primaryStage.setScene(primaryScene);
        primaryStage.show();

        myStage.setTitle("Player 2");
        Scene scene = new Scene(pane2,600, 475);
        myStage.setX(x+gab+width); myStage.setY(x);
        myStage.setScene(scene);
        myStage.show();


    }





}
