package edu.iut.app;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.File;

public class CommandLineParser {
	
	protected HashMap<String, CommandLineOption<?>> options;
	protected ArrayList<String> parseErrors;
		
	/**
	 * Constructeur par d�faut de CommandLineParser. 
	 */
	public CommandLineParser() {
		options = new HashMap<String, CommandLineOption<?> >();
		parseErrors = new ArrayList<String>();
	}
	
	/**
	 * Remplace l'option de CommandLineParser par l'option pass�e en param�tre si elle n'est pas nulle. 
	 * 
	 * @param option	l'option � ajouter
	 */
	public void addOption(CommandLineOption<?> option) {
		if (option != null) {
			options.put(option.getKey(),option);
		}
	}
	
	/**
	 * Permet de lire l'expression r�guli�re pass�e en param�tre et de d�finir l'action en fonction de l'expression. 
	 * 
	 * @param	args	la cha�ne de caract�re contenant l'expression r�guli�re saisie
	 */
	public void parse(String[] args) {
		for (String argument: args) {
			String[] keyValue=argument.split("=");
			if (options.containsKey(keyValue[0])) {
				switch (((CommandLineOption<?>)options.get(keyValue[0])).getOptionType()) {
					case FILE:
						CommandLineOption<File> fileOption = (CommandLineOption<File>)options.get(keyValue[0]);
						if (keyValue.length == 2) {
							fileOption.setValue(new File(keyValue[1]));
						}
						else {
							parseErrors.add("Option should have a key and a value.");
						}
						break;
					case STRING:
						CommandLineOption<String> stringOption = (CommandLineOption<String>)options.get(keyValue[0]) ; 
						if (keyValue.length == 2) {
							stringOption.setValue(new String(keyValue[1])) ; 
						}
						else {
							parseErrors.add("Option should have a key and a value") ; 
						}
						break ;
					case INTEGER:
						CommandLineOption<Integer> intOption = (CommandLineOption<Integer>)options.get(keyValue[0]) ; 
						if (keyValue.length == 2) {
							intOption.setValue(new Integer(keyValue[1])) ; 
						}
						else {
							parseErrors.add("Option should have a key and a value") ; 
						}
						break ; 
					case DOUBLE:
						CommandLineOption<Double> doubleOption = (CommandLineOption<Double>)options.get(keyValue[0]) ; 
						if (keyValue.length == 2) {
							doubleOption.setValue(new Double(keyValue[1])) ; 
						}
						else {
							parseErrors.add("Option should have a key and a value") ; 
						}
						break ; 
					case BOOLEAN:
					case NOVALUE:
						CommandLineOption<Boolean> boolOption = (CommandLineOption<Boolean>)options.get(keyValue[0]) ; 
						if (keyValue.length == 1) {
							boolOption.setValue(true) ; 
						}
						else {
							boolOption.setValue(false) ; 
						}
						break ; 
					case NONE:
						CommandLineOption<Object> objectOption = (CommandLineOption<Object>)options.get(keyValue[0]) ; 
						if (keyValue.length == 1) {
							objectOption.setValue(null) ; 
						}
						else {
							parseErrors.add("Option should only have a key") ; 
						}
						break ; 
					default:
						parseErrors.add("Unrecognize option type.");						
				}
			}
		}
	}
	
	/**
	 * Retourne l'option de CommandLineParser s'il est du type pass� en param�tre, rien sinon. 
	 * 
	 * @param 	key	le type que doit respecter l'option
	 * @return	l'option
	 */
	public CommandLineOption<?> getOption(String key) {
		if (options.containsKey(key)) {
			return options.get(key);
		}
		return null;
	}
	
	/**
	 * @return	une liste de cha�nes contenant toutes les erreurs rencontr�s lors de l'utilisation de la m�thode parse()
	 */
	public ArrayList<String> getErrors() {
		return parseErrors;
	}
	
}
