package edu.gmu.cs.swe619.exercises.week02.exercise1B;

import java.util.ArrayList;
import java.util.List;

public class ListUtil {

   // REQUIRES: ???
   // EFFECTS:  ???
	public static List<Integer> tail (List<Integer> list) {
	   List<Integer> result = new ArrayList<Integer>(list);
	   result.remove(0);
	   return result;
	}
}
