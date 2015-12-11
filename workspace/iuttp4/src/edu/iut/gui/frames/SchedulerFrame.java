package edu.iut.gui.frames;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import edu.iut.app.ExamEvent;
import edu.iut.app.XMLFilter;
import edu.iut.gui.widget.agenda.AgendaPanelFactory;
import edu.iut.gui.widget.agenda.ControlAgendaViewPanel;
import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;
import edu.iut.io.XMLProjectReader;
import edu.iut.io.XMLProjectWriter;


public class SchedulerFrame extends JFrame {
	JPanel contentPane;
	CardLayout layerLayout;
	AgendaPanelFactory agendaPanelFactory;	
	JPanel dayView;
	JPanel weekView;
	JPanel monthView;
	
	protected void setupUI() {
		
		contentPane = new JPanel();
		layerLayout = new CardLayout();
		contentPane.setLayout(layerLayout);
		ControlAgendaViewPanel agendaViewPanel = new ControlAgendaViewPanel(layerLayout,contentPane);
		agendaPanelFactory = new AgendaPanelFactory();
		dayView = agendaPanelFactory.getAgendaView(ActiveView.DAY_VIEW);
		weekView = agendaPanelFactory.getAgendaView(ActiveView.WEEK_VIEW);
		monthView = agendaPanelFactory.getAgendaView(ActiveView.MONTH_VIEW);
		
		contentPane.add(dayView,ActiveView.DAY_VIEW.name());
		contentPane.add(weekView,ActiveView.WEEK_VIEW.name());
		contentPane.add(monthView,ActiveView.MONTH_VIEW.name());
	
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,agendaViewPanel, contentPane);
		this.setContentPane(splitPane);
		
		JMenuBar menuBar = new JMenuBar();
		JMenu menu;		
		JMenuItem menuItem;
		
		/* File Menu */
		menu = new JMenu("File");
		
