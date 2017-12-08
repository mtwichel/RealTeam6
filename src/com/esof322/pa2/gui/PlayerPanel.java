package com.esof322.pa2.gui;

import java.awt.TextField;

import com.esof322.pa2.model.Banker;

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
	
	private Label playerCash;
	private Label playerName;
	private Button trade;

	public PlayerPanel() {
		Facade.setPlayerPanel(this);
		propertyList = new PropertyCardList(Facade.getBanker().getCurrentPlayer());
		
		//Use below to place things in panels?
		//playerPanel.positionInArea(child, areaX, areaY, areaWidth, areaHeight, areaBaselineOffset, margin, halignment, valignment, isSnapToPixel);/////////////////////
		playerName = new Label(Facade.getBanker().getCurrentPlayer().getName());
		playerName.setStyle("-fx-font: 20 arial");
		playerCash = new Label("Balance: $"+Facade.getBanker().getCurrentPlayer().getBalance());
		playerCash.setStyle("-fx-font: 20 arial");
		
		listView = new ListView<>();
		listView.setPrefSize(250, 400);
		
		trade = new Button("Trade");
		trade.setPrefWidth(250);
		trade.setAlignment(Pos.CENTER);
		trade.setOnAction(e -> openTradeWindow());
		
		this.getChildren().addAll(playerName,propertyList,playerCash,trade);
		this.setSpacing(10);
		this.setPadding(new Insets(20,20,20,20));
		this.setAlignment(Pos.CENTER);
	}
	
	public void update() {
		//playerName.setText(Facade.getBanker().getCurrentPlayer().getName());
		//playerCash.setText("Balance: $"+Facade.getBanker().getCurrentPlayer().getBalance());
		//propertyList.updateList();
		this.getChildren().clear();
		PropertyCardList temp = new PropertyCardList(Facade.getPlayerList()[0]);
		playerName.setText(Facade.getBanker().getCurrentPlayer().getName());
		playerCash.setText("Balance: $"+Facade.getBanker().getCurrentPlayer().getBalance());
		this.getChildren().addAll(playerName,temp,playerCash,trade);
	}
	
	private void openTradeWindow() {
		new TradeWindow();
	}
}
