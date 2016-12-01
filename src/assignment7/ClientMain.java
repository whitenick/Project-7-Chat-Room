package assignment7;

import java.awt.event.ActionListener;

import javafx.application.Platform;
//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;


public class ClientMain {
	
	//Serves thread implementation of clients contacting server
	

	private String threadString;
	private Socket clientSocket;
	
	public BufferedReader reader;
	private PrintWriter writer;
	public JTextArea incoming;
	public JTextField outgoing;
	//public Label chatOutput = incoming.getText();
	
	public ChatGUI thisClientChat = new ChatGUI();
	public String userName;
	//public List<ClientMain> 
	
	public ClientMain(String userName) {
		
		
		this.userName = userName;
		initView();
		try {
			networkSetup();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void initializeUserField() {
		//ChatGUI.boarderPane.();
	}
	
	private void networkSetup() throws Exception {
		
		incoming = new JTextArea();
		Socket sock = new Socket(ServerMain.ipAddress, ServerMain.serverPort);
		InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
		reader = new BufferedReader(streamReader);
		writer = new PrintWriter(sock.getOutputStream());
		Thread readerThread = new Thread(new ClientReader());
		readerThread.start();
	}
	
	//Run method for thread object transfered to runnable class ClientReader (Specific to message output stream)
	
//	@Override 
//	public void run() {
//		try {
//			Socket sock = new Socket(ServerMain.ipAddress, ServerMain.serverPort);
//		} catch (UnknownHostException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//	}
	
	
	void randomWait() {
		try {
			Thread.currentThread();
			Thread.sleep((long)(3000*Math.random()));
		} catch (InterruptedException e) {
			System.out.println("Interrupted!");
		}
	}
	
//	public void start() {
//		classThread = new Thread(this, threadString);
//		classThread.start();
//	}
	
	
	class ClientReader implements Runnable {
		
		@Override
		public void run() {
			String message;
			try {
				Platform.runLater(new Runnable() {
					public void run() {
						ChatGUI.tabArray.get(ChatGUI.tabArray.size()-1).setId(userName);
						ChatGUI.tabArray.get(ChatGUI.tabArray.size()-1).setText(userName);
					}
				});
				while ((message = reader.readLine()) != null) {
					incoming.append(userName + ": " + message + "\n");
					
						Platform.runLater(new Runnable() {	
							public void run() {
								ChatGUI.chatOutput.setText(incoming.getText());
							}
						});
					
//					Platform.runLater(new Runnable() {
//						public void run() {
//							ChatGUI.chatOutput.setText(incoming.getText());
//						}
//					});
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			} catch (IOException e) {
				System.out.println("Error appending conversation");
				// TODO Auto-generated catch block
			}
		}	
		
	}
	
	private void initView() {
		outgoing = new JTextField(20);
		ChatGUI.sendButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				outgoing.setText(ChatGUI.userText.getText());
				writer.println(outgoing.getText());
				writer.flush();
			}
		});
	}
	
}
