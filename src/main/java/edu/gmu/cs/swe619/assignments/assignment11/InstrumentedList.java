package edu.gmu.cs.swe619.assignments.assignment11;

import java.util.List;

/**
 * Basic instrumented list that uses a wrapper class to provide
 * custom List behavior. 
 *
 * @param <E>  the type of elements to store in the list
 */
public class InstrumentedList<E> extends ForwardingList<E> {

	/**
	 * Creates a new InstrumentedList
	 * 
	 * @param sourceList  backing list to use
	 */
	public InstrumentedList(List<E> sourceList) {
		super(sourceList);
	}
}
