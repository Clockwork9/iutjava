package edu.iut.tests;

import static org.junit.Assert.*;

import java.util.Locale;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import edu.iut.app.ApplicationSession;

public class ApplicationSessionTest {

	private static ApplicationSession as; 
	
	@BeforeClass
	public static void setUpBeforeClass() {
		System.err.println("ApplicationSessionTest") ; 
	}
	
	@Before
	public void setUp() {
		System.err.println("Object creation") ; 
		as = new ApplicationSession() ; 
		System.err.println("Object created without encountering issue") ; 
		System.err.println() ; 
	}

	@Test
	public void setLocaleTest() {
		System.err.println("setLocaleTest Default") ; 
		System.err.println(as.getString("monday") + ' ' + as.getString("mon")) ; 
		System.err.println(as.getString("tuesday") + ' ' + as.getString("tue")) ; 
		System.err.println(as.getString("wednesday") + ' ' + as.getString("wed")) ; 
		System.err.println(as.getString("thursday") + ' ' + as.getString("thu")) ; 
		System.err.println(as.getString("friday") + ' ' + as.getString("fri")) ; 
		System.err.println(as.getString("saturday") + ' ' + as.getString("sat")) ; 
		System.err.println(as.getString("sunday") + ' ' + as.getString("sun")) ; 
		System.err.println() ; 
		
		System.err.println("setLocaleTest France") ; 
		as.setLocale(Locale.FRANCE) ; 
		System.err.println(as.getString("monday") + ' ' + as.getString("mon")) ; 
		System.err.println(as.getString("tuesday") + ' ' + as.getString("tue")) ; 
		System.err.println(as.getString("wednesday") + ' ' + as.getString("wed")) ; 
		System.err.println(as.getString("thursday") + ' ' + as.getString("thu")) ; 
		System.err.println(as.getString("friday") + ' ' + as.getString("fri")) ; 
		System.err.println(as.getString("saturday") + ' ' + as.getString("sat")) ; 
		System.err.println(as.getString("sunday") + ' ' + as.getString("sun")) ; 
		System.err.println() ; 
		
		System.err.println("setLocale used without encountering issue") ; 
		System.err.println() ;
	}
}
