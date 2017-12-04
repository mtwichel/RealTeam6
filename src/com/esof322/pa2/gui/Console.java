package com.esof322.pa2.gui;

import javafx.application.Platform;
import javafx.scene.control.TextArea;

public class Console {
	
	private static final TextArea textArea = new TextArea();
	private static int lines = 0;
	
	public Console() {
		textArea.setDisable(true);
		textArea.setPrefSize(500, 100);
		textArea.setMaxSize(500, 100);
	}
	
	public TextArea getTextArea() {
		return textArea;
	}
	
	//Makes the console move lines up when no room is left
	public static void updateConsole() {
		String temp = textArea.getText();
		int endOfLine = temp.indexOf("\n");
		textArea.setText(temp.substring(endOfLine+1));
	}
	
	public static void println(String s){
		lines++;
		if(lines > 4) {
			updateConsole();
		}
	    Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	            textArea.setText(textArea.getText()+s+"\n");
	            System.out.println(s);
	        }
	    });
	}
}
