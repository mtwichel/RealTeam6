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
		
		switch (Facade.getBanker().getPlayerList().length) {
		case 2:
			player1 = new PlayerPreview(1);
			
			this.getChildren().addAll(player1);
			break;
		case 3:
			player1 = new PlayerPreview(1);
			player2 = new PlayerPreview(2);
			
			this.getChildren().addAll(player1,player2);
			break;
		case 4:
			player1 = new PlayerPreview(1);
			player2 = new PlayerPreview(2);
			player3 = new PlayerPreview(3);
			
			this.getChildren().addAll(player1,player2,player3);
			break;

		default:
			break;
		}
		
		this.setStyle("-fx-border-color: black");
		Facade.setOtherPlayerPanel(this);
	}
	
	public void update() {
		this.getChildren().clear();
		switch (Facade.getBanker().getPlayerList().length) {
		case 2:
			player1 = new PlayerPreview(1);
			
			this.getChildren().addAll(player1);
			break;
		case 3:
			player1 = new PlayerPreview(1);
			player2 = new PlayerPreview(2);
			
			this.getChildren().addAll(player1,player2);
			break;
		case 4:
			player1 = new PlayerPreview(1);
			player2 = new PlayerPreview(2);
			player3 = new PlayerPreview(3);
			
			this.getChildren().addAll(player1,player2,player3);
			break;

		default:
			break;
		}
		
	}
}
