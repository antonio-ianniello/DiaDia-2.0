package it.uniroma3.diadia.gui;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CaricatoreScena {	
	private GraphicsContext gc;
	private Image imgUser;
	private Image imgRoom;
	private Image imgDoor;
	private int x;
	private int y;
	private double pixelW;
	private int pixelH;

	
	
	public CaricatoreScena() {
		this.imgUser = new Image("uomo.png");
		this.imgRoom = new Image("quadrato.png");
		this.imgDoor = new Image("porta.png");
		
		this.x=200;
		this.y=450;
		this.pixelH=50;
		this.pixelW=50;
	}
	
	
	//dimensioni della scena prinicipale
	private static int wMAX=1000;
	private static int hMAx=700;
	
	//dimensioni di eventuali finestre
	private static int wMiniWindow=300;
	private static int hMiniWindow=200;
	//private Image quadrato = new Imag;
	
	
	private Stage stageCorrente;

	
	public Stage getStageCorrente() {
		return stageCorrente;
	}

	public void setStageCorrente(Stage stageCorrente) {
		this.stageCorrente = stageCorrente;
	}


	//carica scena 1
	public  Scene carica1() {
		
		//oggetto root, hbox che contiene due panel

		HBox root = new HBox();
		
		
		//voglio creare il contorno del canvas
		Pane panel = new Pane();
		panel.setMaxHeight(500.);
		panel.setMaxWidth(500.);
		panel.setPadding(new Insets(10.));
		

		panel.setBorder(new Border(new BorderStroke(Color.BLACK, 
	            BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
		
		
		
		//schermo del gioco, canvas
		Canvas schermo = new Canvas(500,500);
				
		//aggiungo lo schermo al pannello
		panel.getChildren().add(schermo);
		
		
		//contesto grafico
		gc = schermo.getGraphicsContext2D();
		
		drawScene1(gc);
		
	
		
		//adesso voglio creare un panel a fianco dell' altro
		Pane panelTwo = new Pane();
		
		//vbox all' interno del pannello 2
		VBox colonnaUnoDx = new VBox(10);
		colonnaUnoDx.setPadding(new Insets(20.));
		colonnaUnoDx.setMaxHeight(250);
		
		//impsotazioni pannello di destra
		panelTwo.getChildren().add(colonnaUnoDx);
		panelTwo.autosize();
		panelTwo.setPadding(new Insets(10.));

		
		
		//aggiungo alla hbox i due pannelli
		root.getChildren().addAll(panel,panelTwo);
		
		
		//hbox vita
		HBox vitaBox = new HBox();
		Label labVita = new Label("VITA DEL GIOCATORE:  ");
	    Text textVita = new Text("0");
		

		//hbox stanza corrente
		HBox stanzaBox = new HBox();
		Label labStanza = new Label("STANZA ATTUALMENTE OCCUPATA:  ");
		Text textStanza = new Text("atrio");
		
		//hbox chiave
		HBox chiaveBox = new HBox();
		Label labChiave = new Label("CHISSA' SE HO LA CHIAVE.....   ");
		Text checkChiave = new Text("false");

		//hbox torcia
		HBox torciaBox = new HBox();
		Label labTorcia = new Label("CHISSA' SE HO LA TORCIA.....");
		Text checkTorcia = new Text("false");

		//Hbox borsa
		HBox borsaBox = new HBox();
		Button button = new Button("Guarda nella borsa ");
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				System.out.print("Funziono tonriamo alla scena 1\n");
				stageCorrente.setScene(carica2());
				
			}
		});
				
	
		
			

			
			//proprieta' nodo iniziale ovvero la Hbox
		
			root.setPadding(new Insets(10.));
			
			//vita
			vitaBox.getChildren().addAll(labVita,textVita);
			vitaBox.setSpacing(10.);
			
			//stanza
			stanzaBox.getChildren().addAll(labStanza,textStanza);
			stanzaBox.setSpacing(10.);
			

			//chiave
			chiaveBox.getChildren().addAll(labChiave,checkChiave);
			chiaveBox.setSpacing(10.);
			
			//checkChiave.setDisable(true);
			
			//torcia
			torciaBox.getChildren().addAll(labTorcia,checkTorcia);
			torciaBox.setSpacing(10.);
			
			//checkTorcia.setDisable(true);
			
			//borsa
			borsaBox.getChildren().addAll(button);
			borsaBox.setSpacing(10.);
			
			//aggiungi tutto al nodo iniziale,ovvero la vbox
					colonnaUnoDx.getChildren().addAll(vitaBox,stanzaBox,chiaveBox,torciaBox,borsaBox);
					
		//creo la scena ,aggiungendo il nodo root 
		Scene prima = new Scene(root,wMAX,hMAx);
		
		
		return prima;
		
	}
	
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!IMPORTANTE!!!!!!!!!!!!!!!!!!!!!!!!!
	//disegna nel canvas
	//quadrato di 500*500
	//essendo gli oggetti 50*50 xMax e Ymax sono 450 e 450
	private void drawScene1(GraphicsContext gc){
		//TRESTOP PIU' O MENO AL CENTRO, IL PANNELLO DELLO SCHERMO è DI 500*500
		gc.strokeText("Benvenuti in DIA DIA", 170, 10);
		
		//stanza biblioteca fine	
		gc.drawImage(imgRoom, 200, 50,50,50);
		
		//porta sotto la biblioteca
		gc.drawImage(imgDoor, 200, 100,50,50);
		
		//stanza atrio inizio		
		gc.drawImage(imgRoom, 200, 150,50,50);
		
		//porta fra atrio e n18
		gc.drawImage(imgDoor, 150, 150,50,50);
				
		//stanza n18	
		gc.drawImage(imgRoom, 100, 150,50,50);
		
		
		//porta fra atrio e n18
		gc.drawImage(imgDoor, 250, 150,50,50);
		
		//stanza n10		
		gc.drawImage(imgRoom, 300, 150,50,50);

	
		//personaggio x,y,maxW,maxH
		//voorei farlo partire con i seguenti parametri
		// 200, 450,50,50
		gc.drawImage(imgUser,x,y, pixelW, pixelH);
		
		
		
		
		
	}

	
	
	
	
	
	
	//carica scena 2
	public  Scene carica2() {
		
		//oggetto root
		//creo una vbox,ovvero una colonna di nodi
		//Insets serve per modificare i margini
		VBox root = new VBox(5);
		root.setPadding(new Insets(10.));
		root.setSpacing(10.);
		 
		 
	
				//1 elemento
				//creazione label,metto nome e la posiziono al centro
				Label borsaTitle = new Label("Borsa");
				borsaTitle.setAlignment(Pos.CENTER_LEFT);
				

				//colonna nomi
				TableColumn<Attrezzo,String> nomeAttrezzoColonna = new TableColumn<>("nome Attrezzo");
				nomeAttrezzoColonna.setMinWidth(50);//larghezza minima
				nomeAttrezzoColonna.setCellValueFactory(new PropertyValueFactory<Attrezzo,String>("nome"));
				
				
				//colonna pesi
				TableColumn <Attrezzo,Double>pesoAttrezzoColonna = new TableColumn<>("peso Attrezzo");
				pesoAttrezzoColonna.setMinWidth(50);//larghezza minima
				pesoAttrezzoColonna.setCellValueFactory(new PropertyValueFactory<Attrezzo,Double>("peso"));
		
				
				TableView<Attrezzo> table = new TableView();
				
				//da prendereda diadia vecchio
				//table.setItems(getAttre());
				
				table.getColumns().addAll(nomeAttrezzoColonna,pesoAttrezzoColonna);
	
				table.setEditable(true);
				
	
				HBox box = new HBox();
				box.autosize();
				
				
				//textfield 
				TextField nameInput;
				TextField pesoInput;
				
				//name input
				Label label01 = new Label("Nome Attrezzo");
				nameInput = new TextField();
				nameInput.setPromptText("nome");
				nameInput.setMinWidth(100);
				
				
				//peso input
				Label label02 = new Label("Peso Attrezzo");
				pesoInput = new TextField();
				pesoInput.setPromptText("peso");
				pesoInput.setMinWidth(100);
				
				box.getChildren().addAll(label01,nameInput,label02,pesoInput);
				
			
				HBox box2 = new HBox();
				box2.autosize();
			
				//Button
				Button Aggiungi = new Button("Aggiungi");
				
				
				Button Rimuovi = new Button("Rimuovi");
				
				
				Button back = new Button("Back");
				back.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent arg0) {
						System.out.print("Funziono sto cambiando la scena \n");
						stageCorrente.setScene(carica1());
						
					}
				});
						
				
		
				box.setPadding(new Insets(10,10,10,10));
				box2.setPadding(new Insets(10,10,10,10));

				box.setSpacing(10);
				box2.setSpacing(10);

				
				
				box2.getChildren().addAll(Aggiungi,Rimuovi,back);
		
				
				root.getChildren().add(borsaTitle);
				root.getChildren().add(table);
				root.getChildren().add(box);
				root.getChildren().add(box2);

			
		
	
		

	
		
		Scene prima = new Scene(root,wMAX,hMAx);
		
		
		return prima;
		
	}

	

}
