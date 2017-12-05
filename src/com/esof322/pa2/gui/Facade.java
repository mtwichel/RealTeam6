package com.esof322.pa2.gui;

import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.Board;
import com.esof322.pa2.model.Player;

public class Facade {
	
	private static Banker banker;
	private static PlayerPanel playerPanel;
	private static OtherPlayersPanel otherPlayersPanel;
	
	public static void initFacade(MainWindow m) {
		banker = new Banker(m, 4);
	}
	
	public static Banker getBanker() {
		return banker;
	}
	
	public static Player[] getPlayerList() {
		return banker.updateCurrentPlayerOrder();
	}
	
	public static void updatePlayerPanels() {
		otherPlayersPanel.update();
		playerPanel.update();
		
	}
	
	public static void setPlayerPanel(PlayerPanel p) {playerPanel = p;}
	public static void setOtherPlayerPanel(OtherPlayersPanel p) {otherPlayersPanel = p;}
}
