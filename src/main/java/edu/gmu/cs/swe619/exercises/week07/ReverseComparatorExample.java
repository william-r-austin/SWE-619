package edu.gmu.cs.swe619.exercises.week07;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseComparatorExample {

	public static void main(String[] args) {
		List<Integer> testList = Arrays.asList(new Integer[] {1, 2, 3, 4, 5});
		ReverseComparator<Integer> reverser = new ReverseComparator<Integer>();
		Collections.sort(testList, reverser);
		System.out.println(testList);
	}

}
