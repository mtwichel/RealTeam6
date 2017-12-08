package esof322.pa4.Team6.gui;

import esof322.pa4.Team6.model.Banker;
import esof322.pa4.Team6.model.Board;
import esof322.pa4.Team6.model.Player;

public class Facade {
	
	private static Banker banker;
	private static PlayerPanel playerPanel;
	private static OtherPlayersPanel otherPlayersPanel;
	private static String[] playerNames;
	
	public static void initFacade(MainWindow m) {
		banker = new Banker(m, 4);
	}
	
	public static void setNames(String[] s) {
		playerNames = s;
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
