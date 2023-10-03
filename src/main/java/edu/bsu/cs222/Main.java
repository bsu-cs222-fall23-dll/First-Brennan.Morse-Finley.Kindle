package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application{
    public Label resultLabel;

    User userError = new User();
    Redirector redirect = new Redirector();
    ChangeLog changeLog = new ChangeLog();
    ChangeLogFormatter changeLogFormatter = new ChangeLogFormatter();
    RedirectFormatter formatRedirect = new RedirectFormatter();

    public static void main(String[] args){
        launch(args);
    }

    public String combine(String input){
        redirect.jsonInfo(input);

        String information = changeLogFormatter.changeLogToString(changeLog.jsonInfo(input));
        String redirectInfo = formatRedirect.redirectFormat(changeLog.jsonInfo(input));
        String together = information + " " + redirectInfo;

        return together;
    }

    @Override
    public void start(Stage primaryStage){

        TextField searchField = new TextField();
        searchField.setPromptText("What Wikipedia article are you looking for?: ");
        Button searchButton = new Button("Search");

        searchButton.setOnAction(event -> {
            String userInput = searchField.getText();
            String errorCheck = userError.getSearch(userInput);

            if (errorCheck == "No input!") {
                resultLabel.setText("Search results for: " + userInput + "\n" + errorCheck);
            } else {
                String together = combine(userInput);
                resultLabel.setText("Search results for: " + userInput + "\n" + together);
            }




        });

        resultLabel = new Label();

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(searchField, searchButton, resultLabel);

        Scene scenes = new Scene(vbox);



        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        primaryStage.setScene(scenes);
        primaryStage.show();
    }
}
