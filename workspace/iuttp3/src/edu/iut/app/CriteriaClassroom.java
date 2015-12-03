package edu.iut.app;

import java.util.ArrayList;

public class CriteriaClassroom implements Criteria {

	/**
	 * Retourne une liste de Classrooms à partir d'une liste d'objets quelconques. 
	 */
	@Override
	public ArrayList<Classroom> meetCriteria(ArrayList<?> objects) {
		// TODO Auto-generated method stub
		ArrayList<Classroom> classrooms = new ArrayList<>() ; 
		
		for (Object object : objects) {
			if (object instanceof Classroom)
				classrooms.add((Classroom) object) ; 
		}
		
		return classrooms ; 
	}

}
