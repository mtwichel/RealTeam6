package com.esof322.pa2.gui;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class Console {
	
	private static final TextArea textArea = new TextArea();
	
	public Console() {
		textArea.setDisable(true);
	}
	
	public TextArea getTextArea() {
		return textArea;
	}
	
	public static void println(String s){
	    Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	            textArea.setText(textArea.getText()+s+"\n");
	            System.out.println(s);
	        }
	    });
	}
}
