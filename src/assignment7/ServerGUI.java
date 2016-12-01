package assignment7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ServerGUI extends Application {
	public static Label serverLabel;
	
	public static void startDisplay() {
		ServerGUI serverWindow = new ServerGUI();
		Stage serverStage = new Stage();
		serverWindow.start(serverStage);
	}
	
	
	@Override
	public void start(Stage serverStage) {
	
		serverStage.setTitle("Server Analysis"); 
		
		GridPane root = new GridPane();
		root.setPadding(new Insets(10, 20, 10, 20));
		
		root.setBackground(new Background(new BackgroundFill(Color.LAWNGREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		
		Label serverOutput = new Label("Server Analysis: ");
		serverLabel = serverOutput;
		serverLabel.setText(serverLabel.getText() + "\n Port: " + ServerMain.serverPort + "\n");;
		root.getChildren().add(serverLabel);
		serverLabel.setFont(Font.font("Tahoman", FontWeight.NORMAL, 20));
		root.setAlignment(Pos.TOP_CENTER);
		
		
		Scene scene = new Scene(root, 300, 500, Color.ALICEBLUE);
		serverStage.setScene(scene);
		serverStage.show();
	}
}
