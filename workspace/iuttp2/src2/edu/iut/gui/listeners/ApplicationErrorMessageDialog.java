package edu.iut.gui.listeners;

import javax.swing.JOptionPane;

public class ApplicationErrorMessageDialog extends
		AbstractApplicationMessageDialog {

	/**
	 * Ouvre une bo�te de dialogue contenant un message d'erreur. 
	 * 
	 * @param	level	le niveau d'importance du message
	 * @param	message	le message
	 * @see edu.iut.gui.listeners.AbstractApplicationMessageDialog#showMessage(java.lang.String, java.lang.String)
	 */
	@Override
	protected void showMessage(String level, String message) {
		JOptionPane.showMessageDialog(null, message, level, JOptionPane.ERROR_MESSAGE, null);
	}

}
