package edu.gmu.cs.swe619.assignments.assignment11;

import java.util.Map;

/**
 * Basic instrumented map that uses a wrapper class to provide
 * custom Map behavior. 
 *
 * @param <K>  the type of element for the keys in the map
 * @param <V>  the type of element for the values in the map
 */
public class InstrumentedMap<K, V> extends ForwardingMap<K, V> {

	/**
	 * Creates a new InstrumentedMap
	 * 
	 * @param sourceMap  backing map to use
	 */
	public InstrumentedMap(Map<K, V> sourceMap) {
		super(sourceMap);
	}

}
