package com.esof322.pa2.gui;


import org.hamcrest.core.IsInstanceOf;

import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.ModelListener;
import com.esof322.pa2.model.Player;
import com.esof322.pa2.model.PropertySpace;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
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
	Label currentPlayerLabel, currentPlayerMoney;
	
	PlayerPanel playerPanel;
	Console console;
	
	Button currentAction;
	
	HBox currentPlayerHeading;
	HBox actionBar;
	DiceGui dice0;
	DiceGui dice1;
	HBox diceBar;
	GridPane board;
	
	SpaceGUI[] spacesGUIs;

	@Override
	public void start(Stage primaryStage) throws Exception {
		banker = new Banker(this, 4);
		
		//generate current player header
		currentPlayerLabel = new Label();
		currentPlayerMoney = new Label();
		currentPlayerHeading = new HBox(14);
		currentPlayerHeading.setAlignment(Pos.CENTER);
		currentPlayerHeading.getChildren().add(currentPlayerLabel);
		currentPlayerHeading.getChildren().add(currentPlayerMoney);
		currentPlayerHeading.setStyle("-fx-border-color: black");
		
		//generate property list sidebar
		playerPanel = new PlayerPanel();
		playerPanel.getPlayerPanel().setStyle("-fx-border-color: black");
		
		//generate dice
		dice0 = new DiceGui();
		dice1 = new DiceGui();
		diceBar = new HBox(3);
		diceBar.getChildren().add(dice0);
		diceBar.getChildren().add(dice1);
		diceBar.setAlignment(Pos.BOTTOM_LEFT);
				
		//Add console output to GUI on bottom bar
		console = new Console();
		
		//generate action bar
		actionBar = new HBox();
		actionBar.setAlignment(Pos.CENTER);
		currentAction = new Button();
		currentAction.setOnAction(this);
		currentAction.setStyle("-fx-padding: 20");
		currentAction.setAlignment(Pos.BOTTOM_RIGHT);
		actionBar.getChildren().addAll(diceBar, console.getTextArea(), currentAction);
		
		
		
		//generate board
		board = new GridPane();
		int i =0;
		spacesGUIs = new SpaceGUI[40];
		fillOutGUIs();
		for(int y=0; y<10; y++) { //fist row
			board.add(spacesGUIs[i], y, 0);
			i++;
		}
		for(int x=0; x<10; x++) {
			board.add(spacesGUIs[i], 10, x);
			i++;
		}
		for(int y=10; y>=0; y--) {
			board.add(spacesGUIs[i], y, 10);
			i++;
		}
		for(int x=9; x>0; x--) {
			board.add(spacesGUIs[i], 0, x);
			i++;
		}
		
		
		BorderPane mainLayout = new BorderPane();
		mainLayout.setTop(currentPlayerHeading);
		mainLayout.setLeft(playerPanel.getPlayerPanel());
		//mainLayout.setRight(diceBar);
		mainLayout.setCenter(board);
		mainLayout.setBottom(actionBar);
		Scene scene = new Scene(mainLayout, 1350, 800);
		
		primaryStage.setTitle("Monopoly");
		primaryStage.setScene(scene);
		primaryStage.show();
		
		banker.setUpBoard();
	}
	
	
	private void fillOutGUIs() {
		for(int i=0; i<40; i++) {
			if(banker.getBoard().getSpace(i) instanceof PropertySpace) {
				spacesGUIs[i] = new PropertySpaceGui(
						((PropertySpace) banker.getBoard().getSpace(i)).getColor(),
						banker.getBoard().getSpace(i).getName());
//				spacesGUIs[i].setStyle("-fx-border-color: black");
			}else {
				spacesGUIs[i] = new SpaceGUI(banker.getBoard().getSpace(i).getName());
			}
		}
		
	}


	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void updateCurrentPlayer() {
		Player temp = banker.getCurrentPlayer();
		String temp1= temp.getName();
		currentPlayerLabel.setText(temp1);
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
		currentAction.setText(banker.getCurrentActionString());
		
	}


	@Override
	public void updatePlayerPositions() {
		for(int i=0; i<spacesGUIs.length; i++) {
			spacesGUIs[i].setPieces(banker.getBoard().getSpace(i).getOccupyingPlayer());
		}
		
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

	
	@Override
	public void updateDice() {
		Console.println(banker.getDiceValue(0) + " " + banker.getDiceValue(1));
		this.dice0.drawCanvas(banker.getDiceValue(0));
		this.dice1.drawCanvas(banker.getDiceValue(1));
	}

}
