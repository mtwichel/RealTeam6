package com.esof322.pa2.gui;

import com.esof322.pa2.model.Player;
import com.esof322.pa2.model.PropertySpace;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class TradeWindow extends Application {

   
    public TradeWindow() {
    	initTempPlayers();
    	start(new Stage());
    }

    private Stage window;
    private HBox playerChooser; 
    private HBox tradeWindow;
    private Player[] players;
    private Scene scene1;
    private Scene scene2;
    
    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Hello World");
        window = primaryStage;
        window.setResizable(false);
        
        playerChooser = new HBox();
        playerChooser.setAlignment(Pos.CENTER);
        playerChooser.setPadding(new Insets(10,10,10,10));
        
        tradeWindow = new HBox();

        scene1 = new Scene(playerChooser, 450, 100);
        scene2 = new Scene(tradeWindow, 700, 800);

        HBox tradePartners = new HBox();
        tradePartners.setAlignment(Pos.CENTER);
        tradePartners.setPadding(new Insets(10,10,10,10));

        Button go1 = new Button();
        Button go2 = new Button();
        Button go3 = new Button();
        go1.setText("Trade with Player1");
        go2.setText("Trade with Player2");//change to alter dynamically
        go3.setText("Trade with Player3");
        
        players = Facade.getBanker().updateCurrentPlayerOrder();
        
        go1.setOnAction(e -> {
        	buildTradeScene(players[1]);
        	primaryStage.setScene(scene2);
        });

        switch (Facade.getPlayerList().length) {
        case 2:
        	go1.setMinWidth(250);
        	playerChooser.getChildren().addAll(go1);
        	break;
        case 3:
        	go1.setMinWidth(120);
        	go2.setMinWidth(120);
        	go2.setOnAction(e -> {
            	buildTradeScene(players[2]);
            	primaryStage.setScene(scene2);
            });
        	playerChooser.getChildren().addAll(go1,go2);
        	break;
        case 4:
        	go1.setMinWidth(80);
        	go2.setMinWidth(80);
        	go3.setMinWidth(80);
        	go2.setOnAction(e -> {
            	buildTradeScene(players[2]);
            	primaryStage.setScene(scene2);
            });
            go3.setOnAction(e -> {
            	buildTradeScene(players[3]);
            	primaryStage.setScene(scene2);
            });
        	playerChooser.getChildren().addAll(go1,go2,go3);
        	break;

        default:
        	break;
        }
        
        VBox choiceWindow = new VBox();
       choiceWindow.getChildren().addAll(new Label("Select the player with whom you wish to Trade"),tradePartners);
       choiceWindow.setAlignment(Pos.CENTER);
       
        window.setScene(scene1);
        window.show();
    }
    private Player p1 = Facade.getBanker().getCurrentPlayer();
    private Player p2;
    private Player temp1;
    private Player temp2;
    
    private PropertyCardList pcList1;
    private PropertyCardList pcList2;
	
    private PropertyCardList pcList1Confirm;
    private PropertyCardList pcList2Confirm;
    
    private void buildTradeScene(Player p2) {
    	this.p2 = p2;
    	
		pcList1 = new PropertyCardList(p1);
		pcList2 = new PropertyCardList(p2);
		
		pcList1Confirm = new PropertyCardList(temp1);
		pcList2Confirm = new PropertyCardList(temp2);
		
		Button addProp1 = new Button("Add");
		addProp1.setMinWidth(300);
		addProp1.setOnAction(e -> addToExchangeP1( pcList1.getListView().getSelectionModel().getSelectedIndex()));
		Button removeProp1 = new Button("Remove");	//Tader's
		removeProp1.setMinWidth(300);
		removeProp1.setOnAction(e -> removeFromExchangeP1(pcList1Confirm.getListView().getSelectionModel().getSelectedIndex()));
		
		Button addProp2 = new Button("Add");
		addProp2.setMinWidth(300);
		addProp2.setOnAction(e -> addToExchangeP2( pcList2.getListView().getSelectionModel().getSelectedIndex()));
		Button removeProp2 = new Button("Remove");	//Trady's
		removeProp2.setMinWidth(300);
		removeProp2.setOnAction(e -> removeFromExchangeP2(pcList2Confirm.getListView().getSelectionModel().getSelectedIndex()));
		
		VBox setUp = new VBox();
		setUp.setAlignment(Pos.CENTER);
		setUp.setPadding(new Insets(10,10,10,10));
		setUp.getChildren().addAll(pcList1,addProp1,pcList1Confirm,removeProp1);
		
		VBox setUp2 = new VBox();
		setUp2.setAlignment(Pos.CENTER);
		setUp2.setPadding(new Insets(10,10,10,10));
		setUp2.getChildren().addAll(pcList2,addProp2,pcList2Confirm,removeProp2);
		
		HBox setUpAll = new HBox();
		setUpAll.setAlignment(Pos.CENTER);
		setUpAll.getChildren().addAll(setUp,setUp2);
		
		Button confirmTrade = new Button("Confirm Trade");
		confirmTrade.setMinWidth(620);
		confirmTrade.setOnAction(e -> confirmTrade());
		
		VBox completeSetUp = new VBox();
		completeSetUp.getChildren().addAll(setUpAll,confirmTrade);
		
    	tradeWindow.getChildren().add(completeSetUp);
    }
    
    private void initTempPlayers() {
    	
    	temp1 = new Player(Facade.getBanker(), "Temp1", 50, "");
    	temp2 = new Player(Facade.getBanker(), "Temp2", 60, "");
    	
    }
    
    private void moveProp(Player p1, Player p2,int i) {
    	if(i>=0) {
    		System.out.println(i);
    		PropertySpace ps = p1.getProperty(i);
    		p2.aquireProperty(ps);
    		p1.removeProperty(i);
    	}
    }

    private void addToExchangeP1( int i) {
    	moveProp(p1 ,temp1, i);
    	updateAll();
    }
    
    private void removeFromExchangeP1( int i) {
    	moveProp(temp1 ,p1, i);
    	updateAll();
    }
    
    private void addToExchangeP2( int i) {
    	moveProp(p2 ,temp2, i);
    	updateAll();
    }
    
    private void removeFromExchangeP2(int i) {
    	moveProp(temp2 ,p2, i);
    	updateAll();
    }
    
    private void confirmTrade() {
    	while(!temp1.getOwnedProperties().isEmpty()) {
    		moveProp(temp1, p2, 0);
    	}
    	while(!temp2.getOwnedProperties().isEmpty()) {
    		moveProp(temp2, p1, 0);
    	}
    	updateAll();
    	Facade.getBanker().getGUI().updatePlayerPanel();
    }
    
    private void updateAll() {
    	pcList1.updateList();
    	pcList1Confirm.updateList();
    	while(!tradeWindow.getChildren().isEmpty()) {
    		tradeWindow.getChildren().remove(0);
    	}
    	buildTradeScene(p2);
    	window.setScene(scene2);
    }
}