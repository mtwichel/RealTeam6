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
		
		player1 = new PlayerPreview(1);
		player2 = new PlayerPreview(2);
		player3 = new PlayerPreview(3);
		
		this.getChildren().addAll(player1,player2,player3);
		this.setStyle("-fx-border-color: black");
		
		Facade.setOtherPlayerPanel(this);
	}
	
	public void update() {
		this.getChildren().clear();
		player1 = new PlayerPreview(1);
		player2 = new PlayerPreview(2);
		player3 = new PlayerPreview(3);
		this.getChildren().addAll(player1,player2,player3);
	}
}
