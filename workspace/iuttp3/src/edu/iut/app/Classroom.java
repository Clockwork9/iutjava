package edu.iut.app;

public class Classroom {
	
	protected String classRoomNumber;
	
	/**
	 * Constructeur par d�faut d'un Classroom. 
	 */
	public Classroom() {
		classRoomNumber="not affected";
	}
	
	/**
	 * Constructeur prenant une cha�ne en param�tre. 
	 * 
	 * @param	classRoomNumber	la cha�ne indiquant le nom de la salle
	 */
	public Classroom(String classRoomNumber) {
		/* EX2: AFFECTATION */
		this.classRoomNumber = classRoomNumber ; 
	}
	
	/**
	 * Remplace la salle stock�e dans Classroom par la cha�ne pass�e en param�tre. 
	 * 
	 * @param	number	la cha�ne par laquelle la cha�ne contenue dans classRoomNumber sera remplac�e
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
