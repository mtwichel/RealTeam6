package com.esof322.pa2.gui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class DiceGui extends Canvas {

	private GraphicsContext context;

	public DiceGui() {
		super(100, 100);
	}

	public void drawCanvas(int faceValue) {
		context = this.getGraphicsContext2D();

		context.setFill(Color.BLACK);
		context.fillRect(0, 0, 99, 99);
		context.setFill(Color.WHITE);
		context.fillRect(2, 2, 95, 95);
		context.setFill(Color.BLACK);

		switch (faceValue) {
		case 1:
			context.fillOval(40, 40, 15, 15);
			break;
		case 2:
			context.fillOval(20, 20, 15, 15);
			context.fillOval(60, 60, 15, 15);
			break;
		case 3:
			context.fillOval(15, 15, 15, 15);
			context.fillOval(40, 40, 15, 15);
			context.fillOval(65, 65, 15, 15);
			break;
		case 4:
			context.fillOval(20, 20, 15, 15);
			context.fillOval(20, 60, 15, 15);
			context.fillOval(60, 60, 15, 15);
			context.fillOval(60, 20, 15, 15);
			break;
		case 5:
			context.fillOval(15, 15, 15, 15);
			context.fillOval(15, 65, 15, 15);
			context.fillOval(40, 40, 15, 15);
			context.fillOval(65, 65, 15, 15);
			context.fillOval(65, 15, 15, 15);
			break;
		case 6:
			context.fillOval(20, 20, 15, 15);
			context.fillOval(20, 40, 15, 15);
			context.fillOval(20, 60, 15, 15);
			context.fillOval(60, 20, 15, 15);
			context.fillOval(60, 40, 15, 15);
			context.fillOval(60, 60, 15, 15);
			break;

		}

		this.setStyle("-fx-border-color: black");
	}


}
