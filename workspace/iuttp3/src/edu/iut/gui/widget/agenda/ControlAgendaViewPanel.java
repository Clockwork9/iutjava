package edu.iut.gui.widget.agenda;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerModel;

import edu.iut.app.ApplicationSession;
import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;
import edu.iut.gui.widget.agenda.WeekPanel.WeekDayNames;

public class ControlAgendaViewPanel extends JPanel {

	CardLayout agendaViewLayout;
	JPanel contentPane;
	
	int selectedYear;
	int selectedMonth;
	int selectedDay;
	
	/**
	 * Permet � l'utilisateur de choisir l'affichage de l'application, en fonction des informations choisies. 
	 * 
	 * @param	layerLayout	la disposition des �l�ments graphiques dans le panel
	 * @param	contentPane	le panel � afficher
	 */
	public ControlAgendaViewPanel(CardLayout layerLayout, final JPanel contentPane) {

		this.agendaViewLayout = layerLayout;
		this.contentPane = contentPane;
		/** EX3: REMPLACEMENT DU BOUTON NEXT */
		
		int years = getYear(); 
		SpinnerNumberModel yearModel = new SpinnerNumberModel(2010, 2010, 2020, 1);
		JSpinner spinner = new JSpinner(yearModel);
		
		DefaultComboBoxModel monthModel = new DefaultComboBoxModel();
		JComboBox CBmonth = new JComboBox(monthModel);
		CBmonth.addItem(new String(ApplicationSession.instance().getString("january")));
		CBmonth.addItem(new String(ApplicationSession.instance().getString("february")));
		CBmonth.addItem(new String(ApplicationSession.instance().getString("march")));
		CBmonth.addItem(new String(ApplicationSession.instance().getString("april")));
		CBmonth.addItem(new String(ApplicationSession.instance().getString("may")));
		CBmonth.addItem(new String(ApplicationSession.instance().getString("june")));
		CBmonth.addItem(new String(ApplicationSession.instance().getString("july")));
		CBmonth.addItem(new String(ApplicationSession.instance().getString("august")));
		CBmonth.addItem(new String(ApplicationSession.instance().getString("september")));
		CBmonth.addItem(new String(ApplicationSession.instance().getString("october")));
		CBmonth.addItem(new String(ApplicationSession.instance().getString("november")));
		CBmonth.addItem(new String(ApplicationSession.instance().getString("december")));

		DefaultComboBoxModel dayModel = new DefaultComboBoxModel();
		JPanel pnlDate = new JPanel();
		JComboBox CBday = new JComboBox(dayModel);
		CBday.addItem(new String(ApplicationSession.instance().getString("monday")));
		CBday.addItem(new String(ApplicationSession.instance().getString("tuesday")));
		CBday.addItem(new String(ApplicationSession.instance().getString("wednesday")));
		CBday.addItem(new String(ApplicationSession.instance().getString("thursday")));
		CBday.addItem(new String(ApplicationSession.instance().getString("friday")));
		CBday.addItem(new String(ApplicationSession.instance().getString("saturday")));
		CBday.addItem(new String(ApplicationSession.instance().getString("sunday")));
		
		
		pnlDate.setLayout(new GridLayout(3,1));
		pnlDate.add(spinner);
		pnlDate.add(CBmonth);
		pnlDate.add(CBday);
		this.add(pnlDate);
	}
	
	public int getYear() {
		return selectedYear;
	}
	public int getMonth() {
		return selectedMonth;
	}
	public int getDay() {
		return selectedDay;
	}
	
}
