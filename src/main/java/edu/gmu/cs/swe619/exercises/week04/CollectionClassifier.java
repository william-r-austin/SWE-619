package edu.gmu.cs.swe619.exercises.week04;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Broken! – What does this program print?
	// Problem:  classify() is overloaded, not overridden
	public class CollectionClassifier {
	   public static String classify(Set<?> s)        { return "Set"; } 
	   public static String classify(List<?> l)       { return "List"; } 
	   public static String classify(Collection<?> c) { return "Collection"; }

	   public static void main(String[] args) {
	      Collection <?>[] collections = {
	         new HashSet<String>(),
	         new ArrayList<BigInteger>(),
	         new HashMap<String, String>().values()
	      };
	      for (Collection <?> c : collections) 
	          System.out.println(classify(c));
	   }
	
	
}
