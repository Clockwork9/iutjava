package edu.iut.gui.widget.agenda;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import edu.iut.app.ApplicationSession;
import edu.iut.app.Person;
import edu.iut.app.Person.PersonFunction;
import edu.iut.gui.frames.SchedulerFrame;

public class AddPersonPanel extends JPanel {
	
	//LABELS
	private JLabel lPersonFunction = new JLabel(ApplicationSession.instance().getString("personfunction")) ; 
	private JLabel lFirstname = new JLabel(ApplicationSession.instance().getString("firstname")) ; 
	private JLabel lLastname = new JLabel(ApplicationSession.instance().getString("lastname")) ; 
	private JLabel lEmail = new JLabel(ApplicationSession.instance().getString("email")) ; 
	private JLabel lPhone = new JLabel(ApplicationSession.instance().getString("phone")) ; 
	
	//TEXTFIELDS
	private JComboBox<PersonFunction> personFunction = new JComboBox<PersonFunction>() ;  ; 
	private JTextField tfFirstname = new JTextField() ; 
	private JTextField tfLastname = new JTextField() ; 
	private JTextField tfEmail = new JTextField() ; 
	private JTextField tfPhone = new JTextField() ; 
	
	//PANELS
	private JPanel pnlPersonFunction = new JPanel() ; 
	private JPanel pnlFirstname = new JPanel() ; 
	private JPanel pnlLastname = new JPanel() ; 
	private JPanel pnlEmail = new JPanel() ; 
	private JPanel pnlPhone = new JPanel() ; 
	private JPanel pnlButton = new JPanel() ; 
	
	//BUTTON
	private JButton add = new JButton(ApplicationSession.instance().getString("add")) ; 
	private JButton cancel = new JButton(ApplicationSession.instance().getString("cancel")) ; 
	
	public AddPersonPanel() {
		super() ; 
		
		personFunction.addItem(PersonFunction.STUDENT) ; 
		personFunction.addItem(PersonFunction.JURY) ; 
		pnlPersonFunction.add(lPersonFunction) ; 
		pnlPersonFunction.add(personFunction) ; 
		this.add(pnlPersonFunction) ; 
		
		pnlFirstname.add(lFirstname) ; 
		tfFirstname.setPreferredSize(new Dimension(150,20)) ; 
		tfFirstname.setBackground(Color.LIGHT_GRAY); 
		pnlFirstname.add(tfFirstname) ; 
		this.add(pnlFirstname) ; 
		
		pnlLastname.add(lLastname) ; 
		tfLastname.setPreferredSize(new Dimension(150,20)) ; 
		tfLastname.setBackground(Color.LIGHT_GRAY); 
		pnlLastname.add(tfLastname) ; 
		this.add(pnlLastname) ; 
		
		pnlEmail.add(lEmail) ; 
		tfEmail.setPreferredSize(new Dimension(300,20)) ; 
		tfEmail.setBackground(Color.LIGHT_GRAY); 
		pnlEmail.add(tfEmail) ; 
		this.add(pnlEmail) ; 
		
		pnlPhone.add(lPhone) ; 
		tfPhone.setPreferredSize(new Dimension(100,20)) ; 
		tfPhone.setBackground(Color.LIGHT_GRAY); 
		pnlPhone.add(tfPhone) ; 
		this.add(pnlPhone) ; 
		
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button = ((JButton) e.getSource()) ; 
				AddPersonPanel panel = ((AddPersonPanel) button.getParent().getParent()) ; 
				boolean ok = true ; 
				
				if (panel.tfFirstname.getText().equals(new String("")) || panel.tfLastname.getText().equals(new String("")) || panel.tfEmail.getText().equals(new String("")) || panel.tfPhone.getText().equals(new String("")))
					ok = false ; 
				
				SchedulerFrame.personnes.add(new Person((PersonFunction) panel.personFunction.getSelectedItem(), panel.tfFirstname.getText(), panel.tfLastname.getText(), panel.tfEmail.getText(), panel.tfPhone.getText())) ; 
				
				if (ok) {
					System.err.println(SchedulerFrame.personnes.get(SchedulerFrame.personnes.size() - 1).getFunction()) ; 
					System.err.println(SchedulerFrame.personnes.get(SchedulerFrame.personnes.size() - 1).getFirstname()) ; 
					System.err.println(SchedulerFrame.personnes.get(SchedulerFrame.personnes.size() - 1).getLastname()) ; 
					System.err.println(SchedulerFrame.personnes.get(SchedulerFrame.personnes.size() - 1).getEmail()) ; 
					System.err.println(SchedulerFrame.personnes.get(SchedulerFrame.personnes.size() - 1).getPhone()) ; 
					
					JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("created"), ApplicationSession.instance().getString("addPerson"), JOptionPane.INFORMATION_MESSAGE) ; 
					
					JFrame fenetre = ((JFrame) panel.getParent().getParent().getParent().getParent()) ; 
					fenetre.dispose() ; 
				}
				else
					JOptionPane.showMessageDialog(null, ApplicationSession.instance().getString("notCreated"), ApplicationSession.instance().getString("addPerson"), JOptionPane.ERROR_MESSAGE) ; 
			}
			
		}) ; 
		pnlButton.add(add) ; 
		
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton button = ((JButton) e.getSource()) ; 
				JPanel panel = ((JPanel) button.getParent().getParent()) ; 
				JFrame fenetre = ((JFrame) panel.getParent().getParent().getParent().getParent()) ; 
				fenetre.dispose() ; 
			}
			
		}) ; 
		pnlButton.add(cancel) ; 
		this.add(pnlButton) ; 
		
		this.setLayout(new GridLayout(6,1)) ; 
	}
	
}