package edu.iut.app;

import java.util.ArrayList;


public class ApplicationLogs extends ArrayList<IApplicationLog> {

	/**
	 * Constructeur vide cr�ant une liste de ApplicationLog. 
	 */
	public ApplicationLogs() {		
	}
	
	/**
	 * Retourne une liste filtr�e de ApplicationLog, la liste de base �tant la classe elle-m�me. 
	 * 
	 * @return	une liste ne contenant plus que des ApplicationErrorLog
	 */
	public ArrayList<IApplicationLog> getErrors() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		for (IApplicationLog a : this) {
			if (a instanceof ApplicationErrorLog) {
				filteredLogs.add(a);
			}
		}
		return filteredLogs;
	}
	
	/**
	 * Retourne une liste filtr�e de ApplicationLog, la liste de base �tant la classe elle-m�me. 
	 * 
	 * @return	une liste ne contenant plus que des ApplicationWarningLog
	 */
	public ArrayList<IApplicationLog> getWarnings() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		for (IApplicationLog a : this) {
			if (a instanceof ApplicationWarningLog) {
				filteredLogs.add(a);
			}
		}
		return filteredLogs;
	}
	
	/**
	 * Retourne une liste filtr�e de ApplicationLog, la liste de base �tant la classe elle-m�me. 
	 * 
	 * @return	une liste ne contenant plus que des ApplicationInfoLog
	 */
	public ArrayList<IApplicationLog> getInfos() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		for (IApplicationLog a : this) {
			if (a instanceof ApplicationInfoLog) {
				filteredLogs.add(a);
			}
		}
		return filteredLogs;
	}
	

}
