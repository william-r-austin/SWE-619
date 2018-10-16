package edu.gmu.cs.swe619.exercises.week07;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		Integer o1Parity = Math.abs(o1 % 2);
		Integer o2Parity = Math.abs(o2 % 2);
		Integer parityCompare = o1Parity.compareTo(o2Parity);
		if(parityCompare == 0) {
			o1.compareTo(o2);
		}
		return parityCompare;
	}
	

}
