package edu.iut.gui.frames;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

import edu.iut.app.ApplicationSession;
import edu.iut.gui.widget.agenda.AgendaPanelFactory;
import edu.iut.gui.widget.agenda.ControlAgendaViewPanel;
import edu.iut.gui.widget.agenda.AgendaPanelFactory.ActiveView;


public class SchedulerFrame extends JFrame {
	JPanel contentPane;
	CardLayout layerLayout;
	AgendaPanelFactory agendaPanelFactory;	
	JPanel dayView;
	JPanel weekView;
	JPanel monthView;
	
	/**
	 * Initialise l'interface graphique de l'application. 
	 */
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
		
		//MENU
		JMenu file, edit, help, view;
		
		//ITEM DE MENU
		JMenuItem load, quit, save;
		JMenuItem display, about;
		JMenuItem month, week, day;
		
		/* File Menu */
		/** EX4 : MENU : UTILISER L'AIDE FOURNIE DANS LE TP**/
		//Classe pour les listener des parties non impl�ment�s
		class MsgError implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Not yet implemented", "info", JOptionPane.INFORMATION_MESSAGE, null);	
			}
			
		}
		
	//Menu File	
		file = new JMenu("File");
		
		menuBar.add(file);
		file.setMnemonic(KeyEvent.VK_A);
		file.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(file);
		

		//a group of JMenuItems
		load = new JMenuItem("Load",KeyEvent.VK_T);
		load.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		load.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		file.add(load);
		load.addActionListener(new MsgError());
		
		quit = new JMenuItem("quit",KeyEvent.VK_T);
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		quit.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		file.add(quit);
		
		//LISTENER QUIT
		quit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				//message box yes/no pour le bouton quitter
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Voulez-vous quitter?","Warning",dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION){
				System.exit(0);
				}
			}
			
		});
		
		save = new JMenuItem("Save",KeyEvent.VK_T);
		save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		save.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		file.add(save);
		save.addActionListener(new MsgError());
		
		
	//Menu Edit 
		edit = new JMenu("Edit");
		
		menuBar.add(edit);
		edit.setMnemonic(KeyEvent.VK_A);
		edit.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		
		//Sous menu View
		
		view = new JMenu("View");
		view.setMnemonic(KeyEvent.VK_A);
		view.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		edit.add(view);
		
		month = new JMenuItem("Month",KeyEvent.VK_T);
		month.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		month.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		view.add(month);
				
		week = new JMenuItem("Week",KeyEvent.VK_T);
		week.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		week.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		view.add(week);
		
		day = new JMenuItem("Day",KeyEvent.VK_T);
		day.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		day.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		view.add(day);
		
		//LISTENER VIEW
		
		
		month.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				layerLayout.last(contentPane);	
				
			}
			
		});
		
		week.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				layerLayout.first(contentPane);	
				layerLayout.next(contentPane);	
				}
			
			
		});
		day.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				layerLayout.first(contentPane);	
				
			}
			
		});
		
		
	//Menu Help
		help = new JMenu("Help");
		
		menuBar.add(help);
		help.setMnemonic(KeyEvent.VK_A);
		help.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(help);
		
		display = new JMenuItem("Display",KeyEvent.VK_T);
		display.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		display.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		help.add(display);
		display.addActionListener(new MsgError());
		
		about = new JMenuItem("About",KeyEvent.VK_T);
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		about.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		help.add(about);
		about.addActionListener(new MsgError());
		
		

		this.setJMenuBar(menuBar);
		this.pack();
		layerLayout.next(contentPane);
	}
	
	/**
	 * Constructeur par d�faut de SchedulerFrame
	 */
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
	
	/**
	 * Constructeur permettant de d�finir le titre de la fen�tre de l'application
	 * 
	 * @param	title	le titre de la fen�tre
	 */
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
