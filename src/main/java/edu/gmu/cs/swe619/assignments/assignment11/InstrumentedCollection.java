package edu.gmu.cs.swe619.assignments.assignment11;

import java.util.Collection;

public class InstrumentedCollection<E> extends ForwardingCollection<E> {

	public InstrumentedCollection(Collection<E> sourceCollection) {
		super(sourceCollection);
	}
}