		menuItem = new JMenuItem("Load");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {		
				JFileChooser loadFile = new JFileChooser() ; 
				loadFile.addChoosableFileFilter(new XMLFilter()) ; 
				int retour = loadFile.showOpenDialog((JMenuItem) arg0.getSource()) ; 
				if(retour==JFileChooser.APPROVE_OPTION){
				   // un fichier a �t� choisi (sortie par OK)
				   // chemin absolu du fichier choisi
					String cheminFichier = loadFile.getSelectedFile().getAbsolutePath() ; 
					
					XMLProjectReader load = new XMLProjectReader() ; 
					/*int ouvrir = load.showSaveDialog((JMenuItem) arg0.getSource());
					if(retour == JFileChooser.APPROVE_OPTION){
					   // un fichier a �t� choisi (sortie par OK)
					   // chemin absolu du fichier choisi
						String cheminFichierOuvrir = saveFile.getSelectedFile().getAbsolutePath() ; 
						
						XMLProjectWriter saveXml = new XMLProjectWriter() ; 
						saveXml.save(new ArrayList<ExamEvent>(), new File(cheminFichier)) ; 
					}*/
					try {
						load.load(new File(cheminFichier)) ;
					} catch (IOException e) {
						e.printStackTrace();
					} 
				}
			}			
		});
		menu.add(menuItem);
		
		//SAVE
		menuItem = new JMenuItem("Save");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser saveFile = new JFileChooser() ; 
				saveFile.addChoosableFileFilter(new XMLFilter()) ; 
				int retour = saveFile.showSaveDialog((JMenuItem) arg0.getSource());
				if(retour == JFileChooser.APPROVE_OPTION){
				   // un fichier a �t� choisi (sortie par OK)
				   // chemin absolu du fichier choisi
					String cheminFichier = saveFile.getSelectedFile().getAbsolutePath() ; 
					
					XMLProjectWriter saveXml = new XMLProjectWriter() ; 
					saveXml.save(new ArrayList<ExamEvent>(), new File(cheminFichier)) ; 
				}
			}
		});
		menu.add(menuItem);
		
		menuItem = new JMenuItem("Quit");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
					
				//message box yes/no pour le bouton quitter
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Voulez-vous quitter?","Warning",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
				System.exit(0);
				}
	
			}			
		});
		menu.add(menuItem);		
		menuBar.add(menu);
		
		/* Edit Menu */
		menu = new JMenu("Edit");
		JMenu submenu = new JMenu("View");
		menuItem = new JMenuItem("Day");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				layerLayout.show(contentPane,ActiveView.DAY_VIEW.name());	
			}			
		});		
		submenu.add(menuItem);
		menuItem = new JMenuItem("Week");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				layerLayout.show(contentPane,ActiveView.WEEK_VIEW.name());		
			}			
		});		
		submenu.add(menuItem);
		menuItem = new JMenuItem("Month");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				layerLayout.show(contentPane,ActiveView.MONTH_VIEW.name());		
			}			
		});		
		submenu.add(menuItem);
		menu.add(submenu);
		menuBar.add(menu);
		
		/* Help Menu */
		menu = new JMenu("Help");
		menuItem = new JMenuItem("Display");
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// EX 4 : ajouter l'aide
				//JOptionPane.showMessageDialog(null, "Not yet implemented", "info", JOptionPane.INFORMATION_MESSAGE, null);
				//Ajout du code pour la fenetre HTML de "Display"
				    SwingUtilities.invokeLater(new Runnable()
				    {
				      public void run()
				      {
				        // create jeditorpane
				        JEditorPane jEditorPane = new JEditorPane();
				        
				        // make it read-only
				        jEditorPane.setEditable(false);
				        
				        // create a scrollpane; modify its attributes as desired
				        JScrollPane scrollPane = new JScrollPane(jEditorPane);
				        
				        // add an html editor kit
				        HTMLEditorKit kit = new HTMLEditorKit();
				        jEditorPane.setEditorKit(kit);
				        
				        // add some styles to the html
				        StyleSheet styleSheet = kit.getStyleSheet();
				        styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
				        styleSheet.addRule("h1 {color: blue;}");
				        styleSheet.addRule("h2 {color: #ff0000;}");
				        styleSheet.addRule("pre {font : 10px monaco; color : black; background-color : #fafafa; }");

				        // create some simple html as a string
				        String htmlString = "<html>\n"
				                          + "<body>\n"
				                          + "<h1>Help</h1>\n"
				                          + "<h2>help text</h2>\n"
				                          + "<p>This is some sample text</p>\n"
				                          + "</body>\n";
				        
				        // create a document, set it on the jeditorpane, then add the html
				        Document doc = kit.createDefaultDocument();
				        jEditorPane.setDocument(doc);
				        jEditorPane.setText(htmlString);

				        // now add it all to a frame
				        JFrame j = new JFrame("HtmlEditorKit Test");
				        j.getContentPane().add(scrollPane, BorderLayout.CENTER);
				        
				        // display the frame
				        j.setSize(new Dimension(300,200));
				        
				        // pack it, if you prefer
				        //j.pack();
				        
				        // center the jframe, then make it visible
				        j.setLocationRelativeTo(null);
				        j.setVisible(true);
				      }
				    });
				  }
		});
		menu.add(menuItem);
		menuItem = new JMenuItem("About");
		//Ajout du code pour la fenetre HTML de "About"
		menuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 SwingUtilities.invokeLater(new Runnable()
				    {
				      public void run()
				      {
				        // create jeditorpane
				        JEditorPane jEditorPane = new JEditorPane();
				        
				        // make it read-only
				        jEditorPane.setEditable(false);
				        
				        // create a scrollpane; modify its attributes as desired
				        JScrollPane scrollPane = new JScrollPane(jEditorPane);
				        
				        // add an html editor kit
				        HTMLEditorKit kit = new HTMLEditorKit();
				        jEditorPane.setEditorKit(kit);
				        
				        // add some styles to the html
				        StyleSheet styleSheet = kit.getStyleSheet();
				        styleSheet.addRule("body {color:#000; font-family:times; margin: 4px; }");
				        styleSheet.addRule("h1 {color: blue;}");
				        styleSheet.addRule("h2 {color: #ff0000;}");
				        styleSheet.addRule("pre {font : 10px monaco; color : black; background-color : #fafafa; }");

				        // create some simple html as a string
				        String htmlString = "<html>\n"
				                          + "<body>\n"
				                          + "<h1>About this Scheduler</h1>\n"
				                          + "<p>This is some sample text</p>\n"
				                          + "</body>\n";
				        
				        // create a document, set it on the jeditorpane, then add the html
				        Document doc = kit.createDefaultDocument();
				        jEditorPane.setDocument(doc);
				        jEditorPane.setText(htmlString);

				        // now add it all to a frame
				        JFrame j = new JFrame("HtmlEditorKit Test");
				        j.getContentPane().add(scrollPane, BorderLayout.CENTER);
				        
				        // display the frame
				        j.setSize(new Dimension(300,200));
				        
				        // pack it, if you prefer
				        //j.pack();
				        
				        // center the jframe, then make it visible
				        j.setLocationRelativeTo(null);
				        j.setVisible(true);
				      }
				    });
				  		
			}			
		});
		menu.add(menuItem);
		menuBar.add(menu);
		this.setJMenuBar(menuBar);
		this.pack();
		layerLayout.next(contentPane);
	}
	
	public SchedulerFrame() {
		super();
		
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		contentPane = null;
		dayView = null;
		weekView = null;
		monthView = null;
		agendaPanelFactory = null;
		setupUI();

	}

	
	public SchedulerFrame(String title) {
		super(title);
		addWindowListener (new WindowAdapter(){
			public void windowClosing (WindowEvent e){
				System.exit(0);
			}
		});
		setupUI();
	}
	
}
