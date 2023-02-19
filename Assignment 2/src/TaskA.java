import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Michelle Gamba 
//CS2450 
//Assignment 2 
//14 March 2022

public class TaskA extends Application{

    // Fields
    private TextField billTextField;
    private Label resultLabel;
    private Label tipLabel;
    private Label taxLabel;
    

    public static void main(String[] args)
    {
       // Launch the application.
       launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Set the stage title.
        primaryStage.setTitle("Tip, Tax, Total");

        //Create a Label to display a prompt.
        Label billLabel = new Label("Enter your bill total:");
        
        //Create a TextField for input
        billTextField = new TextField();

        //Create a Button to perform the calculation.
        Button calcButton = new Button("Calculate");

        //Register the event handler.
        calcButton.setOnAction(new CalcButtonHandler());

        //Create an empty Label to display the result.
        resultLabel = new Label();
        tipLabel = new Label();
        taxLabel = new Label();

        //Put the promptLabel and the kiloTextField in an HBox.
        HBox hbox = new HBox(10, billLabel, billTextField);

        //Put the HBox, calcButton, and resultLabel in a VBox.
        VBox vbox = new VBox(10, hbox, calcButton, tipLabel, taxLabel, resultLabel);

        //Set the VBox's alignment to center.
        vbox.setAlignment(Pos.CENTER);

        //Set the VBox's padding to 10 pixels.
        vbox.setPadding(new Insets(10));

        //Create a Scene.
        Scene scene = new Scene(vbox);

        //Add the Scene to the Stage.
        primaryStage.setScene(scene);

        //Show the window.
        primaryStage.show();

    }

    class CalcButtonHandler implements EventHandler<ActionEvent>
    {
       @Override
       public void handle(ActionEvent event)
       {
          // Get the bill
          Float bill = Float.parseFloat(billTextField.getText());
 
          //Get 18% tip and 7% sales tax
          Float tipValue = (bill*18)/100;
          Float taxValue = (bill*7)/100;
          Float result = bill + tipValue + taxValue;


          // Display the results.
          tipLabel.setText("Tip: $"+String.format("%,.2f", tipValue));
          taxLabel.setText("Tax: $"+String.format("%,.2f", taxValue));
          resultLabel.setText("New Total: $"+String.format("%,.2f", result));
       }
    }
}


