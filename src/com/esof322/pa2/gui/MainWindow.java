package com.esof322.pa2.gui;


import org.hamcrest.core.IsInstanceOf;

import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.ModelListener;
import com.esof322.pa2.model.PropertySpace;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class MainWindow extends Application implements ModelListener, EventHandler<ActionEvent>{
	
	Banker banker;
	
	Label currentPlayer, currentPlayerMoney;
	
	Button currentAction;
	
	VBox propertyList;
	HBox currentPlayerHeading;
	HBox actionBar;
	GridPane board;
	
	PropertySpaceGui[] spacesGUIs;

	@Override
	public void start(Stage primaryStage) throws Exception {
		banker = new Banker(this);
		
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
		currentAction.setOnAction(this);
		currentAction.setStyle("-fx-padding: 20");
		actionBar.getChildren().add(currentAction);
		
		board = new GridPane();
		int i =0;
		spacesGUIs = new PropertySpaceGui[40];
		fillOutGUIs();
		for(int y=0; y<10; y++) { //fist row
			board.add(spacesGUIs[i], y, 0);;
			i++;
		}
		for(int x=0; x<10; x++) {
			board.add(spacesGUIs[i], 10, x);;
			i++;
		}
		for(int y=10; y>=0; y--) {
			board.add(spacesGUIs[i], y, 10);;
			i++;
		}
		for(int x=9; x>0; x--) {
			board.add(spacesGUIs[i], 0, x);;
			i++;
		}
		
		
		BorderPane mainLayout = new BorderPane();
		mainLayout.setTop(currentPlayerHeading);
		mainLayout.setLeft(propertyList);
		mainLayout.setCenter(board);
		mainLayout.setBottom(actionBar);
		Scene scene = new Scene(mainLayout, 800, 600);
		
		primaryStage.setTitle("Monopoly");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	
	private void fillOutGUIs() {
		// TODO Auto-generated method stub
		for(int i=0; i<40; i++) {
			spacesGUIs[i] = new PropertySpaceGui("395840", "#" + i);
			spacesGUIs[i].setStyle("-fx-border-color: black");
		}
		
	}


	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void updateCurrentPlayer() {
		currentPlayer.setText(banker.getCurrentPlayer().getName());
		
	}


	@Override
	public void updatePropertiesOwned() {
		// TODO Auto-generated method stub
		for(int i=0; i<spacesGUIs.length; i++) {
			if(banker.getBoard().getSpace(i) instanceof PropertySpace) {
				//if space is property space
				if(((PropertySpace) banker.getBoard().getSpace(i)).getOwner() != null) {
					//if property space has an owner
					spacesGUIs[i].setOwnerColor(
							((PropertySpace) banker.getBoard().getSpace(i))
							.getOwner().getColor());
				}else {
					spacesGUIs[i].setOwnerColor("FFFFFF");
				}
				 

			}
		}
	}


	@Override
	public void updateActionButton() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updatePlayerPositions() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void updateCurrentPlayerMoney() {
		currentPlayerMoney.setText("$" + banker.getCurrentPlayer().getBalance());
	}


	@Override
	public void handle(ActionEvent event) {
		//this is the controller for the entire normal game play
		banker.takeAction();
	}

}
