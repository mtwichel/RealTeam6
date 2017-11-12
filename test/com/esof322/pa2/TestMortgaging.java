package com.esof322.pa2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.esof322.pa2.exceptions.HousesOnPropertiesException;
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
		p1.aquireProperty((PropertySpace)board.getSpace(3));
	}
	@Test//Tests to see if mortgaging the property works
	public void test() throws HousesOnPropertiesException {
		init();
		
		PropertySpace ps = (PropertySpace) p1.getOwnedProperties().get(0);
		System.out.println("Player's property "+ps.getNameSpace()+" is mortgaged:"+ps.isMortgaged());
		p1.mortgage(prop);
		//checks if the property is mortgagable
		assertTrue("Test Player",prop.isMortgaged());
	}

}
