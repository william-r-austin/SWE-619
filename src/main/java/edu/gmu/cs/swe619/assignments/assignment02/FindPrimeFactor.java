package edu.gmu.cs.swe619.assignments.assignment02;

import java.util.List;

public class FindPrimeFactor {
	
	/**
	 * Private constructor, to prevent instantiation.
	 */
	private FindPrimeFactor() {}
	
	/**
	 * Finds the least index at which b[i] is a prime factor of a[i]. 
	 * <p>
	 * Note that a[] and b[] need not be of the same length. 
	 * <p>
	 * Example 1: findPrimeFactor ([12, 25, 18, 8], [6, 2, 3, 2]) = 2.
	 * Note that 6 is a factor of 12, but is not prime, and 2 is prime, 
	 * but is not a factor of 25.  However, 3 is a prime factor of 18. 
	 * Hence, index "2" is the correct answer.  index "3" is not a possible 
	 * answer, because the third index is not the least index with the 
	 * desired property.
	 * <p>
	 * Example 2: findPrimeFactor([12, 15, 24], [4, 2, 1]) results in
	 * IllegalStateException.
	 * In this case, 12 is divisible by 4, but it is not prime. 15 is not
	 * divisible by 2, and 1 is not prime.
	 *  	  
	 * @param a  list of integers, one of which must have a prime factor 
	 *           that matches the element at the same index in list b 
	 * @param b  list of integers, one of which must be prime and a factor
	 *           of the element in list a at the same index
	 * @return  the least index i, for which b[i] is a prime factor of a[i] 
	 * @throws NullPointerException  if either input list (a or b) is null
	 * @throws IllegalStateException  if there is no index i in the given lists
	 *                                for which b[i] is a prime factor of a[i]
	 */
	public static int findPrimeFactor(List<Integer> a, List<Integer> b) {
		
		if(a == null) {
			throw new NullPointerException("Input list 'a' may not be null.");
		}
		
		if(b == null) {
			throw new NullPointerException("Input list 'b' may not be null.");
		}
		
		int stopIndex = Math.min(a.size(), b.size());
		
		for(int index = 0; index < stopIndex; index++) {
			Integer aInt = a.get(index);
			Integer bInt = b.get(index);
			if(aInt != null && bInt != null) {
				if(isPrime(bInt) && aInt % bInt == 0) {
					return index;
				}
			}
		}
		
		throw new IllegalStateException("No prime factor index found.");
	}

	/**
	 * Determines whether the given integer is prime or not.
	 * <p>
	 * This method uses the standard rules for computing primality. 0, 1, and
	 * all negative numbers are considered to be non-prime.
	 * @param x  the number to test for primality
	 * @return  true if x is a prime number, false otherwise
	 * @throws NullPointerException  if x is null
	 */
	public static boolean isPrime(Integer x) {
		
		if(x == null) {
			throw new NullPointerException("The input number may not be null.");
		}
		
		if(x < 2) {
			return false;
		}
		
		if(x == 2 || x == 3 || x == 5) {
			return true;
		}
		
		if(x % 2 == 0 || x % 3 == 0) {
			return false;
		}
		
		int max = ((int) Math.sqrt(x)) + 1;
		
		int current = 5;
		while(current <= max) {
			if(x % current == 0) {
				return false;
			}
			
			current += 2;
		}
		
		return true;
	}
}
