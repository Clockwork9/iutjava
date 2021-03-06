package edu.iut.app;

public class Person {

	protected PersonFunction personFunction;
	protected String firstname;
	protected String lastname;
	protected String email;
	protected String phone;
	
	public enum PersonFunction{
		/* EX2 : Internationalisation */
		NONE(ApplicationSession.instance().getString("none")),
		JURY(ApplicationSession.instance().getString("jury")),
		STUDENT(ApplicationSession.instance().getString("student"));
		
		private String personFunction;
		
		PersonFunction(String personFunction) {
			this.personFunction = personFunction;
		}
		
		public String toString() {
			return personFunction;
		}		
	}
	
	/**
	 * Constructeur par d�faut d'une personne. 
	 */
	public Person() {
		personFunction = PersonFunction.NONE;
	}
	
	/**
	 * Cr�e une personne dont tous les attributs sont initialis�s par les variables pass�es en param�tre. 
	 * 
	 * @param	personFunction	la fonction de la personne (�tudiant, jury, ...)
	 * @param	firstname	le pr�nom de la personne
	 * @param	lastname	le nom de famille de la personne
	 * @param	email	l'adresse �lectronique de la personne
	 * @param 	phone	le num�ro de t�l�phone de la personne
	 */
	public Person(PersonFunction personFunction, String firstname, String lastname, String email, String phone) {
		/* EX2: initialisation */
		this.personFunction = personFunction ; 
		this.firstname = firstname ; 
		this.lastname = lastname ; 
		this.email = email ; 
		this.phone = phone ; 
	}
	
	/**
	 * Red�finit la fonction de la personne par la fonction pass�e en param�tre
	 * 
	 * @param	function	la nouvelle fonction qu'exercera la personne
	 */
	public void setFunction(PersonFunction function) {
		this.personFunction = function;
	}
	
	/**
	 * @return	la fonction qu'exerce la personne
	 */
	public PersonFunction getFunction() {
		return personFunction;
	}
	
	/**
	 * Change le pr�nom de la personne. 
	 * 
	 * @param	firstname	le nouveau pr�nom que portera la personne
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	/**
	 * @return le pr�nom de la personne
	 */
	public String getFirstname() {
		return firstname;
	}
	
	/**
	 * Change le nom de la personne. 
	 * 
	 * @param	lastname	le nouveau nom que portera la personne
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	/**
	 * @return le nom de la personne
	 */
	public String getLastname() {
		return lastname;
	}
	
	/**
	 * Change l'adresse �lectronique de la personne. 
	 * 
	 * @param	email	la nouvelle adresse de la personne
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return l'adresse �lectronique de la personne
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Change le num�ro de t�l�phone de la personne. 
	 * 
	 * @param	phone	le num�ro de t�l�phone de la personne
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * @return	le num�ro de t�l�phone de la personne
	 */
	public String getPhone() {
		return phone;
	}
	

}
