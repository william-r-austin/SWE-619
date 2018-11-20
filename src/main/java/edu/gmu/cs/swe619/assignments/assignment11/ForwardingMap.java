package edu.gmu.cs.swe619.assignments.assignment11;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Wrapper class for the Map interface. Uses composition to store
 * a reference to a user-specified map object, and then provides
 * forwarding methods for all operations in the Map interface. This
 * class is not meant to be extended, so it is marked as abstract. Rather,
 * users should extend it and provide their own functionality in the subclass.
 *
 * @param <K>  the type of element for the keys in the map
 * @param <V>  the type of element for the values in the map
 */
public abstract class ForwardingMap<K, V> implements Map<K, V> {

	/**
	 * Backing collection provided by the user.
	 */
	private final Map<K, V> map;
	
	public ForwardingMap(Map<K, V> source) {
		this.map = source;
	}
	
	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public boolean containsKey(Object key) {
		return map.containsKey(key);
	}

	@Override
	public boolean containsValue(Object value) {
		return map.containsValue(value);
	}

	@Override
	public Set<Map.Entry<K, V>> entrySet() {
		return map.entrySet();
	}

	@Override
	public V get(Object key) {
		return map.get(key);
	}

	@Override
	public boolean isEmpty() {
		return map.isEmpty();
	}

	@Override
	public Set<K> keySet() {
		return map.keySet();
	}

	@Override
	public V put(K key, V value) {
		return map.put(key, value);
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		map.putAll(m);
	}

	@Override
	public V remove(Object key) {
		return map.remove(key);
	}

	@Override
	public int size() {
		return map.size();
	}

	@Override
	public Collection<V> values() {
		return map.values();
	}
	
	@Override
	public boolean equals(Object other) {
		return map.equals(other);
	}
	
	@Override
	public int hashCode() {
		return map.hashCode();
	}
	
	@Override
	public String toString() {
		return map.toString();
	}
}
