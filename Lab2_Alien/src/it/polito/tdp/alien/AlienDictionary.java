package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private List<WordEnhanced> dizionario;

	public AlienDictionary() {
		dizionario=new LinkedList<WordEnhanced>();
	}
	
	public void addWord(String alienWord, String translation){
		for(int i=0; i<dizionario.size(); i++){
			if(dizionario.get(i).getAlienWord().compareTo(alienWord)==0){
				dizionario.get(i).aggiungiTraduzione(translation);
				return;
			}
		}
		WordEnhanced w=new WordEnhanced(alienWord, translation);
		dizionario.add(w);
	}
	
	public String translateWord(String alienWord){
		for(WordEnhanced w: dizionario){
			if(w.getAlienWord().compareTo(alienWord)==0){
				return w.listaTraduzioni();
			}
		}
		return null;
	}

	public String ricercaParola(String s) {
		String ricerca="";
		for(WordEnhanced w: dizionario){
			if(w.getAlienWord().compareTo(s)==0){
				ricerca+=w.listaTraduzioni()+"\n";
			}
		}
		return ricerca;
		
	}
	
	
}
