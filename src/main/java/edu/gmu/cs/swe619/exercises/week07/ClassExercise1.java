/**
 * @author William
 *
 */
package edu.gmu.cs.swe619.exercises.week07;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class ClassExercise1 {
	public static void main(String[] args) {
		Set<Vector<String>> s = new HashSet<Vector<String>>();
		Vector<String> x = new Vector<String>();
		Vector<String> y = new Vector<String>();
		
		s.add(x);
		s.add(y);
		
		System.out.println("s = " + s);
		
		y.add("abc");
		s.add(y);
		System.out.println("s = " + s);
		
		y.clear();
		System.out.println("s = " + s);
		
		s.remove(x);
		System.out.println("s = " + s);
		
		
	}
}