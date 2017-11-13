package com.esof322.pa2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.esof322.pa2.exceptions.HousesOnPropertiesException;
import com.esof322.pa2.exceptions.NotEnoughFundsException;
import com.esof322.pa2.exceptions.PropertyMaxUpgratedException;
import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.Board;
import com.esof322.pa2.model.Player;
import com.esof322.pa2.model.PropertyGroup;
import com.esof322.pa2.model.PropertySpace;


public class TestMortgaging {

	private Board board = new Board();
	private PropertyGroup pg = board.getGroups();
	private Player p1 = new Player(3);
	private PropertySpace prop;

	public void init() {
		prop = (PropertySpace) board.getSpace(3);
		//board.getGroups().populateProperties(board);
		p1.aquireProperty(prop);
		p1.aquireProperty((PropertySpace)board.getSpace(32));
		//For checking that they all made it in the list
		System.out.println(p1.getOwnedProperties().size());
	}
	@Test//Tests to see if mortgaging the property works
	public void testMortgage() throws HousesOnPropertiesException {
		init();
		
		//Print statements also show the player does get money from mortgaging
		PropertySpace ps = (PropertySpace) p1.getOwnedProperties().get(0);
		System.out.println("Player's property "+ps.getNameSpace()+" is mortgaged:"+ps.isMortgaged()+", Player Balance:"+p1.getBalance()+", Player NetWorth:"+p1.getNetWorth());
		p1.mortgage(prop);
		System.out.println("Player's property "+ps.getNameSpace()+" is mortgaged:"+ps.isMortgaged()+", Player Balance:"+p1.getBalance()+", Player NetWorth:"+p1.getNetWorth());
		
		//checks if the property is mortgagable
		assertTrue("Test Player",prop.isMortgaged());
	}
	
	@Test//This one 
	public void testMonopoly() {
		//Add an entire color set 
		p1.aquireProperty((PropertySpace)board.getSpace(1));
		p1.aquireProperty((PropertySpace)board.getSpace(3));
		
		System.out.println("Before checkMonopoly Player has monopoly: "+p1.getHasMonopoly());//Before method call
		//checks for monopoly and sets pieces accordingly(needs to be called every time something is mortgaged/unmortgaged, as well as purchased/sold
		board.getGroups().checkMonopoly(p1, p1.getProperty(0).getColor());
		System.out.println("After checkMonopoly Player has monopoly: "+p1.getHasMonopoly());//after method call
		assertTrue("Check for monopoly",p1.getProperty(0).getIsMonopoly());
	}

	@Test//If statement prevents exception from occuring for to manny houses
	public void testWithHouses() throws NotEnoughFundsException, PropertyMaxUpgratedException, HousesOnPropertiesException {
		p1.aquireProperty((PropertySpace)board.getSpace(1));
		p1.aquireProperty((PropertySpace)board.getSpace(3));
		p1.upgrade(p1.getProperty(0));
		
		//checks if any of the properties in the group have houses on them before mortgaging
		if(board.getGroups().checkForHouses(p1.getProperty(0).getHouseLevel())) {
			p1.mortgage(p1.getProperty(0));
		}
		assertTrue("Cannot mortgage property:",p1.getProperty(0).isMortgaged());
		assertTrue("Can mortgage property after houses have been removed:",p1.getProperty(0).isMortgaged());
	}
}
