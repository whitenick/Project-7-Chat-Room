package assignment7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ServerGUI extends Application {
	
	
	public ServerGUI() {
		
	}
	
	
	public void start(Stage primaryStage) {
	
		primaryStage.setTitle("Message Server");
		Pane root = new Pane();
		root.setPadding(new Insets(10, 20, 10, 20));
		
		root.setBackground(new Background(new BackgroundFill(Color.LAVENDER, CornerRadii.EMPTY, Insets.EMPTY)));
		Scene scene = new Scene(root, 300, 500, Color.CORAL);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
}
