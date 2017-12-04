package com.esof322.pa2.gui;

import java.awt.TextField;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PlayerPanel extends VBox{

	private VBox playerPanel;
	//private ListView<Property> listView;//Chance Type to Property Later
	private ListView<String> listView;
	private PropertyCardList propertyList;// = new PropertyCardList(Facade.getBanker().getCurrentPlayer());
	
	private final int MAX_VALUE = 100;
	private VBox properties;
	
	private Label playerCash;
	private Label playerName;

	public PlayerPanel() {
		Facade.setPlayerPanel(this);
		properties = new VBox();
		properties.setAlignment(Pos.CENTER);
		propertyList = new PropertyCardList(Facade.getBanker().getCurrentPlayer());
		properties.getChildren().add(propertyList);
		
		//Use below to place things in panels?
		//playerPanel.positionInArea(child, areaX, areaY, areaWidth, areaHeight, areaBaselineOffset, margin, halignment, valignment, isSnapToPixel);/////////////////////
		playerName = new Label(Facade.getBanker().getCurrentPlayer().getName());
		playerCash = new Label("Balance: $"+Facade.getBanker().getCurrentPlayer().getBalance());
		
		listView = new ListView<>();
		listView.setPrefSize(250, 400);
		
		
		this.getChildren().addAll(playerName,properties,playerCash);
		this.setSpacing(10);
		this.setPadding(new Insets(20,20,20,20));
		this.setAlignment(Pos.CENTER);
	}
	
	public void updatePanel() {
		playerName.setText(Facade.getBanker().getCurrentPlayer().getName());
		playerCash.setText("Balance: $"+Facade.getBanker().getCurrentPlayer().getBalance());
		propertyList = new PropertyCardList(Facade.getBanker().getCurrentPlayer());
	}

	/*private void populateProperties(String name, int value,int color,int pos) {
		//change to add to list
		propertyList.addPropertyCard(name, value,color,pos);
	}*/
}
