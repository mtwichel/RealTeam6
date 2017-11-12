package com.esof322.pa2;

import static org.junit.Assert.*;

import org.junit.Test;

import com.esof322.pa2.model.JailSpace;
import com.esof322.pa2.model.Player;

public class TestJail {

	private JailSpace jail = new JailSpace("Jail");
	private Player p1 = new Player(3);
	
	@Test
	public void test() {
		//set up
		p1.toJail();
		//Assurance of variables
		System.out.println(p1.getName()+" is in "+jail.getNameSpace()+" and has "+ p1.getBalance()+".");
		System.out.println("It is "+ p1.getJailed() + " that "+p1.getName()+" is in jail");
		//make choice with GUI later, and put it in a loop.
		jail.takeAction(p1);
		assertTrue("Did not get out of Jail", p1.getJailed());;
		System.out.println(p1.getName()+" is in "+jail.getNameSpace()+" and has "+ p1.getBalance()+".");
		System.out.println("It is "+ p1.getJailed() + " that "+p1.getName()+" is in jail");
	}

}
