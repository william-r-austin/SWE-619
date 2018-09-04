package edu.gmu.cs.swe619.exercises.week01.exercise0A;

import org.junit.Assert;
import org.junit.Test;

public class TestSpecialUser {
	
	@Test
	public void testSuccessful() {
		SpecialUser a = new SpecialUser("test", 5);
		SpecialUser b = new SpecialUser("test", 5);
		boolean equals = a.equals(b);
		Assert.assertEquals(true, equals);
	}
	
	@Test
	public void testNullInstanceOf() {
		SpecialUser a = null;
		boolean isSpecialUser = (a instanceof SpecialUser);
		Assert.assertEquals(false, isSpecialUser);
	}
	
	@Test
	public void testInstanceOfSuperclass() {
		SpecialUser a = new SpecialUser("test", 5);
		
		boolean isUser = (a instanceof User);
		Assert.assertEquals(true, isUser);
		
		boolean isSpecialUser = (a instanceof SpecialUser);
		Assert.assertEquals(true, isSpecialUser);
	}
	
	@Test
	public void testInstanceOfSuperclassPolymorphism() {
		User a = new SpecialUser("test", 5);
		
		boolean isUser = (a instanceof User);
		Assert.assertEquals(true, isUser);
		
		boolean isSpecialUser = (a instanceof SpecialUser);
		Assert.assertEquals(true, isSpecialUser);
	}
}
