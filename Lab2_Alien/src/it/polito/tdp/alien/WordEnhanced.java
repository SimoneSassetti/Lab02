package it.polito.tdp.alien;

import java.util.*;

public class WordEnhanced {
	private String alienWord;
	private String translation;
	
	private List<String> traduzioni;
	
	public WordEnhanced(String alienWord, String translation) {
		this.alienWord = alienWord;
		this.translation = translation;
		traduzioni=new LinkedList<String>();
		traduzioni.add(translation);
		
	}
	public String getAlienWord() {
		return alienWord;
	}
	public String getTranslation() {
		return translation;
	}
	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}
	public void setTranslation(String translation) {
		this.translation = translation;
	}
	public void aggiungiTraduzione(String s){
		traduzioni.add(s);
	}
	public String listaTraduzioni(){
		String temp="";
		for(int i=0; i<traduzioni.size(); i++){
			temp+=traduzioni.get(i)+" ";
		}
		return temp;
	}
	
	
	/*public String compare(String alienWord){
		return "";
	}*/
	
}
