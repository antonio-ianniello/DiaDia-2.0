package it.uniroma3.diadia.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GuiDiaDia extends Application{

	private VBox vbox = new VBox(5);
	private Label label = new Label("Benvenuti nel gioco");
	private Scene scene1;
	
	
	public void Start() {
		this.vbox.getChildren().add(label);
		this.scene1= new Scene(vbox);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		stage.setScene(scene1);
		stage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
