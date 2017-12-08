package com.esof322.pa2.gui;

import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.Board;
import com.esof322.pa2.model.Player;

public class Facade {
	
	private static Banker banker;
	private static PlayerPanel playerPanel;
	private static OtherPlayersPanel otherPlayersPanel;
	private static String[] playerNames;
	private static int gameMode = 0;
	
	public static void initFacade(MainWindow m) {
		new PlayerSetUpWindow();
		banker = new Banker(m, 4);
	}
	
	public static void setNames(String[] s) {
		playerNames = s;
	}
	
	public static void setGameMode(int i) {
		gameMode = i;
	}
	
	public static int getGameMode() {
		return gameMode;
	}
	
	public static String[] getNames() {
		return playerNames;
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
