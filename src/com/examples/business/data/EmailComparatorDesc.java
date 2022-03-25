package com.examples.business.data;

import java.util.Comparator;

public class EmailComparatorDesc implements Comparator<Student>  {
	
		 
		
		public int compare(Student s1, Student s2)
		{
			return s2.getEmail().compareTo(s1.getCity());
		}
			
		}


