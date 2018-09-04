package edu.gmu.cs.swe619.exercises.week02.exercise1B;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class TestTail {
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testIntegerRemoveIndex() {
		List<Integer> x = new ArrayList<>();
		x.remove(0);
	}
	
	@Test
	public void testIntegerRemoveObject() {
		Integer value = 0;
		List<Integer> x = new ArrayList<>();
		boolean result = x.remove(value);
		Assert.assertEquals(false, result);
	}
}
