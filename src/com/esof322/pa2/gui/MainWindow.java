package com.esof322.pa2.gui;


import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.ModelListener;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
	
	Button currentAction;
	
	VBox propertyList;
	HBox currentPlayerHeading;
	HBox actionBar;

	@Override
	public void start(Stage primaryStage) throws Exception {
		banker = new Banker();
		
		currentPlayer = new Label();
		currentPlayerMoney = new Label();
		currentPlayerHeading = new HBox(14);
		currentPlayerHeading.setAlignment(Pos.CENTER);
		currentPlayerHeading.getChildren().add(currentPlayer);
		currentPlayerHeading.getChildren().add(currentPlayerMoney);
		currentPlayerHeading.setStyle("-fx-border-color: black");;
		
		
		propertyList = new VBox(2);
		propertyList.getChildren().add(new Label("Properties Owned: "));
		propertyList.setStyle("-fx-border-color: black");
		
		actionBar = new HBox();
		actionBar.setAlignment(Pos.CENTER_RIGHT);
		currentAction = new Button();
		currentAction.setStyle("-fx-padding: 20");
		actionBar.getChildren().add(currentAction);
		
		
		BorderPane mainLayout = new BorderPane();
		mainLayout.setTop(currentPlayerHeading);
		mainLayout.setLeft(propertyList);
		mainLayout.setBottom(actionBar);
		Scene scene = new Scene(mainLayout, 600, 500);
		
		primaryStage.setTitle("Monopoly");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}

}
