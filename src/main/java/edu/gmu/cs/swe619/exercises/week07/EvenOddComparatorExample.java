package edu.gmu.cs.swe619.exercises.week07;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EvenOddComparatorExample {

	public static void main(String[] args) {
		List<Integer> testList = 
			Arrays.asList(new Integer[] {-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5});
		EvenOddComparator evenOddSorter = new EvenOddComparator();
		Collections.sort(testList, evenOddSorter);
		System.out.println(testList);
	}
}
