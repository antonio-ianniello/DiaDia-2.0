package it.uniroma3.diadia.gui;




import it.uniroma3.diadia.Partita;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DiaDiaGui extends Application{

	
	private Partita partita;
	private CaricatoreScena cs;
	private Scene scenaCorrente;
	
	public static void main(String[] args) {
		launch();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//inizia partita
		partita = new Partita();
		// setto lo stage principale
		cs = new CaricatoreScena();
		cs.setStageCorrente(primaryStage);
		
		//carico la scena 1
		scenaCorrente = cs.carica1();
		
		primaryStage.setScene(scenaCorrente);
		
		primaryStage.setTitle("DIADIA");
		primaryStage.show();
		
		
	}
	
}

