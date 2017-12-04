package com.esof322.pa2.gui;
 import javafx.stage.*;
 import javafx.scene.*;
 import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.*;

import com.esof322.pa2.exceptions.GroupUpgradedException;
import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.exceptions.PropertyMaxUpgratedException;
import com.esof322.pa2.exceptions.PropertyMinUpgratedException;
import com.esof322.pa2.model.PropertyGroup;
import com.esof322.pa2.model.PropertySpace;
import com.esof322.pa2.model.Space;

import javafx.geometry.*;
 
public class PropertyDetailsCard {

	private Button mortgage;
	private Button buyHouse;
	private Button sellHouse;
	
	private GridPane houses;
	
	private PropertySpace ps;
	private Boolean monopoly = false;
	
	public PropertyDetailsCard(Space sp) {
		ps = (PropertySpace) sp;
		Display();
	}
	
	public void Display() {
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("");
		window.setMinWidth(350);
		
		buyHouse = new Button("Buy House");
		buyHouse.setMaxSize(100, 30);
		buyHouse.setMinSize(100, 30);
		initBuyHouse();
		
		
		sellHouse = new Button("Sell House");
		sellHouse.setMaxSize(100, 30);
		buyHouse.setMinSize(100, 30);
		initSellHouse();
		
		GridPane pane = new GridPane();
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setVgap(8);
		pane.setHgap(10);
		pane.setConstraints(buyHouse, 0, 0);
		pane.setConstraints(sellHouse, 1, 0);
		pane.getChildren().addAll(buyHouse,sellHouse);
		
		houses = new GridPane();
		houses.setPadding(new Insets(10, 10, 10, 10));
		houses.setVgap(8);
		houses.setHgap(10);
		
		Label h = new Label("Houses:");
		houses.setConstraints(h, 0, 0);
		houses.getChildren().add(h);
		
		initHouses();
		
		//Change Button text to Un-Mortgage when property is mortgaged.
		mortgage = new Button();
		mortgage.setMaxSize(210, 30);
		mortgage.setMinSize(210, 30);
		updateMortgaged();
		//String name, PropertyGroup pg, int purchaseAmount, int upgradeAmount, int[] rentRates
		PropertyInfoCard pic = new PropertyInfoCard(ps.getName(),colorToInt(ps.getColor()),ps.getPurchaseAmount(),ps.getUpgradeAmount(),ps.getRates());
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(houses,pane,mortgage);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();

	}

	private boolean lastAction;

	private void updateHouses() {

		if(ps.getHouseLevel()==5) {
			if(lastAction) {//Bought a house last
				GridPane temp = new GridPane();
				temp.setPadding(new Insets(10, 10, 10, 10));
				temp.setVgap(8);
				temp.setHgap(10);

				Label h = new Label("Houses:");
				temp.setConstraints(h, 0, 0);
				temp.getChildren().add(h);

				Rectangle rect = new Rectangle(20,20,210,30);
				temp.setConstraints(rect, 1, 0);
				temp.getChildren().add(rect);
				houses = temp;
			}else {
				if(lastAction) {//Bought a house last

					Rectangle rect = new Rectangle(20,20,210,30);
					houses.setConstraints(rect, ps.getHouseLevel(), 0);
					houses.getChildren().add(rect);

				}else {//Sold a House Last
					if(ps.getHouseLevel()==4) {//if the last house sold was a hotel
						houses.getChildren().remove(1);
						Rectangle rect = new Rectangle(20,20,20,30);
						for(int i = 1; i<=ps.getHouseLevel();i++) {
							houses.setConstraints(rect, i, 0);
							houses.getChildren().add(rect);
						}
					}else {
						houses.getChildren().remove(ps.getHouseLevel()+1);
					}
				}
			}
		}

	}

	private void initHouses() {
		if(ps.getHouseLevel()==5) {
			Rectangle rect = new Rectangle(20,20,210,30);
			houses.setConstraints(rect, 1, 0);
			houses.getChildren().add(rect);
		}else {
			Rectangle rect = new Rectangle(20,20,20,30);
			for(int i = 1; i<=ps.getHouseLevel();i++) {
				houses.setConstraints(rect, i, 0);
				houses.getChildren().add(rect);
			}
		}
	}

	private void updateMortgaged() {
		if(ps.isMortgaged()) {
			mortgage.setText("Un-Mortgage");
			mortgage.setOnAction(e -> {
				try {
					unMortgageCall();
				} catch (NotEnoughFundsException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		}else {
			mortgage.setText("Mortgage");
			mortgage.setOnAction(e -> {
				try {
					mortgageCall();
				} catch (GroupUpgradedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			});
		}
	}
	
	private void mortgageCall() throws GroupUpgradedException {
		ps.getOwner().mortgage(ps);
	}

	private void unMortgageCall() throws NotEnoughFundsException {
		ps.getOwner().unMortgage(ps);
	}
	
	private void initBuyHouse() {
		if(ps.getHouseLevel()==5) {
			buyHouse.setDisable(true);
		}
		buyHouse.setOnAction(e -> {
			try {
				buyHouse();
			} catch (PropertyMaxUpgratedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	private void updateBuyHouse() {
		if(ps.getHouseLevel()==5) {
			buyHouse.setDisable(true);
			
		}else {
			buyHouse.setDisable(false);
		}
	}
	
	private void buyHouse() throws PropertyMaxUpgratedException {
		ps.upgrade();
		lastAction = true; //bought a house last
		updateBuyHouse();
		updateSellHouse();
		updateHouses();
		
	}
	
	private void initSellHouse() {
		if(ps.getHouseLevel()==0) {
			sellHouse.setDisable(true);
		}
		sellHouse.setOnAction(e -> {
			try {
				sellHouse();
			} catch (PropertyMinUpgratedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}
	
	private void updateSellHouse() {
		if(ps.getHouseLevel()==0) {
			sellHouse.setDisable(true);
		}else {
			sellHouse.setDisable(false);
		}
	}
	private void sellHouse() throws PropertyMinUpgratedException {
		ps.downgrade();
		lastAction = false;//sold a house last
		updateSellHouse();
		updateBuyHouse();
		updateHouses();
	}
	
	/*propertyGroups[0] = new PropertyGroup("89451B");
		propertyGroups[1] = new PropertyGroup("89CEEA");
		propertyGroups[2] = new PropertyGroup("983BC9");
		propertyGroups[3] = new PropertyGroup("FDA429");
		propertyGroups[4] = new PropertyGroup("FC0D1C");
		propertyGroups[5] = new PropertyGroup("FFFD38");
		propertyGroups[6] = new PropertyGroup("0E7E12");
		propertyGroups[7] = new PropertyGroup("0B24FB");*/
	private final int CLEAR = 0, BROWN = 1,LIGHT_BLUE = 2,PINK = 3, ORANGE = 4, RED = 5, YELLOW = 6, GREEN = 7, DARK_BLUE = 8;
	
	private int colorToInt(String s) {
		if(s.equals("89451B")) {
			return BROWN;
		}else if(s.equals("89CEEA")) {
			return LIGHT_BLUE;
		}else if(s.equals("983BC9")) {
			return PINK;
		}else if(s.equals("FDA429")) {
			return ORANGE;
		}else if(s.equals("FC0D1C")) {
			return RED;
		}else if(s.equals("FFFD38")) {
			return YELLOW;
		}else if(s.equals("0E7E12")) {
			return GREEN;
		}else if(s.equals("0B24FB")) {
			return DARK_BLUE;
		}
		return CLEAR;
	}
}