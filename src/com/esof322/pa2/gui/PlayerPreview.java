package com.esof322.pa2.gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PlayerPreview extends VBox{
	
	private final int FONT_SIZE = 20;
	
	private Label l;
	private Label balance;
	private Button viewProperties;
	
	public PlayerPreview(String player,int bal){
		
		//Adds Larger Player name to Custom VBox
		Label l = new Label(player);
        l.setStyle("-fx-font: 20 arial");
        l.setPadding(new Insets(7,0,7,0));
        
        balance = new Label(""+bal);
        balance.setPadding(new Insets(7,0,7,0));
        
        viewProperties = new Button("View Properties");
        viewProperties.setOnAction(e -> displayProperties());
        viewProperties.setPadding(new Insets(7,0,7,0));
        
        this.getChildren().addAll(l,balance,viewProperties);
        this.setStyle("-fx-border-color: black");
        this.setPadding(new Insets(70,20,70,20));
        this.setAlignment(Pos.CENTER);
	}
	
	private void displayProperties() {
		PlayerPropertyListPopUp.display("Player Inventory");
	}
}
