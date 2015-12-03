package edu.iut.app;

public class Classroom {
	
	protected String classRoomNumber;
	
	/**
	 * Constructeur par défaut d'un Classroom. 
	 */
	public Classroom() {
		classRoomNumber="not affected";
	}
	
	/**
	 * Constructeur prenant une chaîne en paramètre. 
	 * 
	 * @param	classRoomNumber	la chaîne indiquant le nom de la salle
	 */
	public Classroom(String classRoomNumber) {
		/* EX2: AFFECTATION */
		this.classRoomNumber = classRoomNumber ; 
	}
	
	/**
	 * Remplace la salle stockée dans Classroom par la chaîne passée en paramètre. 
	 * 
	 * @param	number	la chaîne par laquelle la chaîne contenue dans classRoomNumber sera remplacée
	 */
	public void setClassroomNumber(String number) {
		/* EX2: AFFECTATION */
		this.classRoomNumber = number ; 
	}
	
	/**
	 * @return	le nom de la salle dans Classroom (l'attribut classRoomNumber)
	 */
	public String getClassRoomNumber() {
		return classRoomNumber;
	}
}
