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
}
