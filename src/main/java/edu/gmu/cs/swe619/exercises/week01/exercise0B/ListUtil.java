package edu.gmu.cs.swe619.exercises.week01.exercise0B;

import java.util.List;

public class ListUtil {
	/**
	 * Returns the mininum element in a list
	 * @param list Comparable list of elements to search
	 * @return the minimum element in the list
	 * @throws NullPointerException if list is null or
	 *         if any list elements are null
	 * @throws ClassCastException if list elements are not mutually comparable
	 * @throws IllegalArgumentException if list is empty
	 */
	public static <T extends Comparable<? super T>> T min (List<? extends T> list) {
	   if (list.size() == 0) {
	      throw new IllegalArgumentException ("Min.min");
	   }
	
	   T result = list.get(0);
	
	   for (T comp : list) {
	       if (comp.compareTo(result) < 0) {    // throws NPE, CCE as needed
	           result = comp;
	       }
	   }
	   return result;
	}
}
