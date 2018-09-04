package edu.gmu.cs.swe619.exercises.week01.exercise0B;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestListUtil {
	
	@Test(expected = NullPointerException.class)
	public void testNull() {
		ListUtil.min(null);
	}

	@Test
	public void testIntegerList() {
		List<Integer> x = Arrays.asList(3, 2, 1, 0, -1);
		Integer min = ListUtil.min(x);
		Assert.assertEquals(-1, min.intValue());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testEmptyList() {
		List<Integer> x = new ArrayList<>();
		ListUtil.min(x);
	}
	
	@Test
	public void singleElementTest() {
		List<Integer> x = new ArrayList<>();
		x.add(5);
		Integer min = ListUtil.min(x);
		Assert.assertEquals(5, min.intValue());
	}
	
	@Test
	public void stringTest() {
		List<String> x = Arrays.asList("a", "b");
		String min = ListUtil.min(x);
		Assert.assertEquals("a", min);
	}
	
	@Test
	public void reverseStringTest() {
		List<String> x = Arrays.asList("z", "y", "x");
		String min = ListUtil.min(x);
		Assert.assertEquals("x", min);
	}
	
	@Test(expected = NullPointerException.class)
	public void nullElementTest() {
		List<Integer> x = new ArrayList<>();
		x.add(10);
		x.add(null);
		x.add(5);
		ListUtil.min(x);
	}
	
	/*
	@Test(expected = NullPointerException.class)
	public void classCastExceptionTest() {
		List<Number> x = new ArrayList<>();
		x.add(new Integer(10));
		x.add(new Double(4.233));
		x.add(new Float(6.1));
		x.add(new Short((short) 3));
		ListUtil.min(x);
	}*/
}
