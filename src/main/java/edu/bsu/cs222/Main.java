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
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){
        String output;

        User input = new User();
        Redirector redirect = new Redirector();
        ChangeLog changeLog = new ChangeLog();
        ChangeLogFormatter changeLogFormatter = new ChangeLogFormatter();
        RedirectFormatter formatRedirect = new RedirectFormatter();

        output = input.getSearch();
        String format = output;
        redirect.jsonInfo(format);

        String information = changeLogFormatter.changeLogToString(changeLog.jsonInfo(format));
        String redirectInfo = formatRedirect.redirectFormat(changeLog.jsonInfo(format));
        String together = information + " " + redirectInfo;

        Label label = new Label(together);
        Scene scene = new Scene(label);
        Label resultLabel = new Label();



        TextField searchField = new TextField();
        searchField.setPromptText("What Wikipedia article are you looking for?: ");
        Button searchButton = new Button("Search");

        searchButton.setOnAction(event -> {
            String userInput = searchField.getText();

            resultLabel.setText("Search results for: " + userInput + "\n" + together);
        });

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
