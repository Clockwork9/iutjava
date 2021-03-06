package edu.iut.gui.widget.agenda;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import edu.iut.app.ApplicationSession;

public class ControlAgendaViewPanel extends JPanel {

	CardLayout agendaViewLayout;
	JPanel contentPane;
	
	/**
	 * Permet � l'utilisateur de cliquer sur un bouton Next, permettant de changer l'affichage de l'application
	 * 
	 * @param	layerLayout	la disposition des �l�ments graphiques dans le panel
	 * @param	contentPane	le panel � afficher
	 */
	public ControlAgendaViewPanel(CardLayout layerLayout, final JPanel contentPane) {
		this.agendaViewLayout = layerLayout;
		this.contentPane = contentPane;
		JButton nextView = new JButton(ApplicationSession.instance().getString("next"));
		nextView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				agendaViewLayout.next(contentPane);				
			}			
		});
		this.add(nextView);
	}
	
}
