package edu.iut.app;

import java.util.ArrayList;

public abstract class AbstractApplicationLog implements IApplicationLog {

	protected String message;
	protected ArrayList<IApplicationLogListener> listeners;
	
	/**
	 * Constructeur par d�faut d'un ApplicationLog. 
	 */
	public AbstractApplicationLog() {
		message = null;
		listeners = new ArrayList<IApplicationLogListener>();
	}
	
	/**
	 * Remplace le message de ApplicationLog par la cha�ne pass�e en param�tre. 
	 * 
	 * @param	message	la cha�ne de caract�re qui remplacera le contenu de l'attribut message
	 * @see		edu.iut.app.IApplicationLog#setMessage(java.lang.String)
	 */
	@Override
	public abstract void setMessage(String message);

	/**
	 * Retourne la cha�ne stock�e � l'int�rieur de l'attribut message de ApplicationLog. 
	 * 
	 * @return	le message de ApplicationLog
	 * @see edu.iut.app.IApplicationLog#getMessage()
	 */
	@Override
	public String getMessage() {
		return message;
	}

	/**
	 * Ajoute un listener � la liste de listeners de ApplicationLog. 
	 * 
	 * @param	listener	le listener � ajouter
	 * @see edu.iut.app.IApplicationLog#addListener(edu.iut.app.IApplicationLogListener)
	 */
	@Override
	public void addListener(IApplicationLogListener listener) {
		listeners.add(listener);

	}
	
	/**
	 * Retourne la liste de listeners de ApplicationLog. 
	 * 
	 * @see edu.iut.app.IApplicationLog#getApplicationLogListeners()
	 */
	@Override
	public IApplicationLogListener[] getApplicationLogListeners() {
		return (IApplicationLogListener[])listeners.toArray();
	}
	
	/**
	 * Cr�e un nouveau message pour chaque listeners de la liste dans ApplicationLog. 
	 * 
	 * @param	level	le niveau d'importance du message
	 * @param	message	le message � attribuer au listener
	 */
	protected void fireMessage(String level, String message) {
		for (IApplicationLogListener listener_i : listeners) {
			listener_i.newMessage(level, message);
		}
	}
}
