import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.io.FileInputStream;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class FinalExam extends Application{
    public static void main(String[] args)
    {
       // Launch the application.
       launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        // Set the stage title.
        primaryStage.setTitle("Final Exam");

        //Define Labels
        //Label l1 = new Label("USA");
        //Label l2 = new Label("Canada");
        //Label l3 = new Label("Mexico");

        Label selectedCountry = new Label("You have not selected a country yet");
        Label selectedLanguage = new Label("You have not selected a language yet");

        //Define all Radio Button options
        RadioButton r1 = new RadioButton("USA");
        RadioButton r2 = new RadioButton("CANADA");
        RadioButton r3 = new RadioButton("Mexico");

        //Define ToggleGroup
        ToggleGroup tg = new ToggleGroup();

        //Defining Drop Down options
        String options[]={"English", "French", "Spanish"};

        //Creating ComboBox
        ComboBox combo_box = new ComboBox(FXCollections.observableArrayList(options));

        //Border pane for centering and organizaiton...
        GridPane gridPane = new GridPane();

        //add radiobuttons to tg
        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);
        r3.setToggleGroup(tg);


        //Adding labels to left
        //gridPane.add(l1, 0, 0);
        //gridPane.add(l2, 0, 1);
        //gridPane.add(l3, 0, 2);
        gridPane.add(selectedCountry, 0, 3);
        gridPane.add(selectedLanguage, 0, 4);

        //Adding Radio Button next to labels
        gridPane.add(r1, 0, 0);
        gridPane.add(r2, 0, 1);
        gridPane.add(r3, 0, 2);

        //Adding Combo box to the right
        gridPane.add(combo_box, 4, 0);

        //adding listener for country toggles
        tg.selectedToggleProperty().addListener(new ChangeListener<Toggle>() 
        {
            public void changed(ObservableValue<? extends Toggle> ob, Toggle o, Toggle n)
            {
                RadioButton rb = (RadioButton)tg.getSelectedToggle();
  
                if (rb != null) {
                    String s = rb.getText();
  
                    // change the label
                    selectedCountry.setText("Selected Country: "+ s);
                }
            }
        });

        //adding listener for language combo box

        combo_box.setOnAction(e -> selectedLanguage.setText("Selected Language: "+combo_box.getValue()));


        //Create a Scene.
        Scene scene = new Scene(gridPane, 300, 100);

        //Add the Scene to the Stage.
        primaryStage.setScene(scene);

        //Show the window.
        primaryStage.show();


    }
}
