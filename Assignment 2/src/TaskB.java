import java.io.FileInputStream;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

//Michelle Gamba 
//CS2450 
//Assignment 2 
//14 March 2022

public class TaskB extends Application{

    public static void main(String[] args)
    {
       // Launch the application.
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // Set the stage title.
        primaryStage.setTitle("Roll Some Dice!");

        //Define all dice images
        FileInputStream die1 = new FileInputStream("src/Dice/Die1.png");
        FileInputStream die2 = new FileInputStream("src/Dice/Die2.png");
        FileInputStream die3 = new FileInputStream("src/Dice/Die3.png");
        FileInputStream die4 = new FileInputStream("src/Dice/Die4.png");
        FileInputStream die5 = new FileInputStream("src/Dice/Die5.png");
        FileInputStream die6 = new FileInputStream("src/Dice/Die6.png");

        //Create images array that holds all images
        Image images[] = {new Image(die1), new Image(die2),
                          new Image(die3), new Image(die4),
                          new Image(die5), new Image(die6)};

        ImageView firstDie = new ImageView();
        ImageView secondDie = new ImageView();

        //Border pane for centering and setting heights...
        BorderPane borderPane = new BorderPane();

        firstDie.setFitHeight(100);
        firstDie.setFitWidth(100);
        secondDie.setFitHeight(100);
        secondDie.setFitWidth(100);

        //Roll Button
        Button rollDieButton = new Button("Roll");
        rollDieButton.setOnAction(event -> {
            int rand1 = (int)(Math.random()*images.length);
            int rand2 = (int)(Math.random()*images.length);
 
            firstDie.setImage(images[rand1]);
            secondDie.setImage(images[rand2]);
        });

        //Fixing alignments and padding
        borderPane.setLeft(firstDie);
        borderPane.setRight(secondDie);
        borderPane.setBottom(rollDieButton);

        BorderPane.setAlignment(rollDieButton, Pos.CENTER);
        BorderPane.setMargin(firstDie, new Insets(20));
        BorderPane.setMargin(secondDie, new Insets(20));

        borderPane.setPadding(new Insets(20));

        //Create a Scene.
        Scene scene = new Scene(borderPane);

        //Add the Scene to the Stage.
        primaryStage.setScene(scene);

        //Show the window.
        primaryStage.show();


    }

    
}