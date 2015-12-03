package edu.iut.gui.listeners;

import javax.swing.JOptionPane;

public class ApplicationInfoMessageDialog extends
		AbstractApplicationMessageDialog {

	/**
	 * Ouvre une boîte de dialogue contenant un message. 
	 * 
	 * @param	level	le niveau d'importance du message
	 * @param	message	le message
	 * @see edu.iut.gui.listeners.AbstractApplicationMessageDialog#showMessage(java.lang.String, java.lang.String)
	 */
	@Override
	protected void showMessage(String level, String message) {
		JOptionPane.showMessageDialog(null, message, level, JOptionPane.INFORMATION_MESSAGE, null);
	}
}
