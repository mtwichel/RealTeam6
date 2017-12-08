package esof322.pa4.Team6.exceptions;

import esof322.pa4.Team6.gui.MainWindow;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GameEnd {
	
	public GameEnd(String title, String message) {
		display(title,message);
	}
	
	public static void display(String title, String message) {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(350);
		window.setResizable(false);
		
		Label label = new Label();
		label.setText(message);
		label.setStyle("-fx-font: 35 arial");
		
		Button closeButton = new Button("END GAME");
		closeButton.setOnAction(e -> {
		    System.out.println("Game ending...");
		    MainWindow.endGame();
		});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		window.setOnCloseRequest(event -> {
		    System.out.println("Game ending...");
		    MainWindow.endGame();
		});
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();
		
	}
}