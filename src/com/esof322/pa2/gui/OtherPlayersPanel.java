package com.esof322.pa2.gui;

import javafx.geometry.VPos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class OtherPlayersPanel extends VBox{

	private PlayerPreview player1;
	private PlayerPreview player2;
	private PlayerPreview player3;
	
	public OtherPlayersPanel() {
		//Change to actually get Player's info
		player1 = new PlayerPreview("Player1", 1500);
		player2 = new PlayerPreview("Player2", 1500);
		player3 = new PlayerPreview("Player3", 1500);
		
		this.getChildren().addAll(player1,player2,player3);
		
		this.setStyle("-fx-border-color: black");
	}
	//private PlayerPreview[] players;
	/*public void init() {
		//pop up window asks how many players will there be on setup window
		for(int i = 1;i<5;i++) {
			PlayerPreview player = new PlayerPreview("Player"+i, 1500);
			players[i-1] = player;
		}
	}*/
}
