package assignment7;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientMain implements Runnable {
	
	//Serves thread implementation of clients contacting server
	
	private Thread classThread;
	private String threadString;
	private Socket clientSocket;
	
	public ClientMain(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	
	@Override 
	public void run() {
		try {
			Socket sock = new Socket(ServerMain.ipAddress, ServerMain.serverPort);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	void randomWait() {
		try {
			Thread.currentThread();
			Thread.sleep((long)(3000*Math.random()));
		} catch (InterruptedException e) {
			System.out.println("Interrupted!");
		}
	}
	
	public void start() {
		classThread = new Thread(this, threadString);
		classThread.start();
	}
}
