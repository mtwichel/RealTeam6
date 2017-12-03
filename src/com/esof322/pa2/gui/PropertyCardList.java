package com.esof322.pa2.gui;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class PropertyCardList{

	private BorderPane layout;
	private List<PropertyCard> list;
	
	public PropertyCardList() {
		layout = new BorderPane();

		list = new ArrayList<>();

		//Actual list
		ListView<PropertyCard> listView = new ListView<PropertyCard>();
		ObservableList<PropertyCard> myObservableList = FXCollections.observableList(list);
		listView.setItems(myObservableList);

		layout.setCenter(listView);
	}
	
	public BorderPane getPropertyCardList() {
		return layout;
	}
	
	//Implement removal method that searches by string and deletes the card
	public void addPropertyCard(String name, int val,int color,int pos) {
		list.add(new PropertyCard(name, val,color,pos));
	}
	
	public void addPropertyCard(PropertyCard p) {
		if(!p.equals(null))
			list.add(p);
	}

	public void removePropertyCard(PropertyCard p) {
		if(!p.equals(null))
			list.remove(p);
	}
	
	public void removePropertyCard(int i) {
			list.remove(this.findPropertyCard(i));
	}

	public PropertyCard findPropertyCard(int pos) {//finds PropertyCard by position #

		for(PropertyCard p: list) {
			if(p.getPos()==pos) {
				return p;
			}
		}
		System.out.println("PropertyCard Not Found.");
		return null;
	}

}