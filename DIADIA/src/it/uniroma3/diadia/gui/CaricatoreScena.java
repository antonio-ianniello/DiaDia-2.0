package it.uniroma3.diadia.gui;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
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

public class CaricatoreScena {
	
	
	public static Sprite player = new Sprite(200, 450, "player", Color.BLUE);
	

	public static Sprite getPlayer() {
		return player;
	}




	public static Scene impostaScena1(Stage stage) {
		
		Pane schermo = new Pane();
		VBox root = new VBox(6);
		
		//hbox vita
		HBox vitaBox = new HBox();
		Label labVita = new Label("VITA DEL GIOCATORE:  ");
	    Label fildVita = new Label("null");
		

		//hbox stanza corrente
		HBox stanzaBox = new HBox();
		Label labStanza = new Label("STANZA ATTUALMENTE OCCUPATA:  ");
		Label fildStanza = new Label("null");
		
		//hbox chiave
		HBox chiaveBox = new HBox();
		Label labChiave = new Label("CHISSA' SE HO LA CHIAVE.....   ");
		CheckBox checkChiave = new CheckBox();

		//hbox torcia
		HBox torciaBox = new HBox();
		Label labTorcia = new Label("CHISSA' SE HO LA TORCIA.....");
		CheckBox checkTorcia = new CheckBox();

		//Hbox borsa
		HBox borsaBox = new HBox();

		Button buttonBorsa = new Button("Guarda nella Borsa");

		

		//sprite da inserire nel PANE
		//Sprite player = new Sprite(200, 450, "player", Color.BLUE);

		Sprite atrio = new Sprite(200, 150, "stanza", Color.RED);
			
		Sprite biblioteca = new Sprite(200, 50, "stanza", Color.RED);
		
		Sprite n10 = new Sprite(300, 150,"stanza", Color.RED);

		Sprite n18 = new Sprite(100, 150,"stanza", Color.RED);

		Sprite n500 = new Sprite(450, 450, "stanza", Color.RED);
		Sprite n00 = new Sprite(0, 0,  "stanza", Color.RED);

		
			
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
					
			
		
			
			
			//ritorna la scena creata
			//sopra potrei creare tutti metodi per impostare le varie sezioni
			
			Scene bubu = new Scene(root);
			
			
			//imposta il bottone
			buttonBorsa.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent e) {
					//passo alla scena seguente
					
						impostaScena2(stage);
					
				}
			});
			
			return bubu;
		}
	
	
	
	public static Scene impostaScena2(Stage stage) {
		
		
		
		 
		 TextField nameInput;
		 TextField pesoInput;
		
		//creo una vbox,ovvero una colonna di nodi
				//Insets serve per modificare i margini
				VBox elementi = new VBox(5);
				elementi.setPadding(new Insets(10.));
				elementi.setSpacing(10.);
				
				
				
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
				
				
			
				
				box.setPadding(new Insets(10,10,10,10));
				box2.setPadding(new Insets(10,10,10,10));

				box.setSpacing(10);
				box2.setSpacing(10);

				
				
				box2.getChildren().addAll(Aggiungi,Rimuovi,back);
		
				
				elementi.getChildren().add(borsaTitle);
				elementi.getChildren().add(table);
				elementi.getChildren().add(box);
				elementi.getChildren().add(box2);

			
				
				
				//scena,inserisco gli elementi che ci servono
				Scene scene1 = new Scene(elementi);
				
				stage.setScene(scene1);
				
				
				
				
				back.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent e) {
						//passo alla scena seguente
						System.out.print("back");
							impostaScena1(stage);
						
					}
				});
				
				
			return scene1;
	}

	
	

	
	

}
