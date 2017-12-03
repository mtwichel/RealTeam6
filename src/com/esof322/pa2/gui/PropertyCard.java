package com.esof322.pa2.gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PropertyCard extends HBox{

	private VBox property;
	private Rectangle rect = new Rectangle(20,20,210,30);
	private int position;

	//add another for color?
	public PropertyCard(String labelText, int value, int color, int pos) {
		super();

		position = pos;
		
		//Sets up organization structure of card
		property = new VBox();
		HBox hBox = new HBox();
		VBox card = new VBox();

		Label propertyName = new Label(labelText);
		Label propertyValue = new Label("Value: " + value);

		card.getChildren().addAll(propertyName,propertyValue);

		VBox buttons = new VBox();

		Button info = new Button("Info");
		Button options = new Button("Options");
		info.setMaxSize(75,30);
		options.setMaxSize(75,30);

		buttons.getChildren().addAll(info,options);
		hBox.getChildren().addAll(card,buttons);

		//Replace padding with definitive position on the card.
		card.setPadding(new Insets(10, 50, 0, 0));

		//Temporary control for the properties color   
		setColor(color);

		property.getChildren().addAll(rect,hBox);
		this.getChildren().addAll(property);
	}

	public VBox getProperty() {
		return property;
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
	
	@Override
	public boolean equals(Object object) {
		if(object instanceof PropertyCard) {
			PropertyCard p = (PropertyCard) object;
			return this.position==(p.position);
		}
		return false;
	}

	public int getPos() {
		return position;
	}
}

