package edu.gmu.cs.swe619.assignments.assignment11;

import java.util.List;

public class InstrumentedList<E> extends ForwardingList<E> {

	public InstrumentedList(List<E> sourceList) {
		super(sourceList);
	}
}
