package com.esof322.pa2.gui;

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
	
	public SpaceGUI(String title) {
		this.label = new Label(title);
		this.label.setWrapText(true);
		this.label.setPrefWidth(100);
		this.label.setAlignment(Pos.CENTER);
		
		layout = new VBox(5);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().add(label);
		this.getChildren().add(layout);
		this.setStyle("-fx-border-color: black");
		
	}
	
	public void setOwnerColor(String color) {
		this.ownerColor = color;
		this.label.setStyle("-fx-background-color: #" + this.ownerColor);
		
	}

}
