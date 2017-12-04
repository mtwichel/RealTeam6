package com.esof322.pa2.gui;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class PlayerPropertyListPopUp {

	public PlayerPropertyListPopUp(String s,int playerOrder) {
		display(s,playerOrder);
	}
	public void display(String title, int playerOrder) {
		Stage window = new Stage();
		
		//Can't interact with main window until this one is closed
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(350);

		Label label = new Label();
		label.setText("Player's Properties:");
		
		Button closeButton = new Button("Close window");
		closeButton.setOnAction(e -> window.close());

		PropertyCardList propertyList = new PropertyCardList(Facade.getPlayerList()[playerOrder]);
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, propertyList, closeButton);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();

	}
}