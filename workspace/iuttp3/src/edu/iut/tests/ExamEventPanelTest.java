package edu.iut.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import edu.iut.app.Classroom;
import edu.iut.app.Document;
import edu.iut.app.ExamEvent;
import edu.iut.app.Person;
import edu.iut.app.Person.PersonFunction;
import edu.iut.gui.widget.agenda.ExamEventPanel;

public class ExamEventPanelTest {

	private ExamEvent examEvent ; 
	private Date date ; 
	private Person student ; 
	private ArrayList<Person> jurys ; 
	private Classroom classroom ; 
	private ArrayList<Document> documents ; 
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.err.println("ExamEventPanelTest") ; 
	}
	
	@Before
	public void setUp() {
		System.err.println("Parameters initialization") ; 
		
		this.date = new Date() ; 
		
		this.student = new Person(PersonFunction.STUDENT, "Test", "CCRI", "test.CCRI@u-psud.fr", "00 00 00 00 00") ; 
		
		this.jurys = new ArrayList<Person>() ; 
		jurys.add(new Person(PersonFunction.STUDENT, "Emmanuel", "MOTCHANE", "emmanuel.motchane@u-psud.fr", "01 01 01 01 01")) ; 
		jurys.add(new Person(PersonFunction.STUDENT, "Sébastien", "NOBILI", "sebastien.nobili@u-psud.fr", "02 02 02 02 02")) ; 
		
		this.classroom = new Classroom("I114-I116") ; 
		
		this.documents = new ArrayList<Document>() ; 
		documents.add(new Document("Doc1")) ; 
		documents.add(new Document("Doc2")) ; 
		
		this.examEvent = new ExamEvent(this.date, this.student, this.jurys, this.classroom, this.documents) ; 
		
		System.err.println("Parameters initialized without encountering issue") ; 
		System.err.println() ; 
	}
	
	@Test
	public void ExamEventPanelTest() throws InterruptedException {
		ExamEventPanel eepTest = new ExamEventPanel(this.examEvent) ; 
		System.err.println("The program has been paused for 15 seconds") ; 
		Thread.sleep(15000) ; 
		
		System.err.println("Detail widget created without encountering issue") ; 
		System.err.println() ; 
	}

}
