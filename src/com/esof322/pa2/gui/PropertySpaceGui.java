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

public class PropertySpaceGui extends SpaceGUI {
	
	private String groupColor;
	private String ownerColor;
	
	private Pane colorPane;
	
	public PropertySpaceGui(String groupColor, String title) {
		super(title);
		this.groupColor = groupColor;
		
		
		colorPane = new Pane();
		colorPane.setPrefSize(this.getWidth(),15);
		colorPane.setStyle("-fx-background-color: #" + this.groupColor);
		layout.getChildren().add(0, colorPane);
		
	}
	
	public void setOwnerColor(String color) {
		this.ownerColor = color;
		this.label.setStyle("-fx-background-color: #" + this.ownerColor);
		
	}

}
