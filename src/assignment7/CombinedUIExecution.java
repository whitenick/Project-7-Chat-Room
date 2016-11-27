package assignment7;

import javafx.application.Application;
import javafx.stage.Stage;

public class CombinedUIExecution extends Application {

	
	@Override
	public void start(Stage primaryStage) {
		ChatGUI.startDisplay();
		ServerGUI.startDisplay();
		
		ServerMain.serverInitialize();
		
		
		//Debug: show ip address of machine
		
		System.out.println(ServerMain.ip);
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
