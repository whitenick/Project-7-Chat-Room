package assignment7;

import java.io.BufferedReader;
import javafx.scene.control.Tab;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
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
	public static String hostname;
	
	public static List<ClientMain> activeClients = new ArrayList<ClientMain>();
	
	private static HashMap<PrintWriter, Socket> clientOutputStreams;
	
	public void serverInitialize() {
		
		
		
		
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
		
		try {
			ip = InetAddress.getLocalHost();
			hostname = ip.getHostName();
			ipAddress = ip.getHostAddress();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Platform.runLater(new Runnable() {
			public void run() {
				ServerGUI.serverLabel.setText(ServerGUI.serverLabel.getText() + ipAddress + "\n");
		
			}
		});
		
		clientOutputStreams = new HashMap<PrintWriter, Socket>();
		
		boolean activeSession = true;
		
		while (true) {
			Socket clientSocket;
			PrintWriter writer;
			Thread t;
			try {
				clientSocket = serverSock.accept();
				writer = new PrintWriter(clientSocket.getOutputStream());
				t = new Thread(new ClientHandler(clientSocket));
				t.start();
				clientOutputStreams.put(writer, clientSocket);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("connection complete");
			System.out.println(ip.toString());
		}
//			try {
//				Socket clientSock = serverSock.accept();
//				ClientMain thread = new ClientMain(clientSock);
//			} catch (UnknownHostException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
//		}	
	}
	
	
	public static void newClient(String newMessageClient) {
		//ChatGUI.addTab
		
		//Executes initialization of clientmain active classes and active tabs 
		ClientMain newUser = new ClientMain(newMessageClient);
		activeClients.add(newUser);
		CombinedUIExecution.Client1.initializeChat(newMessageClient);
		
	
	}
	
	static class ClientHandler implements Runnable {
		private BufferedReader reader;
		
		public ClientHandler(Socket clientSocket) throws IOException {
			Socket sock = clientSocket;
			reader = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			
		}
		
		public void run() {
			String message;
			try {
				while ((message = reader.readLine()) != null) {
					notifyClients(message);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		private static void notifyClients(String message) {
			for(Map.Entry<PrintWriter, Socket> entry: clientOutputStreams.entrySet()) {
					entry.getKey().println(message);
					entry.getKey().flush();
			}
		}
		
	}
	

	
	
}
