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
	
	
	private Pane schermo = new Pane();
	private VBox root = new VBox(6);
	
	//hbox vita
	private HBox vitaBox = new HBox();
	private Label labVita = new Label("VITA DEL GIOCATORE:  ");
	private Label fildVita = new Label("null");
	

	//hbox stanza corrente
	private HBox stanzaBox = new HBox();
	private Label labStanza = new Label("STANZA ATTUALMENTE OCCUPATA:  ");
	private Label fildStanza = new Label("null");
	
	//hbox chiave
	private HBox chiaveBox = new HBox();
	private Label labChiave = new Label("CHISSA' SE HO LA CHIAVE.....   ");
	private CheckBox checkChiave = new CheckBox();

	//hbox torcia
	private HBox torciaBox = new HBox();
	private Label labTorcia = new Label("CHISSA' SE HO LA TORCIA.....");
	private CheckBox checkTorcia = new CheckBox();

	//Hbox borsa
	private HBox borsaBox = new HBox();

	private Button buttonBorsa = new Button("Guarda nella Borsa");

	

	//sprite da inserire nel PANE
	private Sprite player = new Sprite(200, 450, "player", Color.BLUE);

	private Sprite atrio = new Sprite(200, 150, "stanza", Color.RED);
		
	private Sprite biblioteca = new Sprite(200, 50, "stanza", Color.RED);
	
	private Sprite n10 = new Sprite(300, 150,"stanza", Color.RED);

	private Sprite n18 = new Sprite(100, 150,"stanza", Color.RED);

	private Sprite n500 = new Sprite(450, 450, "stanza", Color.RED);
	private Sprite n00 = new Sprite(0, 0,  "stanza", Color.RED);

	//crea il contesto della scena principale di diadia
	private Parent createContent() {
		
		//imposta proprieta' del Pane
		schermo.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		schermo.setPrefSize(500, 500);
		schermo.setMaxSize(500, 500);
		schermo.setPadding(new Insets(100.));
		//proprieta' nodo iniziale ovvero la vbox
		root.setPrefSize(700, 700);
		root.setPadding(new Insets(10.));
		//vita
		vitaBox.getChildren().addAll(labVita,fildVita);
		vitaBox.setSpacing(10.);
		//stanza
		stanzaBox.getChildren().addAll(labStanza,fildStanza);
		stanzaBox.setSpacing(10.);
		


		//chiave
		chiaveBox.getChildren().addAll(labChiave,checkChiave);
		chiaveBox.setSpacing(10.);
		
		checkChiave.setDisable(true);
		
		//torcia
		torciaBox.getChildren().addAll(labTorcia,checkTorcia);
		torciaBox.setSpacing(10.);
		
		checkTorcia.setDisable(true);
		
		//borsa
		borsaBox.getChildren().addAll(buttonBorsa);
		borsaBox.setSpacing(10.);
		
		//aggiungi tutto al nodo iniziale,ovvero la vbox
				root.getChildren().addAll(schermo,vitaBox,stanzaBox,chiaveBox,torciaBox,borsaBox);
				
				
				
				//aggiungi tutto allo schermo ovvero il PANE
				schermo.getChildren().addAll(player,atrio,n10,n18,biblioteca,n500,n00);
				
		
		
		//imposta il bottone
		buttonBorsa.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e) {
				//passo alla scena seguente
				
					window.setScene(CaricatoreScena.impostaScena2());
				
			}
		});
		
		
		//ritorna la scena creata
		//sopra potrei creare tutti metodi per impostare le varie sezioni
		
		
		return root;
	}
	
	
	@Override
	public void start(Stage stage) throws Exception {
		window = stage;
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
