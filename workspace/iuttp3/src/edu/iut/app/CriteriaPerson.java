package edu.iut.app;

import java.util.ArrayList;

public class CriteriaPerson implements Criteria {

	@Override
	public ArrayList<Person> meetCriteria(ArrayList<?> objects) {
		// TODO Auto-generated method stub
		ArrayList<Person> persons = new ArrayList<>() ; 
		
		for (Object object : objects) {
			if (object instanceof Person)
				persons.add((Person) object) ; 
		}
		
		return persons ; 
	}

}
