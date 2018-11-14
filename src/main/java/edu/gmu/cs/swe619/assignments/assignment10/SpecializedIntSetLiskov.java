package edu.gmu.cs.swe619.assignments.assignment10;

/**
 * Subclass of the IntSetLiskov to show the broken clone() method. Calling the clone
 * method here will result in a ClassCastException.
 */
public class SpecializedIntSetLiskov extends IntSetLiskov implements Cloneable {

	/**
	 * Public constructor to create a new object.
	 */
	public SpecializedIntSetLiskov() {
		super();
	}
	
	/**
	 * A simple clone() method that does not run correctly due to the 
	 * way the superclass clone() is implemented.
	 * 
	 * @return  copy of this
	 */
	@Override
	public SpecializedIntSetLiskov clone() {
		SpecializedIntSetLiskov copy = (SpecializedIntSetLiskov) super.clone();
		return copy;
		
	}
}
