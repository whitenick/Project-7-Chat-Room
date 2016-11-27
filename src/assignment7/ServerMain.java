package assignment7;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/*The server is responsible for receiving messages 
 * from clients and dispatching messages to ap- propriate 
 * clients. You just need one server; call the main class
 * of the server ServerMain.java. Make sure that ServerMain.java
 * has a main() method.
 */

/*Main method for server chat room program resides in the ServerMain.main class
 * Initialize server and start chat room GUI windows 
 */


public class ServerMain {
	
	//Server global variables
	
	public static InetAddress ip;
	public static String ipAddress;
	public static ServerSocket serverSock;
	public static int serverPort = 5000;
	
	
	public static void serverInitialize() {
		
		
		
		
		//Initialize public conversation server threads 
		/*Begin thread tasks by allowing run sequence 
		 *to check for conversation change and if changed, 
		 *refresh conversation dialog
		 */
		
		//ChatGUI.main(null); 
		//ChatGUI.startDisplay();
		//ServerGUI.startDisplay();
		
		
		//Start socket connection @ port: 4242
		
		try {
			serverSock = new ServerSocket(serverPort);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String hostname;
		
		try {
			ip = InetAddress.getLocalHost();
			hostname = ip.getHostName();
			ipAddress = ip.getHostAddress();
			ServerGUI.serverLabel.setText(ServerGUI.serverLabel.getText() + ipAddress + "\n");
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean activeSession = true;
		
		while (activeSession) {
			try {
				Socket clientSock = serverSock.accept();
				ClientMain thread = new ClientMain(clientSock);
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		
		
		
		
		
		
		
		
		
		
	}
}
