package edu.gmu.cs.swe619.assignments.assignment10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Overview: IntSets are unbounded, mutable sets of integers. This implementation
 * is based on the code that was given to us for the assignment. It is not a full
 * implementation and only includes the functionality to demonstrate Liskov's
 * broken clone() method from figure 5.10.
 */
public class IntSetLiskov implements Cloneable {

	/**
	 * The rep.
	 */
	private List<Integer> els;

	/**
	 * An incorrect implementation for equals(), based on Bloch's "standard recipe". It does not
	 * handle the case when the 2 lists represent the same set, but are ordered differently.
	 * 
	 * @return  true if the 2 objects are the same, false otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj != null) {
			if(obj instanceof IntSetLiskov) {
				IntSetLiskov other = (IntSetLiskov) obj;
				return Objects.equals(this.els, other.els);
			}
		}
		
		return false;
	}

	/**
	 * A correct, but poorly performing implementation for hashCode(), taken from the provided code. All
	 * objects of this class will return the same value.
	 * 
	 * @return  a hash code for the object
	 */
	@Override
	public int hashCode() {
		return 42;
	}

	/**
	 * Public constructor for the IntSetLiskov class. Creates an empty set.
	 */
	public IntSetLiskov()	{
		els = new ArrayList<Integer>();
	}

	/**
	 * A private constructor for use by the clone() method.
	 * 
	 * @param list  list of integers to populate the rep with
	 */
	private IntSetLiskov(List<Integer> list) {
		els = list;
	}

	/**
	 * Broken implementation for clone(). It calls a constructor, which means prevents
	 * subclasses from being able to provide a correct implementation for clone().
	 * 
	 * @return  a clone of this object
	 */
	@Override
	public IntSetLiskov clone() { 
		return new IntSetLiskov(new ArrayList<Integer>(els));
	}
}
