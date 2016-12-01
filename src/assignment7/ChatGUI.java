package assignment7;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import javafx.scene.control.TextField;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ChatGUI extends Application {
	
	//public Pane mainPane = new Pane();
	public static ClientMain mainClient;
	public static TabPane tabPane = new TabPane();
	public static HashMap<ClientMain, Tab> tabArray = new HashMap<ClientMain, Tab>();
	public static List<Tab> openTabs = new ArrayList<Tab>();
	public static TextArea userText = new TextArea();
	public static Label chatOutput = new Label();
	public String userName; 
	
	public static Button sendButton = new Button("Send");
	
	//public static Label serverLabel;
	//Chat Window start 
	
	
	public void initializeChat(String userName) {
		//System.setOut(out);
		//Set Tab Pane
		//tabPane.
		
		
		
		
		BorderPane boarderPane = new BorderPane();
		
		
		
		//Use a VBox positioned to the center of the boarderPane
		//
		VBox rightPane = new VBox();
		VBox centerPane = new VBox();
		//StackPane rightPane = new StackPane();
		
		centerPane.setPadding(new Insets(10));
		centerPane.setSpacing(10);
		
		
		ScrollPane chatPane = new ScrollPane();
		ScrollPane userPane = new ScrollPane();
		chatPane.setPrefHeight(300);
		chatOutput.setWrapText(true);
		chatOutput.setAlignment(Pos.TOP_LEFT);
		//chatOutput.setPrefSize(300, 300);
		//chatOutput.
		userText.prefWidthProperty().bind(userPane.prefWidthProperty());
		userText.prefHeightProperty().bind(userPane.prefHeightProperty());
		
		userText.setWrapText(true);
		
		
		userPane.setContent(userText);
		chatPane.setContent(chatOutput);
		userPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		chatPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		userPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		chatPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
//		chatPane.setPrefSize(300, 300);
//		userPane.setPrefSize(300, 100);
		
		userPane.setFitToWidth(true);
		chatPane.setFitToWidth(true);
//		userPane.setFitToHeight(true);
//		chatPane.setFitToWidth(true);
		centerPane.getChildren().add(chatPane);
		centerPane.getChildren().add(userPane);
		
		boarderPane.setCenter(centerPane);
		
		boarderPane.setRight(sendButton);
		
		//chatPane.setV
		
		
		boarderPane.setRight(rightPane);
		
		
		rightPane.getChildren().add(sendButton);
		rightPane.setAlignment(Pos.CENTER);
		rightPane.setPadding(new Insets(20));
		//StackPane.setAlignment(sendButton, Pos.BOTTOM_CENTER);
		
		sendButton.setAlignment(Pos.BOTTOM_CENTER);
		
		this.newMessage(rightPane);
		
		
		boarderPane.setPadding(new Insets(10, 20, 10, 0));
		
		boarderPane.setBackground(new Background(new BackgroundFill(Color.BISQUE, CornerRadii.EMPTY, Insets.EMPTY)));
		
		Tab newTab = new Tab();
		
		newTab.setText(userName);
		
		openTabs.add(newTab);
		
		newTab.setContent(boarderPane);
		
		tabPane.getTabs().add(newTab);
		
		tabArray.put(tempClient, newTab);
		
		
		
	}
	
	public synchronized void outputText(ClientMain client) {
		
	}
	
	public ClientMain tempClient;
	
	public void newChat(ClientMain e, String userName) {
		
		
		tempClient = e;
		this.initializeChat(userName);
	}
	public void initializeConversationDialog() {
		
		//initialize dialog conversation for active message threads 
		
		
	}
	
//	public static void startClientThread() {
//		Thread chatOutputThread = new Thread() {
//			public void run() {
//				try {
//					
//					while (mainClient.reader.readLine() != null) {
//						Platform.runLater(new Runnable() {
//							public void run() {
//								chatOutput.setText(mainClient.incoming.getText());
//							}
//						});
//					}
//						
//				} catch (IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		};
//		
//		chatOutputThread.start();
//	}
	
	public void newMessage(VBox newStack) {
		newStack.setPadding(new Insets(40, 10, 40, 10));
		newStack.setSpacing(30);
		Button newButton = new Button("New Message");
		TextField newUserName = new TextField();
		
		newStack.getChildren().add(newUserName);
		newStack.getChildren().add(newButton);
		
		newButton.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				if(newUserName.getText() != "null") {
					Scanner sb = new Scanner(newUserName.getText());
					ServerMain.newClient(sb.next());
				}
				
				
			}
		});
		
		
		
		
	}
	
	public void startDisplay() {
		Stage chatStage = new Stage();
		this.start(chatStage);
	}
	

	
	@Override
	public void start(Stage primaryStage) {
		
		//Setup for Chat Message Window
		
		primaryStage.setTitle("Chat Room");
		
		Scene scene = new Scene(tabPane, 800, 500, Color.BEIGE);
		
		initializeChat(LoginGUI.username);
		
		
		
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		//Run serverGUI window
		
		//Show the ServerGUI (Implement not in this routine, bad style)
		
//		ServerGUI serverWindow = new ServerGUI();
//		Stage serverStage = new Stage();
//		serverWindow.start(serverStage);
		
		
		
		
	}
	
	
}
