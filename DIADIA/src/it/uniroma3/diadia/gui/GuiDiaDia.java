package it.uniroma3.diadia.gui;



import it.uniroma3.diadia.Partita;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

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
	
	private Pane schermo = new Pane();
	private VBox root = new VBox(5);
	
	//hbox vita
	private HBox vitaBox = new HBox();
	private Label labVita = new Label("VITA DEL GIOCATORE:  ");
	private Label fildVita = new Label("null");

	//hbox stanza corrente
	private HBox stanzaBox = new HBox();
	private Label labStanza = new Label("STANZA ATTUALMENTE OCCUPATA:  ");
	private Label fildStanza = new Label("null");
	

	

	
	private Sprite player = new Sprite(200, 450, 50, 50, "player", Color.BLUE);

	private Sprite atrio = new Sprite(200, 150, 50, 50, "stanza", Color.RED);
		
	private Sprite biblioteca = new Sprite(200, 50, 50, 50, "stanza", Color.RED);
	
	private Sprite n10 = new Sprite(300, 150, 50, 50, "stanza", Color.RED);

	private Sprite n18 = new Sprite(100, 150, 50, 50, "stanza", Color.RED);

	private Sprite n500 = new Sprite(450, 450, 50, 50, "stanza", Color.RED);
	private Sprite n00 = new Sprite(0, 0, 50, 50, "stanza", Color.RED);

	
	private Parent createContent() {
		
		
		schermo.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		schermo.setPrefSize(500, 500);
		schermo.setMaxSize(500, 500);
		schermo.setPadding(new Insets(100.));
		
		root.setPrefSize(700, 700);
		root.setPadding(new Insets(10.));
		
		vitaBox.getChildren().addAll(labVita,fildVita);
		vitaBox.setSpacing(10.);
		
		stanzaBox.getChildren().addAll(labStanza,fildStanza);
		stanzaBox.setSpacing(10.);

		
		root.getChildren().addAll(schermo,vitaBox,stanzaBox);
		
		
		
		
		schermo.getChildren().addAll(player,atrio,n10,n18,biblioteca,n500,n00);
		
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
