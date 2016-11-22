package assignment7;

public class ConversationThread implements Runnable {
	private Thread classThread;
	private String threadString;
	
	public ConversationThread() {
		
	}
	
	
	@Override 
	public void run() {
		
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
