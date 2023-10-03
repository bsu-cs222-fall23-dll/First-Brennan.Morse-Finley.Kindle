package edu.bsu.cs222;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    public Label resultLabel;

    User userError = new User();
    Redirector redirect = new Redirector();
    ChangeLog changeLog = new ChangeLog();
    ChangeLogFormatter changeLogFormatter = new ChangeLogFormatter();
    RedirectFormatter formatRedirect = new RedirectFormatter();

    public static void main(String[] args) {
        launch(args);
    }
    public String combine(String input) {
        redirect.jsonInfo(input);

        String information = changeLogFormatter.changeLogToString(changeLog.jsonInfo(input));
        String redirectInfo = formatRedirect.redirectFormat(changeLog.jsonInfo(input));
        return information + "\n\n" + redirectInfo;
    }
    @Override
    public void start(Stage primaryStage) {
        try {
            TextField searchField = new TextField();
            searchField.setPromptText("Enter an article: ");
            Button searchButton = new Button("Search");
            resultLabel = new Label();

            HBox hbox = new HBox(10);
            hbox.getChildren().addAll(searchField, searchButton);
            hbox.setAlignment(Pos.TOP_CENTER);

            VBox vbox = new VBox(20);
            vbox.getChildren().addAll(hbox, resultLabel);
            Scene scenes = new Scene(vbox);
            vbox.setAlignment(Pos.CENTER);

            Screen screen = Screen.getPrimary();
            Rectangle2D bounds = screen.getVisualBounds();

            primaryStage.setX(bounds.getMinX());
            primaryStage.setY(bounds.getMinY());
            primaryStage.setWidth(bounds.getWidth());
            primaryStage.setHeight(bounds.getHeight());

            primaryStage.setScene(scenes);
            primaryStage.show();

            searchButton.setOnAction(event -> {
                String userInput = searchField.getText();
                String errorCheck = userError.checkSearch(userInput);

                if (errorCheck.equals("No input!")) {
                    Stage inputError = new Stage();
                    inputError.initModality(Modality.APPLICATION_MODAL);
                    inputError.initStyle(StageStyle.UTILITY);
                    inputError.setTitle("User input error");

                    Label label = new Label("No user input!");
                    Button closeButton = new Button("Close");
                    closeButton.setOnAction(e -> inputError.close());

                    StackPane dialogLayout = new StackPane();
                    VBox LackOfInput = new VBox(20);
                    LackOfInput.getChildren().addAll(label, closeButton);
                    LackOfInput.setAlignment(Pos.CENTER);
                    dialogLayout.getChildren().addAll(LackOfInput);
                    Scene dialogScene = new Scene(dialogLayout, 200, 100);
                    inputError.setScene(dialogScene);

                    inputError.showAndWait();
                } else {
                    String together = combine(userInput);
                    resultLabel.setText("Changelogs for : " + userInput + "\n\n" + together);
                }
            });
        } catch (RuntimeException ioException) {
            //do error stuff
            System.exit(0);
        } catch (Error error) {
            //do error stuff?
            System.exit(0);
        }
    }
}
