package esof322.pa4.Team6.Tests;

import static org.junit.Assert.*;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.esof322.pa2.exceptions.BankruptcyException;
import com.esof322.pa2.gui.Console;
import com.esof322.pa2.gui.Facade;
import com.esof322.pa2.gui.MainWindow;
import com.esof322.pa2.model.Banker;
import com.esof322.pa2.model.Player;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.stage.Stage;

public class BankruptcyTest extends MainWindow{
	
	private Banker banker;
	private boolean doesBankrupt = false;
	

	
	@Test
    public void testBool() {
		banker = setUpGame();
        
		Player p1 = banker.getPlayer(0);
		
		assertTrue("Player is not bankrupt",!p1.isBankrupt());
		
		p1.setBankrupt();
		
		assertTrue("Player 1 is bankrupt", p1.isBankrupt());
    }
 
    @Test
    public void testLossOfProperty() {
    	banker = setUpGame();
    	
    	Player p1 = banker.getPlayer(0);
    	
    	p1.aquireProperty((banker.getBoard().getSpace(5)).getSpace());
 
    	assertEquals("Player has a property",1, p1.getOwnedProperties().size());
    	
    	p1.bankrupt();//Need to move around window for this to work
    	
    	assertEquals("Player has lost all property",0, p1.getOwnedProperties().size());

    }
 
    
	@Test(expected=BankruptcyException.class)
	public void testBankruptcyException() throws BankruptcyException {
		
	}
	

	public Banker setUpGame() {
		Banker banker = new  Banker(null, 2);
		banker.setUpPlayers();
		
		return banker;
	}

}
