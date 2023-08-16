package com.codedotorg;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HonestHeadlines {

    /** The main window to display the app */
    private Stage window;

    /** The width of the scene in the app */
    private int width;

    /** The height of the scene in the app */
    private int height;

    /** The text box that displays the results */
    private TextArea results;

    /** The list of words that could indicate a fake news headline */
    private ArrayList<String> sensationalWords;

    /** The text box for the user to enter their response */
    private TextField inputField;

    /**
     * Creates a new instance of HonestHeadlines with the given parameters.
     * 
     * @param window the Stage object representing the window of the application
     * @param width the width of the window
     * @param height the height of the window
     */
    public HonestHeadlines(Stage window, int width, int height) {
        this.window = window;
        this.width = width;
        this.height = height;

        results = new TextArea();
        results.setWrapText(true);

        sensationalWords = createWordsList();
        
        inputField = createInputField();
    }
    
    /**
     * Sets the title of the window to "Honest Headlines", creates the main scene and
     * adds the stylesheet to it, sets the main scene to the window and shows the window.
     */
    public void startApp() {
        window.setTitle("Honest Headlines");

        Scene mainScene = createMainScene();
        mainScene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());

        window.setScene(mainScene);
        window.show();
    }

    /**
     * Creates the main scene for the Honest Headlines application.
     * 
     * @return the main scene
     */
    public Scene createMainScene() {
        Label titleLabel = new Label("Honest Headlines");
        titleLabel.setId("titleLabel");

        HBox inputLayout = createInputLayout();

        VBox mainLayout = new VBox(20);
        mainLayout.getChildren().addAll(titleLabel, results, inputLayout);

        Scene mainScene = new Scene(mainLayout, width, height);

        return mainScene;
    }

    /**
     * Creates an HBox layout that contains a Label and an input field for entering a headline.
     * 
     * @return the HBox layout containing the Label and input field
     */
    public HBox createInputLayout() {
        Label inputLabel = new Label("Enter headline:");
        inputLabel.setPadding(new Insets(0, 10, 0, 0));

        HBox tempLayout = new HBox();
        tempLayout.getChildren().addAll(inputLabel, inputField);
        tempLayout.setAlignment(Pos.CENTER);

        return tempLayout;
    }

    /**
     * Classifies a given headline as "Fake!" or "Real!".
     * It first converts the input headline to lowercase.
     * Then it checks if the headline contains any sensational words.
     * If it does, the headline is classified as "Fake!".
     * If it doesn't, the headline is classified as "Real!".
     *
     * @param input The headline to be classified.
     * @return "Fake!" if the headline contains any sensational words, "Real!" otherwise.
     */
    public String classifyHeadline(String input) {
        
        return "";
    }

    /**
     * Creates an ArrayList of sensational words or phrases often used in fake headlines.
     *
     * @return ArrayList<String> This returns an ArrayList of sensational words or phrases.
     */
    public ArrayList<String> createWordsList() {
        ArrayList<String> temp = new ArrayList<String>();

        temp.add("shocking");
        temp.add("you won't believe");
        temp.add("unbelievable");
        temp.add("miracle");
        temp.add("secret");
        temp.add("conspiracy");

        return temp;
    }

    /**
     * Creates a TextField for user input and sets an action to classify
     * the input as a headline and display the classification result.
     * 
     * @return the created TextField
     */
    public TextField createInputField() {
        TextField tempField = new TextField();

        tempField.setOnAction(event -> {
            String userInput = tempField.getText();
            
            updateUserResponse(userInput);
            updateClassificationResult(userInput);
            
            tempField.clear();
        });

        return tempField;
    }

    /**
     * Updates the user response with the given input.
     * 
     * @param userInput the input provided by the user
     */
    public void updateUserResponse(String userInput) {
        results.appendText("Headline: " + userInput + "\n");
    }

    /**
     * Updates the classification result of the given user input by calling
     * the classifyHeadline method and appending the result to the results text area.
     * 
     * @param userInput the user input to classify
     */
    public void updateClassificationResult(String userInput) {
        String classification = classifyHeadline(userInput);
        results.appendText("Classification: " + classification + "\n");
    }

}
