package edu.gmu.cs.swe619.assignments.assignment01;

import java.util.List;

public class FindPrimeFactor {

	// Requires: a not null; b not null;
	//           there is some index i where b[i] is 
	//           both prime and a factor of a[i]
	//           
	// Effects: return the least index
	//          at which b[i] is a prime factor of a[i]
	// E.g. findPrimeFactor ([12, 25, 18, 8], [6, 2, 3, 2]) = 2
	// (Note: 6 is a factor of 12, but is not prime,
	//  and 2 is prime, but is not a factor of 25.  However,
	//  3 is a prime factor of 18. Hence, index "2" is the correct
	//  answer.  index "3" is not a possible answer, because the
	//  third index is not the least index with the desired property.)
	// Also note that a[] and b[] need not be of the same length.
	public static int findPrimeFactor(List<Integer> a, List<Integer> b) {
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
		
		return -1;
	}

	// Requires: x not null
	//           
	// Effects: return whether x is prime (true / false)
	// 
	// E.g. isPrime(2) = true, isPrime(3) = true, isPrime(4) = false, etc.
	// 0, 1, and all negative integers are considered to be non-prime.
	public static boolean isPrime(Integer x) {
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
