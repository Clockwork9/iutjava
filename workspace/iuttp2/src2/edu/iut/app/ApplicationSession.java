package edu.iut.app;

import java.util.ResourceBundle;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationSession {
	
	// Exercice 1 : GÃ©rer l'internationation
	protected ResourceBundle resourceBundle;
	protected Locale locale;
	
	// Exercice 2 : Logger
	protected Logger sessionGuiLogger;
	protected Logger sessionExceptionLogger;


	private static ApplicationSession session = null;
	
	/**
	 * Constructeur par défaut de ApplicationSession. 
	 */
	public ApplicationSession() {
		/* Definir US comme locale par dÃ©faut */
		Locale.setDefault(Locale.US) ; 
		
		locale = Locale.getDefault();
		resourceBundle = ResourceBundle.getBundle("edu.iut.resources.strings.res", locale) ; 
		sessionGuiLogger = Logger.getLogger("GUILogger") ; 
		sessionGuiLogger.setLevel(Level.ALL);
		sessionExceptionLogger = Logger.getLogger("ExceptionLogger") ; 
		sessionExceptionLogger.setLevel(Level.ALL);
	}
	
	/**
	 * Retourne la session de la classe. Si l'attribut session n'est pas initialisée, elle est initialisée par une nouvelle instance ApplicationSession avant d'être retournée. 
	 * 
	 * @return	la session d'ApplicationSession
	 */
	static public ApplicationSession instance() {
		if (session == null) {			
			session = new ApplicationSession();
		}
		return session;
	}
	
	/**
	 * @return	l'attribut sessionGuiLogger de ApplicationSession
	 */
	public Logger getGUILogger() {
		return sessionGuiLogger;
	}
	
	/**
	 * @return	l'attribut sessionExceptionLogger de ApplicationSession
	 */
	public Logger getExceptionLogger() {
		return sessionExceptionLogger;
	}
	
	/*
	 * Remplace l'attribut locale de ApplicationSession par la variable locale passée en paramètre. 
	 * 
	 * @param	locale	variable par laquelle sera remplacée l'attribut locale
	 */
	public void setLocale(Locale locale){
		this.locale = locale;
		Locale.setDefault(this.locale);
		resourceBundle=ResourceBundle.getBundle("edu.iut.resources.strings.res") ; 
	}
	
	/**
	 * @return	la clé de ApplicationSession
	 */
	public String getString(String key) {
		return resourceBundle.getString(key);
	}
	
	
}
