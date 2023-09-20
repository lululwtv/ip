package main;

import java.io.IOException;

import javafx.fxml.FXML;
import parser.Parser;
import storage.Storage;
import tasks.TaskList;
import ui.Ui;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * The `Corubi` class represents the main class for the Corubi chatbot application.
 * It serves as the entry point and orchestrates the interaction between the user interface,
 * task management, storage, and command parsing.
 */
public class GigaChadBot extends Application {
    private static final Ui userUi = new Ui();
    private static final TaskList tasks = new TaskList();
    private static final Parser parser = new Parser();
    private static final Storage store = new Storage("./src/main/java/OUTPUT.txt", tasks);

    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    /**
     * Getter method for the storage instance.
     *
     * @return The storage instance used for data persistence.
     */
    public Storage getStore() {
        return store;
    }

    /**
     * Start method to initialize the application.
     */
    @Override
    public void start(Stage stage) throws IOException {
    }

    /**
     * Generates a response to user input.
     *
     * @param input The user's input.
     * @return The chatbot's response.
     * @throws IOException If an IO error occurs during processing.
     */
    public String getResponse(String input) throws IOException {
        return userUi.takeCommands(store, tasks, parser, input);
    }
}
