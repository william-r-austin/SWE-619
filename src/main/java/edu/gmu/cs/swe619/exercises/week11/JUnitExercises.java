package edu.gmu.cs.swe619.exercises.week11;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class JUnitExercises {

	@DataPoints
	public static Object[] x = {"ant", "bat", "cat"};
   
	@DataPoints
	public static Object[] y = {"lion", "tiger", "bear"};
	
	@Theory
	public void testEqualsSymmetry(Object x, Object y) {
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		
		Assume.assumeTrue(x != null);
		Assume.assumeTrue(y != null);
		
		Assert.assertTrue(x.equals(x));
		Assert.assertTrue(y.equals(y));
		
		boolean xEqualsY = x.equals(y);
		boolean yEqualsX = y.equals(x);
		
		Assert.assertTrue(xEqualsY == yEqualsX);
	}
}
