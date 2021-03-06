package edu.iut.app;

import java.util.LinkedList;

public class Agenda extends LinkedList<ExamEvent> {
	
	/**
	 * Constructeur par d�faut d'un Agenda. 
	 */
	public Agenda() {
		super();
	}
	
	/**
	 * Ajoute un ExamEvent � l'Agenda. 
	 * 
	 * @param	examEvent	 l'objet ExamEvent � ajouter
	 */
	public void addCheckedEvent(ExamEvent examEvent) {
		this.add(examEvent);
	}
	
}
