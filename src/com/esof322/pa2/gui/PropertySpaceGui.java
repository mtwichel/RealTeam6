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
	
	private String color;
	private Label label;
	
	public PropertySpaceGui(String color, String title) {
		this.color = color;
		this.label = new Label(title);
		
		VBox layout = new VBox(5);
		layout.setAlignment(Pos.CENTER);
		Pane colorPane = new Pane();
		colorPane.setPrefSize(55,15);
		colorPane.setStyle("-fx-background-color: #" + color);
		layout.getChildren().add(colorPane);
		layout.getChildren().add(label);
		this.getChildren().add(layout);
		
	}

}
