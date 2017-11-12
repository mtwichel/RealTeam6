package com.esof322.pa2.model;

public class Facade {

	private Banker banker;
	private Board board;
	private PropertyGroup groups;
	public static Facade f;
	
	public Facade() {
		this.f = this;
	}
	
	public void startGame() {
		board = new Board();
		groups = board.getGroups();
	}
	
	public static void main(String[]args) {
		Facade f = new Facade();
		f.startGame();
	}
	
	public Board getBoard() {
		return board;
	}
	
}
