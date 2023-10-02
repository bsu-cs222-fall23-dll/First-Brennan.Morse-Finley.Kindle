package edu.bsu.cs222;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;

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
        Scene scene = new Scene(label, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
