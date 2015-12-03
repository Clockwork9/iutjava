package edu.iut.gui.widget.agenda;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JPanel;

import edu.iut.app.ApplicationSession;
import edu.iut.app.ExamEvent;
import edu.iut.app.Person;
import edu.iut.app.Document;

public class ExamEventPanel extends JPanel {
	
	private JLabel lDate = new JLabel(ApplicationSession.instance().getString("date")) ; 
	private JLabel lStudent = new JLabel(ApplicationSession.instance().getString("stud")) ; 
	private JLabel lJurys = new JLabel(ApplicationSession.instance().getString("jurys")); 
	private JLabel lClassroom = new JLabel(ApplicationSession.instance().getString("room")) ; 
	private JLabel lDocuments = new JLabel("Documents : ") ; 
	private JTextArea date ; 
	private JTextArea student ; 
	private JTextArea jurys ; 
	private JTextArea classroom ; 
	private JTextArea documents ; 
	private JButton edit = new JButton("Enregistrer modification"); 
	private JPanel pnlModif = new JPanel();
	
	/**
	 * Constructeur permettant de créer un panel qui affichera des informations supplémentaires sur une soutenance. 
	 * 
	 * @param	event	la sountenance dont il faut afficher davantage d'informations
	 */
	public ExamEventPanel(ExamEvent event) {
		this.date = new JTextArea(event.getExamDate().toString()) ; 
		this.student = new JTextArea(event.getStudent().getFirstname() + " " + event.getStudent().getLastname()) ;
		
		String jurys = "" ; 
		for (Person jury : event.getJury())
			jurys += jury.getFirstname() + " " + jury.getLastname() + ", " ;
		jurys = jurys.substring(0, jurys.length() - 2) ; 
		this.jurys = new JTextArea(jurys) ; 
		
		this.classroom = new JTextArea(event.getClassroom().getClassRoomNumber()) ; 
		
		String documents = "" ; 
		for (Document document : event.getDocuments())
			documents += document.getDocumentURI() + ", " ; 
		documents = documents.substring(0, documents.length() - 2) ; 
		this.documents = new JTextArea(documents) ; 
		
		pnlModif.setLayout(new GridLayout(6,2)) ; 
	
		pnlModif.add(this.lDate) ; 
		pnlModif.add(this.date) ; 
		pnlModif.add(this.lStudent) ; 
		pnlModif.add(this.student) ; 
		pnlModif.add(this.lJurys) ; 
		pnlModif.add(this.jurys) ; 
		pnlModif.add(this.lClassroom) ; 
		pnlModif.add(this.classroom) ; 
		pnlModif.add(this.lDocuments) ; 
		pnlModif.add(this.documents) ; 
		
		
		this.add(pnlModif);
		this.add(this.edit) ; 
		
		
		JFrame soutenance = new JFrame("Détail soutenance") ; 
		soutenance.add(this) ; 
		soutenance.setSize(500,170);
		soutenance.setResizable(false);
		soutenance.setVisible(true) ; 
		
	}
	
}
