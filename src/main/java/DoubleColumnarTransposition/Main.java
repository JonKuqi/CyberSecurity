package DoubleColumnarTransposition;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage stage){


      //  Text text = new Text(DoubleColumnarTransposition.encrypt("WeAreDiscoveredFleeAtOnce","ZEBRAS","ZEBRAS"));



        // Create a text input field and a button.
        Text text1 = new Text(100,80,"Double Columnar Transposition Cypher");
        text1.setFont(new Font("TimesRoman",  30));

        Text input = new Text(270, 160,"Plain Text / Cipher Text ");
        input.setFont(Font.font(15));
        TextField inputField = new TextField();
        inputField.setPrefSize(300,40);
        inputField.setTranslateX(200);
        inputField.setTranslateY(170);


        Text keyText = new Text(330, 240,"Key 1 ");
        keyText.setFont(Font.font(15));
        TextField key1 = new TextField();
        key1.setPrefSize(300,40);
        key1.setTranslateX(200);
        key1.setTranslateY(250);

        Text key2Text = new Text(330, 320,"Key 2 ");
        key2Text.setFont(Font.font(15));
        TextField key2 = new TextField();
        key2.setPrefSize(300,40);
        key2.setTranslateX(200);
        key2.setTranslateY(330);




        Button encryptButton = new Button("Encrypt");
        encryptButton.setTranslateX(200);
        encryptButton.setTranslateY(400);
        encryptButton.setPrefSize(140,40);


        Button  decryptButton= new Button("Decrypt");
        decryptButton.setTranslateX(360);
        decryptButton.setTranslateY(400);
        decryptButton.setPrefSize(140,40);



        Text rezultati = new Text(330, 510,"Result ");
        rezultati.setFont(Font.font(15));
        TextField resultLabel = new TextField();
        resultLabel.setPrefSize(300,40);
        resultLabel.setTranslateX(200);
        resultLabel.setTranslateY(520);
        resultLabel.setEditable(false);

        Text copyRight = new Text(10, 690,"Work of: Jon Kuçi");
        copyRight.setFont(Font.font(0));



        // Set an action for the button to display the entered text.
        encryptButton.setOnAction(event -> {
            String plainText = DoubleColumnarTransposition.encrypt(inputField.getText(),key1.getText(),key2.getText());
            resultLabel.setText(plainText);
        });

        decryptButton.setOnAction(event -> {
            String cipherText = DoubleColumnarTransposition.decrypt(inputField.getText(),key1.getText(),key2.getText());
            resultLabel.setText(cipherText);
        });


        Pane pane = new Pane();

        // Create a layout for the input field, button, and result label.
        VBox pane1 = new VBox();


        pane.setMaxHeight(500);
        pane.setMaxWidth(500);

        pane.getChildren().addAll(text1,inputField, encryptButton, decryptButton, resultLabel,input,keyText,key1,key2Text,key2,rezultati,copyRight);

        Scene scene = new Scene(pane,700,700);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setTitle("Double Columnar Transposition");

    }

}
