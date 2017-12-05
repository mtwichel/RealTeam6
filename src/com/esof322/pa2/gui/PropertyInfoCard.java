package com.esof322.pa2.gui;

import java.awt.Panel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.PropertyGroup;
import com.esof322.pa2.model.PropertySpace;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.*;
import javafx.geometry.*;

public class PropertyInfoCard extends VBox{

	private Label propertyName;
	private Label title;
	
	private Label rent;
	private Label house1;
	private Label house2;
	private Label house3;
	private Label house4;
	private Label hotel;
	
	private Label mortgageValue;
	private Label houseCost;
	
	private Rectangle rect;
	//(Banker banker, String name, PropertyGroup propertyGroup, 
	//int purchaseAmout, int upgradeAmount,int[] rentRates
	public PropertyInfoCard(PropertySpace ps) {
		this.setMaxWidth(300);
		
		Label title = new Label("TITLE DEED");
		title.setStyle("-fx-font: 10 arial");
		propertyName = new Label(ps.getName());
		propertyName.setStyle("-fx-font: 20 arial");
		
		VBox header = new VBox();
		header.getChildren().addAll(title, propertyName);
		header.setAlignment(Pos.CENTER);
		
		rect = new Rectangle(20,20,300,50);
		setColor(colorToInt(ps.getColor()));
		
		StackPane sp1 = new StackPane();
		sp1.getChildren().addAll(rect,header);
		
		rent = new Label("RENT $"+ps.getRates()[0]);
		//put this block in a VBox for spaceing if time is left for formatting
		house1 = new Label("WITH 1 HOUSE\t\t$"+ps.getRates()[1]);
		house2 = new Label("WITH 2 HOUSES\t\t$"+ps.getRates()[2]);
		house3 = new Label("WITH 3 HOUSES\t\t$"+ps.getRates()[3]);
		house4 = new Label("WITH 4 HOUSES\t\t$"+ps.getRates()[4]);
		
		hotel = new Label("WITH HOTEL $"+ps.getRates()[5]);
		
		VBox rentRates = new VBox();
		rentRates.getChildren().addAll(rent,house1,house2,house3,house4,hotel);
		rentRates.setAlignment(Pos.CENTER);
		rentRates.setPadding(new Insets(10, 0, 15, 0));
		
		mortgageValue = new Label("MORTGAGE VALUE $"+ps.getPurchaseAmount()/2);
		houseCost = new Label("HOUSE COST $"+ps.getUpgradeAmount()+". EACH");
		Label houseCost2 = new Label("HOTELS, $"+ps.getUpgradeAmount()+". PLUS 4 HOUSES");
		
		VBox mort = new VBox();
		mort.setMaxWidth(200);
		mort.getChildren().addAll(mortgageValue,houseCost,houseCost2);
		mort.setAlignment(Pos.CENTER);
		mort.setPadding(new Insets(0, 0, 20, 0));
		
		
		Label monopolyEffect = new Label("IF A PLAYER OWNS ALL THE LOTS OF ANY COLOR-GROUP, THE");
		Label monopolyEffect2 = new Label("RENT IS DOUBLED ON UNIMPROVED LOTS IN THAT GROUP.");
		monopolyEffect.setStyle("-fx-font: 9 arial");
		monopolyEffect2.setStyle("-fx-font: 9 arial");
		
		VBox effect = new VBox();
		effect.setAlignment(Pos.CENTER);
		effect.getChildren().addAll(monopolyEffect,monopolyEffect2);
		
		this.getChildren().addAll(sp1,rentRates,mort,effect);
		this.setAlignment(Pos.CENTER);
	}

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
	
	public void setColor(int i) {
		switch (i) {
		case CLEAR:
			rect.setFill(Color.TRANSPARENT);
			rect.setStroke(Color.TRANSPARENT);
			break;
		case BROWN:
			rect.setFill(Color.rgb(96, 54, 24));
			rect.setStroke(Color.rgb(96, 54, 24));
			break;
		case LIGHT_BLUE:
			rect.setFill(Color.LIGHTBLUE);
			rect.setStroke(Color.LIGHTBLUE);
			break;
		case PINK:
			rect.setFill(Color.PINK);
			rect.setStroke(Color.PINK);
			break;
		case ORANGE:
			rect.setFill(Color.ORANGE);
			rect.setStroke(Color.ORANGE);
			break;
		case RED:
			rect.setFill(Color.RED);
			rect.setStroke(Color.RED);
			break;
		case YELLOW:
			rect.setFill(Color.YELLOW);
			rect.setStroke(Color.YELLOW);
			break;
		case GREEN:
			rect.setFill(Color.GREEN);
			rect.setStroke(Color.GREEN);
			break;
		case DARK_BLUE:
			rect.setFill(Color.DARKBLUE);
			rect.setStroke(Color.DARKBLUE);
			break;

		default:
			rect.setFill(Color.TRANSPARENT);
			rect.setStroke(Color.TRANSPARENT);
			break;
		}
		
	}
}
