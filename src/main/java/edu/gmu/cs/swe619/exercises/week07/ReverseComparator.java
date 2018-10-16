package edu.gmu.cs.swe619.exercises.week07;

import java.util.Comparator;

public class ReverseComparator<K extends Comparable<K>> implements Comparator<K> {

	@Override
	public int compare(K o1, K o2) {
		return o2.compareTo(o1);
	}
}
