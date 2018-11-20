package edu.gmu.cs.swe619.assignments.assignment11;

import java.util.Collection;

/**
 * Basic instrumented collection that uses a wrapper class to provide
 * custom Collection behavior. 
 *
 * @param <E>  the type of elements to store in the collection
 */
public class InstrumentedCollection<E> extends ForwardingCollection<E> {

	/**
	 * Creates a new InstrumentedCollection
	 * 
	 * @param sourceCollection  backing collection to use 
	 */
	public InstrumentedCollection(Collection<E> sourceCollection) {
		super(sourceCollection);
	}
}