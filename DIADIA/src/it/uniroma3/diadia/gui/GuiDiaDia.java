package it.uniroma3.diadia.gui;



import it.uniroma3.diadia.Partita;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GuiDiaDia extends Application{

	/*FONDAMENTALE
	 * pannello di gioco è 500x500
	 * gli oggetti sono di 50x50
	 * gli oggetti sono distanziati fra loro di 100 x una migliore visione
	 * giocatore colore blu
	 * stanza colore rossa
	 * se giocatore è in una stanza diventa arancione
	 * 
	 * */
	private Stage window;
	private Sprite player;
	
	
	
	
	@Override
	public void start(Stage stage) throws Exception {
		window = stage;
		player = CaricatoreScena.getPlayer();
		Scene scene = CaricatoreScena.impostaScena1(window);
		
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
				window.close();
				break;
			default:
				break;
			
			
			}
			
			
		});
		
		
		
		window.setTitle("DIADIA");
		window.setScene(scene);
		window.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
