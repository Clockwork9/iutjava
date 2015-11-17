package edu.iut.tools;

import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class IUTScheduler {
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		    	System.err.println(args[0]);
		    	for (int i =0;i<args.length;i++) {
		    		String[] toks = args[i].split("=");
		    		if (toks[0].equals("locale")) {
		    			if (toks[1].equals("fr")) {
		    				edu.iut.app.ApplicationSession.instance().setLocale(Locale.FRANCE);
		    			}
		    		}
		    	}
		        JFrame mainFrame = new edu.iut.gui.frames.SchedulerFrame("IUT Scheduler");
		        mainFrame.setVisible(true);		        
		    }
		});
	}
	
}
