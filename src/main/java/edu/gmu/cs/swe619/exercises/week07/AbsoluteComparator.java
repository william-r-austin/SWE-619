package edu.gmu.cs.swe619.exercises.week07;

import java.util.Comparator;

public class AbsoluteComparator<U extends Number & Comparable<U>> implements Comparator<U> {

	@Override
	public int compare(U o1, U o2) {
		Double d1 = Math.abs(o1.doubleValue());
		Double d2 = Math.abs(o2.doubleValue());
		return d1.compareTo(d2);
	}
}
