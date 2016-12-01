package assignment7;

//import java.awt.Color;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LoginGUI extends Application {
	public static Label loginLabel;
	public static String username;
	public static boolean close = false;
	
	//public static boolean authenticated = false;
	//public static boolean authenticated;
	
	public static void startDisplay() {
		LoginGUI loginWindow = new LoginGUI();
		Stage loginStage = new Stage();
		//Stage secondStage = new Stage();
		loginWindow.start(loginStage);
		//loginWindow.start(secondStage);
	}


	private Button myLoginButton;
	
	
	@Override
	public void start(Stage loginStage) {
		// TODO Auto-generated method stub
			
		loginStage.setTitle("Welcome");
		GridPane loginPane = new GridPane();
		GridPane secondPane = new GridPane();
		loginPane.setPadding(new Insets(10, 20, 10, 20));
		loginPane.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));

		//BorderPane loginBorderPane = new BorderPane();
		
		
		Label loginLabel1 = new Label("Please enter your credentials.");
		loginLabel1.setFont(Font.font("Tahoman", FontWeight.BOLD, 15));
		loginLabel = loginLabel1;
		//loginLabel.setAlignment(Pos.TOP_CENTER);
		loginPane.setAlignment(Pos.TOP_CENTER);
    	//loginPane.add(loginLabel, 100, 100);
    	
    	/*Button btn = new Button();
        btn.setText("Login");
        btn.setAlignment(Pos.BOTTOM_CENTER);
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                //System.out.println("Hello World!");
            	//counter++;
            	//counterLabel.setText(counter + "");
            	
            }
        });
        
        loginPane.getChildren().add(btn);*/

    	  HBox hbox = new HBox();
    	  //hbox.setAlignment(Pos.CENTER);
    	  this.myLoginButton = new Button(); 
    	  myLoginButton.setText("Login");
    	     TextField field = new TextField();
    	     HBox.setHgrow(field, Priority.ALWAYS);
    	     hbox.getChildren().addAll(new Label("Username:  "), field, myLoginButton);
    	     
    	     myLoginButton.setOnAction(new EventHandler<ActionEvent>() {
    	    	 
    	            @Override
    	            public void handle(ActionEvent event) {
    	            	if(!(field.getText().isEmpty())){
    	            	String msg = field.getText();
    	            	
    	            	username = msg;
    	            	//System.out.println(msg);	DEBUG Code
    	            	
    	            	field.clear();
    	            	close = true;
    	            	
    	            	loginStage.close();
    	            	
    	            	CombinedUIExecution.Client1.startDisplay();
    	            	
    	            	//Thread.currentThread().notifyAll();
    	                //System.out.println("Hello World!");
    	            	//counter++;
    	            	//counterLabel.setText(counter + "");
    	            	}
    	            	
    	            }
    	        });
    	     
    	   //loginPane.add(hbox, 10, 5);  
    	   
    	   VBox vbox = new VBox(200); // spacing = 8
    	   vbox.getChildren().addAll(loginLabel); 
    	     vbox.getChildren().addAll(hbox);
    	     
    	     vbox.setAlignment(Pos.CENTER);
    	     
    	     loginPane.add(vbox, 100, 100);
		//loginPane.setPadding(new Insets(20,20,20,20));
		Scene scene1 = new Scene(loginPane, 800, 500, Color.AQUAMARINE);
		Scene scene2 = new Scene(secondPane, 25, 25, Color.GREEN);
		//loginBorderPane.setBackground(new Background(new BackgroundFill(Color.AQUAMARINE, CornerRadii.EMPTY, Insets.EMPTY)));
		//loginPane.getChildren().add(loginBorderPane);
		
		
		
		loginStage.setScene(scene1);
		//Stage.setScene(scene2);
		loginStage.show();
		
	}

}
