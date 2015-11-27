package edu.iut.gui.frames;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

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
		JMenu file, edit, help;
		
		//ITEM DE MENU
		JMenuItem menuItem, menuItem2, menuItem3, menuItem4;
		JMenuItem menuItem5, menuItem6, menuItem7, menuItem8;
		
		/* File Menu */
		/** EX4 : MENU : UTILISER L'AIDE FOURNIE DANS LE TP**/
		
	//Menu File	
		file = new JMenu("File");
		
		menuBar.add(file);
		file.setMnemonic(KeyEvent.VK_A);
		file.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(file);
		

		//a group of JMenuItems
		menuItem = new JMenuItem("Load",KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		file.add(menuItem);
		
		menuItem2 = new JMenuItem("quit",KeyEvent.VK_T);
		menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem2.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		file.add(menuItem2);
		
		menuItem3 = new JMenuItem("Save",KeyEvent.VK_T);
		menuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem3.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		file.add(menuItem3);
		
		
	//Menu Edit 
		edit = new JMenu("Edit");
		
		menuBar.add(edit);
		edit.setMnemonic(KeyEvent.VK_A);
		edit.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(edit);
		
		menuItem4 = new JMenuItem("View",KeyEvent.VK_T);
		menuItem4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem4.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		edit.add(menuItem4);
		
		
	//Menu Help
		help = new JMenu("Edit");
		
		menuBar.add(help);
		help.setMnemonic(KeyEvent.VK_A);
		help.getAccessibleContext().setAccessibleDescription(
		        "The only menu in this program that has menu items");
		menuBar.add(help);
		
		menuItem5 = new JMenuItem("Display",KeyEvent.VK_T);
		menuItem5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem5.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		help.add(menuItem5);
		
		menuItem6 = new JMenuItem("About",KeyEvent.VK_T);
		menuItem6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		menuItem6.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
		help.add(menuItem6);
		
		

	/*	menuItem.setMnemonic(KeyEvent.VK_B);
		edit.add(menuItem);

		menuItem.setMnemonic(KeyEvent.VK_D);
		edit.add(menuItem);*/

		
		
		
		//a submenu
		/*menu.addSeparator();
		submenu = new JMenu("A submenu");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("An item in the submenu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(
		        KeyEvent.VK_2, ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem = new JMenuItem("Another item");
		submenu.add(menuItem);
		menu.add(submenu);

		//Build second menu in the menu bar.
		menu = new JMenu("Another Menu");
		menu.setMnemonic(KeyEvent.VK_N);
		menu.getAccessibleContext().setAccessibleDescription(
		        "This menu does nothing");
		menuBar.add(menu);*/


		
		
		
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
