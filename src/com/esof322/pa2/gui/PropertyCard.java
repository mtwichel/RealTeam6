package com.esof322.pa2.gui;

import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.Board;
import com.esof322.pa2.model.PropertySpace;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PropertyCard extends VBox{

	private GridPane property;
	private Rectangle rect = new Rectangle(20,20,210,30);
	private PropertySpace ps;

	//add another for color?
	public PropertyCard(PropertySpace sp) {
		super();
		ps = sp;
		//Sets up organization structure of card
		property = new GridPane();
		property.setPadding(new Insets(10, 100, 10, 0));
		property.setVgap(8);
		property.setHgap(100);
		
		Label propertyName = new Label(""+ps.getName());
		Label propertyValue = new Label("Value: " + ps.getPurchaseAmount());
		//property.setConstraints(propertyName, 0, 0);
		property.setConstraints(propertyValue, 0, 0);

		Button info = new Button("Info");
		info.setMaxSize(75,30);
		info.setOnAction(e -> openPropertyInfo());

		property.setConstraints(info, 1, 0);
  
		setColor(colorToInt(ps.getColor()));
		property.getChildren().addAll(propertyValue,info);
		this.getChildren().addAll(rect,propertyName,property);
	}

	private void openPropertyInfo() {
		
		new PropertyDetailsCard(ps);
		
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

