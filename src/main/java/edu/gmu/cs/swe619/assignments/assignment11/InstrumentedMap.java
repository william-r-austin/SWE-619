package edu.gmu.cs.swe619.assignments.assignment11;

import java.util.Map;

public class InstrumentedMap<K, V> extends ForwardingMap<K, V> {

	public InstrumentedMap(Map<K, V> source) {
		super(source);
	}

}
