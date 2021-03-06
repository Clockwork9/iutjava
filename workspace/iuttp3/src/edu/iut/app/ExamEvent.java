package edu.iut.app;

import java.util.ArrayList;
import java.util.Date;

public class ExamEvent {
	
	/** EX2: FAITE LES ACCESSEURS DES ATTRIBUTS, AJOUTER DES ATTRIBUT ? **/
	protected Date examDate;
	protected Person student;
	protected ArrayList<Person> jury;
	protected Classroom classroom;
	protected ArrayList<Document> documents;
	
	/**
	 * Constructeur par d�faut d'un ExamEvent. 
	 */
	public ExamEvent() {
		this.examDate = null ; 
		this.student = null ; 
		this.jury = null ; 
		this.classroom = null ; 
		this.documents = null ; 
	}
	
	/**
	 * Cr�e un objet ExamEvent dont les attributs sont initialis�s par les variables pass�s en param�tre. 
	 * 
	 * @param	date	la date de l'examen
	 * @param	person	l'�tudiant
	 * @param	jury	les membres du jury
	 * @param	classRoom	la salle dans laquelle l'examen aura lieu
	 * @param	document	les documents li�s � cet examen
	 */
	public ExamEvent(Date date, Person person, ArrayList<Person> jury, Classroom classRoom, ArrayList<Document> document) {
		this.examDate = date ; 
		this.student = person ; 
		this.jury = jury ; 
		this.classroom = classRoom ; 
		this.documents = document ; 
	}

	/**
	 * @return	la date de l'examen
	 */
	public Date getExamDate() {
		return examDate;
	}

	/**
	 * @return	l'�tudiant dont l'examen concerne
	 */
	public Person getStudent() {
		return student;
	}

	/**
	 * @return	la liste des jurys qui seront pr�sents � l'examen
	 */
	public ArrayList<Person> getJury() {
		return jury;
	}

	/**
	 * @return	la salle dans laquelle l'examen aura lieu
	 */
	public Classroom getClassroom() {
		return classroom;
	}

	/**
	 * @return	la liste des documents li�s � l'examen
	 */
	public ArrayList<Document> getDocuments() {
		return documents;
	}
	 
}
