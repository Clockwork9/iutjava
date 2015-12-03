package edu.iut.app;

import java.util.ResourceBundle;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationSession {
	
	protected ResourceBundle resourceBundle;
	protected Locale locale;
	protected Logger sessionGuiLogger;
	protected Logger sessionExceptionLogger;
	protected String[] months;
	protected String[] days;


	private static ApplicationSession session = null;
	
	/**
	 * Constructeur par défaut de ApplicationSession. 
	 */
	public ApplicationSession() {
		locale = Locale.getDefault();
		resourceBundle = ResourceBundle.getBundle("edu.iut.resources.strings.res");
		sessionGuiLogger = Logger.getLogger("IUTTrain");
		sessionGuiLogger.setLevel(Level.ALL);
		sessionExceptionLogger = Logger.getLogger("IUTException");
		sessionExceptionLogger.setLevel(Level.ALL);
		
		days = new String[7];
		days[0] = getString("monday"); days[1] =  getString("tuesday"); days[2] =  getString("wednesday");
		days[3] = getString("thursday");   days[4] =  getString("friday"); days[5] =  getString("saturday");
		days[6] = getString("sunday"); 
		
		months = new String[12];
		months[0] = getString("january"); months[1] =  getString("february"); months[2] =  getString("march");
		months[3] = getString("april");   months[4] =  getString("may");      months[5] =  getString("june");
		months[6] = getString("july"); months[7] =  getString("august"); months[8] =  getString("september");
		months[9] = getString("october"); months[10] =  getString("november"); months[11] =  getString("december");
		
		
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
	
	/**
	 * Remplace l'attribut locale de ApplicationSession par la variable locale passée en paramètre. 
	 * 
	 * @param	locale	variable par laquelle sera remplacée l'attribut locale
	 */
	public void setLocale(Locale locale){
		this.locale = locale;
		Locale.setDefault(this.locale);
		resourceBundle=ResourceBundle.getBundle("edu.iut.resources.strings.res");
	}
	
	/**
	 * @return	la clé de ApplicationSession
	 */
	public String getString(String key) {
		return resourceBundle.getString(key);
	}
	
	/**
	 * @return	le tableau de jours de ApplicationSession
	 */
	public String[] getDays() {
		return days;
	}
	
	/**
	 * @return	le tableau de mois de ApplicationSession
	 */
	public String[] getMonths() {
		return months;
	}
	
	
}
