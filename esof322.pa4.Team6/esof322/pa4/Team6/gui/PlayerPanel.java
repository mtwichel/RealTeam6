package esof322.pa4.Team6.gui;

import java.awt.TextField;

import esof322.pa4.Team6.model.Banker;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class PlayerPanel extends VBox{

	private VBox playerPanel;
	//private ListView<Property> listView;//Chance Type to Property Later
	private ListView<String> listView;
	private PropertyCardList propertyList;// = new PropertyCardList(Facade.getBanker().getCurrentPlayer());
	
	private final int MAX_VALUE = 100;
	
	private Label playerCash;
	private Label playerName;

	public PlayerPanel() {
		Facade.setPlayerPanel(this);
		propertyList = new PropertyCardList(Facade.getBanker().getCurrentPlayer());
		
		//Use below to place things in panels?
		//playerPanel.positionInArea(child, areaX, areaY, areaWidth, areaHeight, areaBaselineOffset, margin, halignment, valignment, isSnapToPixel);/////////////////////
		playerName = new Label(Facade.getBanker().getCurrentPlayer().getName());
		playerName.setStyle("-fx-font: 20 arial");
		playerCash = new Label("Balance: $"+Facade.getBanker().getCurrentPlayer().getBalance());
		playerCash.setStyle("-fx-font: 20 arial");
		
		listView = new ListView<>();
		listView.setPrefSize(250, 400);
		
		
		this.getChildren().addAll(playerName,propertyList,playerCash);
		this.setSpacing(10);
		this.setPadding(new Insets(20,20,20,20));
		this.setAlignment(Pos.CENTER);
	}
	
	public void update() {
		//playerName.setText(Facade.getBanker().getCurrentPlayer().getName());
		//playerCash.setText("Balance: $"+Facade.getBanker().getCurrentPlayer().getBalance());
		//propertyList.updateList();
		this.getChildren().clear();;
		PropertyCardList temp = new PropertyCardList(Facade.getPlayerList()[0]);
		playerName.setText(Facade.getBanker().getCurrentPlayer().getName());
		playerCash.setText("Balance: $"+Facade.getBanker().getCurrentPlayer().getBalance());
		this.getChildren().addAll(playerName,temp,playerCash);
	}

	/*private void populateProperties(String name, int value,int color,int pos) {
		//change to add to list
		propertyList.addPropertyCard(name, value,color,pos);
	}*/
}
