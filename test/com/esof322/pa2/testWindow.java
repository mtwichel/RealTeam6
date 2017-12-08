package com.esof322.pa2;

import static org.junit.Assert.assertTrue;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.Test;

import com.esof322.pa2.gui.MainWindow;

import javafx.application.Application;

public class testWindow extends MainWindow{

	private volatile boolean success = false;
	
	//Tests if the program launches
	@Test
    public void testMain() {
        Thread thread = new Thread() { // Wrapper thread.
            @Override
            public void run() {
                try {
                    Application.launch(testWindow.class); // Run JavaFX application.
                    success = true;
                } catch(Throwable t) {
                    if(t.getCause() != null && t.getCause().getClass().equals(InterruptedException.class)) {
                        // We expect to get this exception since we interrupted
                        // the JavaFX application.
                        success = true;
                        return;
                    }
                    
                    Logger.getLogger(testWindow.class.getName()).log(Level.SEVERE, null, t);
                }
            }
        };
        thread.setDaemon(true);
        thread.start();
        try {
            Thread.sleep(3000);  // Wait for 3 seconds before interrupting JavaFX application
        } catch(InterruptedException ex) {
            // We don't care if we wake up early.
        }
        thread.interrupt();
        try {
            thread.join(1); // Wait 1 second for our wrapper thread to finish.
        } catch(InterruptedException ex) {
            // We don't care if we wake up early.
        }
        assertTrue(success);
    }
}
