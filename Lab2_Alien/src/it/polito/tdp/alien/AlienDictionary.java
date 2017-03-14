package it.polito.tdp.alien;

import java.util.*;

public class AlienDictionary {
	
	private List<Word> dizionario;

	public AlienDictionary() {
		dizionario=new LinkedList<Word>();
	}
	
	public void addWord(String alienWord, String translation){
		for(int i=0; i<dizionario.size(); i++){
			if(dizionario.get(i).getAlienWord().compareTo(alienWord)==0){
				dizionario.get(i).setTranslation(translation);
				return;
			}
		}
		Word w=new Word(alienWord, translation);
		dizionario.add(w);
	}
	
	public String translateWord(String alienWord){
		for(Word w: dizionario){
			if(w.getAlienWord().compareTo(alienWord)==0){
				return w.getTranslation();
			}
		}
		return null;
	}
	
	
}
