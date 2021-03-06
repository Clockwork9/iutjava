package edu.iut.app;

public class Document {
	
	/**
	 * Constructeur par d�faut d'un Document. 
	 */
	public Document() {
		documentURI="";
	}
	
	/**
	 * Constructeur permettant d'initialiser l'attribut documentURI de Doccument avec le nom d'un document pass� en param�tre. 
	 * 
	 * @param	documentURI le nom du document	
	 */
	public Document(String documentURI) {
		/* EX2 : Affectation */
		this.documentURI = documentURI ; 
	}
	
	/**
	 * Remplace le nom du document stock� dans Document par le nom pass� en param�tre. 
	 * 
	 * @param	number	le nom du nouveau document
	 */
	public void setDocumentURI(String number) {
		this.documentURI = number;
	}
	
	/**
	 * @return	le nom du document stock�
	 */
	public String getDocumentURI() {
		return documentURI;
	}
	
	protected String documentURI;
}
