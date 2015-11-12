package edu.iut.app;

import java.util.ArrayList;


public class ApplicationLogs extends ArrayList<IApplicationLog> {

	public ApplicationLogs() {		
	}
	
	public ArrayList<IApplicationLog> getErrors() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		// une boucle à faire ici, penser à utiliser instanceof*
		for (IApplicationLog i : this){
			if (i instanceof ApplicationErrorLog){
				filteredLogs.add(i);
			}
		}
		return filteredLogs;
		
	}
	public ArrayList<IApplicationLog> getWarnings() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		// une boucle à faire ici, penser à utiliser instanceof
		for (IApplicationLog i : this){
			if (i instanceof ApplicationWarningLog){
				filteredLogs.add(i);
				
			}
		}
		return filteredLogs;
	}
	public ArrayList<IApplicationLog> getInfos() {
		ArrayList<IApplicationLog> filteredLogs = new ArrayList<IApplicationLog>();
		// une boucle à faire ici, penser à utiliser instanceof
		for (IApplicationLog i : this){
			if (i instanceof ApplicationLogs){
				filteredLogs.add(i);
			}
		}
		return filteredLogs;
	}
	

}
