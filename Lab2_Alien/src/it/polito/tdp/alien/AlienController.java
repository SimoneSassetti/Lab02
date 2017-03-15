package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	
	AlienDictionary ad;
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
    @FXML
    private Button btnCerca;
    @FXML
    private TextField txtCerca;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	ad=new AlienDictionary();

    }
  
    private String parolaAliena;
    private String traduzione;
    
    
    @FXML
    void doTranslate(ActionEvent event) {
    	String testo=txtWord.getText();
    	String array[]=testo.split(" ");
    	
    	if(array.length>=2){
    		parolaAliena=array[0];
    		traduzione=array[1];
    		if(parolaAliena.matches("[a-zA-Z]+") && traduzione.matches("[a-zA-Z]+")){
    			parolaAliena=parolaAliena.toLowerCase();
    			traduzione=traduzione.toLowerCase();
    			ad.addWord(parolaAliena, traduzione);
    		}
    		else{
    			txtResult.appendText("Attenzione! E' stato inserito un numero.\n");
    		}
    		
    	}
    	if(array.length==1 && array[0].compareTo("")!=0){
    		parolaAliena=array[0];
    		if(parolaAliena.matches("[a-zA-Z]+")){
    			parolaAliena=parolaAliena.toLowerCase();
    			txtResult.appendText("Traduzione/i:\n"+ad.translateWord(parolaAliena)+"\n");
    		}
    		else{
    			txtResult.appendText("Attenzione! E' stato inserito un numero.\n");
    		}
    	}
    	txtWord.clear();
    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    }
    
    @FXML
    void doCerca(ActionEvent event) {
    	String cerca=txtCerca.getText().toLowerCase();
    	String array[]=cerca.split("\\?");
    	char l='a';
    	String s="";
    	String temp="";
    	boolean trovato=false;
    	
    	txtResult.appendText("Risultati della ricerca:\n");
    	if(array.length==1 && array[0].matches("[a-zA-Z]+")){
    		for(int i=0; i<26 && !trovato; i++){
    			s=array[0];
    			temp=ad.ricercaParola(s);
    			trovato=true;
    		}
    		txtResult.appendText(temp);
    		return;
    	}else if(array.length==2 && array[0].matches("[a-zA-Z]+") && array[1].matches("[a-zA-Z]+")){
    		for(int i=0; i<26 && !trovato; i++){
    			String carattere=Character.toString((char) (l+i));
    			s=""+array[0]+carattere+array[1];
    			temp=ad.ricercaParola(s);
    			trovato=true;
    		}
    		txtResult.appendText(temp);
    	}
    	else{
    		txtResult.appendText("Parola non trovata!");
    	}
    	txtCerca.clear();
    } 
    
    
    
    
}
