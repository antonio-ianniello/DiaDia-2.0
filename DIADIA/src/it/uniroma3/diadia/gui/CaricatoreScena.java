package it.uniroma3.diadia.gui;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CaricatoreScena {
	
	
	
	public static Scene impostaScena2() {
		
		
		
		 TableView<Attrezzo> table;
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
				
			
				
				table = new TableView();
				
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
				
			
				
				box.setPadding(new Insets(10,10,10,10));
				box2.setPadding(new Insets(10,10,10,10));

				box.setSpacing(10);
				box2.setSpacing(10);

				
				
				box2.getChildren().addAll(Aggiungi,Rimuovi);
		
				
				elementi.getChildren().add(borsaTitle);
				elementi.getChildren().add(table);
				elementi.getChildren().add(box);
				elementi.getChildren().add(box2);

			
				
				
				//scena,inserisco gli elementi che ci servono
				Scene scene1 = new Scene(elementi);
				
				return scene1;
				
			
	}

	
	

	
	

}
