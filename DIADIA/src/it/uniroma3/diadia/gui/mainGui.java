package it.uniroma3.diadia.gui;




import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class mainGui extends Application{

	private CaricatoreScena cs = new CaricatoreScena();
	private Scene scenaCorrente;
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// setto lo stage principale
		cs.setStageCorrente(primaryStage);
		
		//carico la scena 1
		scenaCorrente = cs.carica1();
		
		primaryStage.setScene(scenaCorrente);
		
		primaryStage.setTitle("DIADIA");
		primaryStage.show();
		
		
	}
	
}

