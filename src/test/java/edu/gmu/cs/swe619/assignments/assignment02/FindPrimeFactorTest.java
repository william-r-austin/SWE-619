package edu.gmu.cs.swe619.assignments.assignment02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

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
	
	@Test(expected = NullPointerException.class)
	public void testNull1() {
		List<Integer> x = Arrays.asList(2, 4, 6);
		FindPrimeFactor.findPrimeFactor(x, null);
	}
	
	@Test(expected = NullPointerException.class)
	public void testNull2() {
		List<Integer> x = Arrays.asList(2, 4, 6);
		FindPrimeFactor.findPrimeFactor(null, x);
	}
	
	@Test
	public void testEmptyList1() {
		List<Integer> x = Arrays.asList(1, 2, 3);
		List<Integer> y = new ArrayList<>();
		int result = FindPrimeFactor.findPrimeFactor(x, y);
		Assert.assertEquals(-1, result);
	}
	
	@Test
	public void testEmptyList2() {
		List<Integer> x = Arrays.asList(1, 2, 3);
		List<Integer> y = new ArrayList<>();
		int result = FindPrimeFactor.findPrimeFactor(y, x);
		Assert.assertEquals(-1, result);
	}
	
	@Test 
	public void testNegativeNumbers() {
		List<Integer> x = Arrays.asList(12, -14, 20);
		List<Integer> y = Arrays.asList(4, 7, 5);
		int result = FindPrimeFactor.findPrimeFactor(x, y);
		Assert.assertEquals(1, result); 
	}
	
	@Test 
	public void testZeroFactors() {
		List<Integer> x = Arrays.asList(0, 0);
		List<Integer> y = Arrays.asList(4, 7);
		int result = FindPrimeFactor.findPrimeFactor(x, y);
		Assert.assertEquals(1, result); 
	}
	
	@Test
	public void testSameNumber() {
		List<Integer> x = Arrays.asList(10, 11, 2, 6, 0, -2, 3);
		List<Integer> y = Arrays.asList(3, 5, 4, 6, 0, -2, 3);
		int result = FindPrimeFactor.findPrimeFactor(x, y);
		Assert.assertEquals(6, result); 
	}
	
	@Test
	public void testDifferentSizeLists1() {
		List<Integer> x = Arrays.asList(1);
		List<Integer> y = Arrays.asList(3, 5, 4, 6, 0, -2, 3);
		int result = FindPrimeFactor.findPrimeFactor(x, y);
		Assert.assertEquals(-1, result); 
	}
	
	@Test
	public void testDifferentSizeLists2() {
		List<Integer> x = Arrays.asList(3, 5, 10, 6, 0, -2, 3);
		List<Integer> y = Arrays.asList(2, 3);
		int result = FindPrimeFactor.findPrimeFactor(x, y);
		Assert.assertEquals(-1, result); 
	}
	
	@Test
	public void testDifferentSizeLists3() {
		List<Integer> x = Arrays.asList(3, 5, 10, 6, 0, -2, 3, -99);
		List<Integer> y = Arrays.asList(2, 1, 5);
		int result = FindPrimeFactor.findPrimeFactor(x, y);
		Assert.assertEquals(2, result); 
	}
	
	@Test
	public void testNullElements() {
		List<Integer> x = Arrays.asList(3, null, 10, 6, 35, 28, 3);
		List<Integer> y = Arrays.asList(2, 0, null, 4, 5, 2);
		int result = FindPrimeFactor.findPrimeFactor(x, y);
		Assert.assertEquals(4, result); 
	}	
	
	@Test(expected = NullPointerException.class)
	public void testNullPrime() {
		FindPrimeFactor.isPrime(null);
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
