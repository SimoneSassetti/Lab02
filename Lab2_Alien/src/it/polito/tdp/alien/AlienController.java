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
    			txtResult.appendText("La traduzione e': "+ad.translateWord(parolaAliena)+"\n");
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
    
}
