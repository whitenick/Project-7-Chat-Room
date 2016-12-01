package assignment7;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class CombinedUIExecution extends Application {
	
	public static ChatGUI Client1 = new ChatGUI();
	final ServerMain bob = new ServerMain();
	
	@Override
	public void start(Stage primaryStage) {
		String clientOne = new String("ClientOne (Testing Response)");
		Client1.userName = clientOne;
		//ChatGUI.mainClient.userName = clientOne;
	
		LoginGUI.startDisplay();
//		Task<Void> sleeper = new Task<Void>() {
//			@Override
//			protected Void call() throws Exception {
//				LoginGUI.startDisplay();
//				return null;
//			}
//		};
//		
//		sleeper.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//			@Override
//			public void handle(WorkerStateEvent event) {
//				Client1.startDisplay();
//				
//				
//				ServerGUI.startDisplay();
//				//ServerMain.serverInitialize()
//			}
//		});
//		new Thread(sleeper).start();

		ServerGUI.startDisplay();
		
		Thread one = new Thread() {
			public void run() {
				bob.serverInitialize();
			}
		};
		Client1.userName = clientOne;
	
		
		
		one.start();
		
		
		
		ClientMain mainClient = new ClientMain(clientOne);
		ChatGUI.mainClient = mainClient;
		ServerMain.activeClients.add(mainClient);
		//ChatGUI.tabArray.put(mainClient, ChatGUI.openTabs.get(0));
		
		//ChatGUI.mainClient = mainClient;
		//ChatGUI.startClientThread();
		//client.chatOutput = 
		//client.userName = LoginGUI.userName;
		
		//Debug: show ip address of machine
		
		System.out.println(ServerMain.ipAddress);
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
