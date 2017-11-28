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

public class PropertySpaceGui extends Pane {
	
	private String groupColor;
	private String ownerColor;
	
	private Label label;
	private VBox layout;
	private Pane colorPane;
	
	public PropertySpaceGui(String groupColor, String title) {
		this.groupColor = groupColor;
		this.label = new Label(title);
		
		layout = new VBox(5);
		layout.setAlignment(Pos.CENTER);
		colorPane = new Pane();
		colorPane.setPrefSize(55,15);
		colorPane.setStyle("-fx-background-color: #" + this.groupColor);
		layout.getChildren().add(colorPane);
		layout.getChildren().add(label);
		this.getChildren().add(layout);
		
	}
	
	public void setOwnerColor(String color) {
		this.ownerColor = color;
		this.label.setStyle("-fx-background-color: #" + this.ownerColor);
		
	}

}
