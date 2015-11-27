package edu.iut.app;

import java.util.ArrayList;
import java.util.Date;

public class CriteriaDate implements Criteria {

	@Override
	public ArrayList<Date> meetCriteria(ArrayList<?> objects) {
		// TODO Auto-generated method stub
		ArrayList<Date> dates = new ArrayList<>() ; 
		
		for (Object object : objects) {
			if (object instanceof Date)
				dates.add((Date) object) ; 
		}
		
		return dates ; 
	}

}
