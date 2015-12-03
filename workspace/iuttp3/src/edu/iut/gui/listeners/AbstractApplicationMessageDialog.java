package edu.iut.gui.listeners;

import edu.iut.app.IApplicationLogListener;

public abstract class AbstractApplicationMessageDialog implements
		IApplicationLogListener {

	/**
	 * Crée un nouveau message. 
	 * 
	 * @param	level	le niveau d'importance du message
	 * @param	message	le message
	 * @see edu.iut.app.IApplicationLogListener#newMessage(java.lang.String, java.lang.String)
	 */
	@Override
	public void newMessage(String level, String message) {
	 showMessage(level, message);

	}
	
	/**
	 * Affiche un message. 
	 */
	protected abstract void showMessage(String level, String message);

}
