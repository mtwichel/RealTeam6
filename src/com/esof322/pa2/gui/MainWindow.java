package com.esof322.pa2.gui;


import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.ModelListener;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class MainWindow extends Application implements ModelListener{
	
	Banker banker;
	
	Label currentPlayer, currentPlayerMoney;
	
	VBox propertyList;
	HBox currentPlayerHeading;

	@Override
	public void start(Stage primaryStage) throws Exception {
		banker = new Banker();
		
		currentPlayer = new Label("Current Player: Marcus");
		currentPlayerMoney = new Label("$1,500");
		currentPlayerHeading = new HBox(2);
		currentPlayerHeading.getChildren().add(currentPlayer);
		currentPlayerHeading.getChildren().add(currentPlayerMoney);
		currentPlayerHeading.setStyle("-fx-border-color: black");;
		
		
		propertyList = new VBox(2);
		propertyList.getChildren().add(new Label("Properties Owned: "));
		propertyList.setStyle("-fx-border-color: black");
		
		
		BorderPane mainLayout = new BorderPane();
		mainLayout.setTop(currentPlayerHeading);
		mainLayout.setLeft(propertyList);
		Scene scene = new Scene(mainLayout, 600, 500);
		
		primaryStage.setTitle("Monopoly");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
