package edu.gmu.cd.swe619.assignments.assignment01;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import edu.gmu.cs.swe619.assignments.assignment01.FindPrimeFactor;

public class FindPrimeFactorTest {
	
	@Test
	public void testExample1() {
		List<Integer> a = Arrays.asList(12, 25, 18, 8);
		List<Integer> b = Arrays.asList(6, 2, 3, 2);
		
		int result = FindPrimeFactor.findPrimeFactor(a, b);
		Assert.assertEquals(2, result);
	}
	
	@Test
	public void testExample2() {
		List<Integer> a = Arrays.asList(2, 4, 6);
		List<Integer> b = Arrays.asList(1, 2, 3);
		
		int result = FindPrimeFactor.findPrimeFactor(a, b);
		Assert.assertEquals(1, result);
	}

	
	@Test
	public void testPrimes() {
		Assert.assertEquals(false, FindPrimeFactor.isPrime(-1));
		Assert.assertEquals(false, FindPrimeFactor.isPrime(0));
		Assert.assertEquals(false, FindPrimeFactor.isPrime(1));
		Assert.assertEquals(true, FindPrimeFactor.isPrime(2));
		Assert.assertEquals(true, FindPrimeFactor.isPrime(3));
		Assert.assertEquals(false, FindPrimeFactor.isPrime(4));
		Assert.assertEquals(true, FindPrimeFactor.isPrime(5));
		Assert.assertEquals(false, FindPrimeFactor.isPrime(6));
		Assert.assertEquals(true, FindPrimeFactor.isPrime(7));
		Assert.assertEquals(false, FindPrimeFactor.isPrime(8));
		Assert.assertEquals(false, FindPrimeFactor.isPrime(9));
		Assert.assertEquals(false, FindPrimeFactor.isPrime(10));
		Assert.assertEquals(true, FindPrimeFactor.isPrime(11));
		Assert.assertEquals(false, FindPrimeFactor.isPrime(12));
		Assert.assertEquals(true, FindPrimeFactor.isPrime(13));
		Assert.assertEquals(false, FindPrimeFactor.isPrime(14));
		Assert.assertEquals(false, FindPrimeFactor.isPrime(15));
		Assert.assertEquals(false, FindPrimeFactor.isPrime(16));
		Assert.assertEquals(true, FindPrimeFactor.isPrime(17));
		Assert.assertEquals(false, FindPrimeFactor.isPrime(18));
		Assert.assertEquals(true, FindPrimeFactor.isPrime(19));
		Assert.assertEquals(false, FindPrimeFactor.isPrime(20));
		
	}
}
