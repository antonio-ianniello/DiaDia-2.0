package it.uniroma3.diadia.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sprite extends Rectangle{

	final String type;
	
	Sprite(int x,int y,int w,int h,String type,Color color){
		super(w,h,color);
		
		
		this.type = type;
		setTranslateX(x);
		setTranslateY(y);
	}
	
	//vorrei che le stanze fossero distanti 5
	void moveLeft() {
		
		setTranslateX(getTranslateX() - 50);
	}
	
	void moveRight() {
		
		setTranslateX(getTranslateX() + 50);
	}
	
	void moveUp() {
		
		setTranslateY(getTranslateY() - 50);
	}

	void moveDown() {
	
	setTranslateY(getTranslateY() + 50);
}
	
}
