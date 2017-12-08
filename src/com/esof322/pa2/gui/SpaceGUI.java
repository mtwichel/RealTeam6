package com.esof322.pa2.gui;

import java.util.List;

import com.esof322.pa2.model.Player;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class SpaceGUI extends Pane {
	
	private String ownerColor;
	
	protected Label label;
	protected VBox layout;
	private Label piece;
	
	public SpaceGUI(String title) {
		this.setWidth(100);
		this.setHeight(300);
		
		this.label = new Label(title);
		this.label.setWrapText(true);
		this.label.setPrefWidth(100);
		this.label.setAlignment(Pos.CENTER);
		
		piece = new Label();
		
		
		layout = new VBox(5);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().add(label);
		layout.getChildren().add(piece);
		this.getChildren().add(layout);
		this.setStyle("-fx-border-color: black");		
		
	}
	
	public void setOwnerColor(String color) {
		this.ownerColor = color;
		this.label.setStyle("-fx-background-color: #" + this.ownerColor);
		
	}

	public void setPieces(List<Player> players) {
		String ans = "";
		for(Player p : players) {
			ans += p.getName() + "\n";
		}
		this.piece.setText(ans);
	}

}
