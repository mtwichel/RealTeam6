package com.esof322.pa2.gui;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class PlayerPropertyListPopUp {

	public static void display(String title) {
		Stage window = new Stage();
		
		//Can't interact with main window until this one is closed
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(350);

		Label label = new Label();
		label.setText("Player's Properties:");
		
		Button closeButton = new Button("Close window");
		closeButton.setOnAction(e -> window.close());

		PropertyCardList propertyList = new PropertyCardList();
		//Figure out who's property to load (pass in ID?)
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, propertyList, closeButton);
		layout.setAlignment(Pos.CENTER);

		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.showAndWait();

	}
}