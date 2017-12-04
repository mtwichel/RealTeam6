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
	public PropertyInfoCard(String name, int color, int purchaseAmount, int upgradeAmount, int[] rentRates) {
		Label title = new Label("TITLE DEED");
		title.setStyle("-fx-font: 5 arial");
		rect = new Rectangle(20,20,210,30);
		setColor(color);
		
		StackPane sp1 = new StackPane();
		sp1.getChildren().addAll(rect,title);
		
		propertyName = new Label(name);
		propertyName.setStyle("-fx-font: 13 arial");
		
		StackPane sp2 = new StackPane();
		sp2.getChildren().addAll(rect,propertyName);
		
		rent = new Label("RENT $"+rentRates[0]);
		house1 = new Label("WITH 1 HOUSE\t$"+rentRates[1]);
		house2 = new Label("WITH 2 HOUSES\t$"+rentRates[2]);
		house3 = new Label("WITH 3 HOUSES\t$"+rentRates[3]);
		house4 = new Label("WITH 4 HOUSES\t$"+rentRates[4]);
		hotel = new Label("WITH HOTEL $"+rentRates[5]);
		
		hotel = new Label("MORTGAGE VALUE $"+purchaseAmount/2);
		houseCost = new Label("HOUSE COST $"+upgradeAmount+". EACH HOTELS, $"+upgradeAmount+". PLUS 4 HOUSES");
		houseCost.setWrapText(true);
		
		//FORMAT
		Label monopolyEffect = new Label("IF A PLAYER OWNS ALL THE LOTS OF ANY COLOR-GROUP, THE RENT IS DOUBLED ON UNIMPROVED LOTS IN THAT GROUP.");
		monopolyEffect.setWrapText(true);
		monopolyEffect.setStyle("-fx-font: 5 arial");
		
		this.getChildren().addAll(sp1,sp2);
	}

	private final int CLEAR = 0, BROWN = 1,LIGHT_BLUE = 2,PINK = 3, ORANGE = 4, RED = 5, YELLOW = 6, GREEN = 7, DARK_BLUE = 8;
	
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
