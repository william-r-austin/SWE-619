package edu.gmu.cs.swe619.exercises.week01.exercise0A;

import org.junit.Assert;
import org.junit.Test;

public class TestUser {
	
	@Test
	public void testNullObject() {
		User x = new User("x");
		User y = null;
		boolean equals = x.equals(y);
		Assert.assertEquals(false, equals);
	}
	
	// This is an issue!!
	@Test(expected = NullPointerException.class)
	public void testNullName() {
		User x = new User("x");
		User y = new User(null);
		x.equals(y);
	}
	
	@Test
	public void testSuccessful() {
		User x1 = new User("x");
		User x2 = new User("x");
		boolean equals = x1.equals(x2);
		Assert.assertEquals(true, equals);
	}
	
	@Test
	public void testInstanceOfSubclass() {
		User a = new User("test");
		
		boolean isUser = (a instanceof User);
		Assert.assertEquals(true, isUser);
		
		boolean isSpecialUser = (a instanceof SpecialUser);
		Assert.assertEquals(false, isSpecialUser);
	}
	
	// This is probably an issue!!
	@Test
	public void testMixedTypes() {
		User x1 = new User("x");
		User x2 = new SpecialUser("x", 3);
		boolean equals = x1.equals(x2);
		Assert.assertEquals(true, equals);
	}
}
