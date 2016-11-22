package assignment7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChatGUI extends Application {
	public static Pane mainPane = new Pane();
	public static BorderPane boarderPane = new BorderPane();
	//Chat Window start 
	
	
	public void initializeTextBox() {
		TextField userTextField = new TextField();
		userTextField.setPadding(new Insets(10, 10, 100, 10));
		boarderPane.setBottom(userTextField);
		boarderPane.setPadding(new Insets(0, 20, 10, 20));
		
		boarderPane.setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		
	}
	
	
	public void initializeConversationDialog() {
		
		//initialize dialog conversation for active message threads 
		
		
		
		
	}
	
	

	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Server Chat Room");
		
		mainPane.setPadding(new Insets(20, 20, 20, 20));
		Scene scene = new Scene(boarderPane, 500, 500, Color.BEIGE);
		
		initializeTextBox();
		
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Show the ServerGUI (Implement not in this routine, bad style)
		
		ServerGUI serverWindow = new ServerGUI();
		Stage serverStage = new Stage();
		serverWindow.start(serverStage);
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
