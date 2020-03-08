package it.uniroma3.diadia.gui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sprite extends Rectangle{

	final String type;
	private int x;
	private int y;
	
	
	public Sprite(int x,int y,String type,Color color){
		
		//50 e 50 sono altezza e alrghezza del rettangolo
		super(50,50,color);
		this.x=x;
		this.y=y;
		
		this.type = type;
		
		setTranslateX(x);
		setTranslateY(y);
	}
	
	//vorrei che le stanze fossero distanti 5
	void moveLeft() {
		if(this.getX()>=50 && this.getX()<=450)
			System.out.print(this.getX());
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
