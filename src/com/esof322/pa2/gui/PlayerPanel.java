package com.esof322.pa2.gui;

import java.awt.TextField;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PlayerPanel {

	private VBox playerPanel;
	//private ListView<Property> listView;//Chance Type to Property Later
	private ListView<String> listView;
	private PropertyCardList propertyList = new PropertyCardList();;
	
	private final int MAX_VALUE = 100;
	private VBox properties;

	public PlayerPanel() {
		properties = new VBox();
		properties.setAlignment(Pos.CENTER);
		
		properties.getChildren().add(propertyList.getPropertyCardList());
		
		playerPanel = new VBox();
		//Use below to place things in panels?
		//playerPanel.positionInArea(child, areaX, areaY, areaWidth, areaHeight, areaBaselineOffset, margin, halignment, valignment, isSnapToPixel);/////////////////////
		Label playerName = new Label("Player1");//Need to input player name here
		Label playerCash = new Label("Balance: $1500");
		
		listView = new ListView<>();
		
		//These are just here to populate the list to show off for now. will be removed at a later date.
		populateProperties("Mediterranean Avenue", 60,1,0);
		populateProperties("Baltic Avenue", 60,1,1);
		populateProperties("Oriental Ave.", 100,2,0);
		populateProperties("Connecticut Ave.", 120,2,0);
		populateProperties("Tennessee Ave.", 180,4,0);
		populateProperties("Water Works",150,0,0);
		populateProperties("B. & O. Railroad",200,0,0);
		populateProperties("Indiana Ave.", 220,5,0);
		populateProperties("St. Charles Place", 140,3,0);
		listView.setPrefSize(250, 400);
		
		Button tempButton = new Button("Remove Property");
		/*tempButton.onActionProperty(e -> {
			propertyList.removeProperty(1);
		});
		*/
		playerPanel.getChildren().addAll(playerName,properties,playerCash);
		playerPanel.setSpacing(10);
		playerPanel.setPadding(new Insets(20,20,20,20));
		playerPanel.setAlignment(Pos.CENTER);
	}

	public VBox getPlayerPanel() {
		return playerPanel;
	}
	
	private void populateProperties(String name, int value,int color,int pos) {
		//change to add to list
		propertyList.addPropertyCard(name, value,color,pos);
	}
}
