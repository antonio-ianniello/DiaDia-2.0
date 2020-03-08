package it.uniroma3.diadia.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sprite extends Rectangle{

	final String type;
	
	
	public Sprite(int x,int y,String type,Color color){
		
		//50 e 50 sono altezza e alrghezza del rettangolo
		super(50,50,color);
		
		
		this.type = type;
		
		setTranslateX(x);
		setTranslateY(y);
	}
	
	//vorrei che le stanze fossero distanti 5
	void moveLeft() {
		if(getTranslateX()>= 50.)
			
		setTranslateX(getTranslateX() - 50);
	}
	
	void moveRight() {
		
		if(getTranslateX()<450)
		setTranslateX(getTranslateX() + 50);
	}
	
	void moveUp() {
		if(getTranslateY()>0)
		setTranslateY(getTranslateY() - 50);
	}

	void moveDown() {
		if(getTranslateY()<450)

	setTranslateY(getTranslateY() + 50);
}
	
}
