package edu.iut.io;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import edu.iut.app.ExamEvent;

//EX 1 Completer la classe 

public class XMLProjectWriter {
	
	public XMLProjectWriter() {}
	
	public void save(ArrayList<ExamEvent> data, java.io.File xmlfile) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance() ; 
		try {
			DocumentBuilder builder = factory.newDocumentBuilder() ; 
			Document document = builder.newDocument() ; 
			Element root = document.createElement("agenda") ; 
			Comment comment = document.createComment("Commentaire") ; 
			root.appendChild(comment) ; 
			
			for (int event_i = 0 ; event_i<5 ; event_i++) {
				Element event = document.createElement("event") ; 
				event.setAttribute("public","yes") ; 
				event.setAttribute("id","" + event_i) ; 
				event.setAttribute("date","2016-06-23 "+ (14 + event_i) + ":00") ; 
				event.setAttribute("duration","02:00:00") ; 
				Element eventTitle=document.createElement("title") ; 
				eventTitle.appendChild(document.createTextNode("Train defense"+event_i)) ; 
				Element eventRoom=document.createElement("room") ; 
				eventRoom.setAttribute("number","i107") ; 
				event.appendChild(eventTitle) ; 
				event.appendChild(eventRoom) ; 
				root.appendChild(event) ; 
			}
			
			
			document.appendChild(root) ; 
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance() ; 
			try {
				Transformer transformer = transformerFactory.newTransformer() ; 
				DOMSource source = new DOMSource(document) ; 
				StreamResult output = new StreamResult(xmlfile) ; 
				transformer.setOutputProperty(OutputKeys.INDENT,"yes") ; 
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","2") ; 
				transformer.transform(source,output); 
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}
}
