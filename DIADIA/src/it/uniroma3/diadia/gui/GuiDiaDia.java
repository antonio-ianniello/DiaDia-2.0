package it.uniroma3.diadia.gui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GuiDiaDia extends Application{

	private Pane root = new Pane();
	
	private Sprite player = new Sprite(300, 750, 40, 40, "player", Color.BLUE);

	
		

	private Parent createContent() {
		
		root.setPrefSize(600, 800);
		
		root.getChildren().add(player);
		
		return root;
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		
		Scene scene = new Scene(createContent());
		
		scene.setOnKeyPressed(e ->{
			
			switch (e.getCode()) {
			
			case A:
				player.moveLeft();
				break;
				
			case D:
				player.moveRight();
				break;
				
			case W:
				player.moveUp();
				break;
			case S:
				player.moveDown();
				break;
			case ESCAPE:
				break;
			default:
				break;
			
			
			}
			
			
		});
		
		
		
		stage.setTitle("DIADIA");
		stage.setScene(scene);
		stage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
