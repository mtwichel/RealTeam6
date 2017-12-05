package com.esof322.pa2.gui;

import java.util.ArrayList;
import java.util.List;

import com.esof322.pa2.model.Player;
import com.esof322.pa2.model.PropertySpace;

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


public class PropertyCardList extends BorderPane{


	private List<PropertyCard> list;
	private ListView<PropertyCard> listView;
	
	public PropertyCardList(Player p) {
		
		list = new ArrayList<>();
		if(!p.getOwnedProperties().isEmpty()) {
			toPropertyCardList(p);
		}

		//Actual list
		listView = new ListView<PropertyCard>();
		ObservableList<PropertyCard> myObservableList = FXCollections.observableList(list);
		listView.setItems(myObservableList);

		this.setCenter(listView);
	}
	
	private void toPropertyCardList(Player p){
		List<PropertySpace> temp = p.getOwnedProperties();
		for(PropertySpace x: temp) {
			addPropertyCard(x);
		}
	}
	
	public void addPropertyCard(PropertySpace ps) {
		list.add(new PropertyCard(ps));
		updateList();
	}
	
	public void addPropertyCard(PropertyCard p) {
		if(!p.equals(null))
			list.add(p);
		updateList();
	}

	public void removePropertyCard(PropertyCard p) {
		if(!p.equals(null))
			list.remove(p);
		updateList();
	}
	
	public void updateList() {
		listView = new ListView<PropertyCard>();
		ObservableList<PropertyCard> myObservableList = FXCollections.observableList(list);
		listView.setItems(myObservableList);
		
		this.setCenter(listView);
	}

}