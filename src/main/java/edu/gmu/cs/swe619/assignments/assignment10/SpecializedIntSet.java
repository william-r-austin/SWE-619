package edu.gmu.cs.swe619.assignments.assignment10;

import java.util.Objects;

/**
 * Subclass of IntSet to show how to implement clone() correctly in a class hierarchy.
 */
public class SpecializedIntSet extends IntSet implements Cloneable {

	/**
	 * Additional 'label' property, just for demo purposes.
	 */
	private String label;
	
	/**
	 * Constructor to create a new object
	 * @param label
	 */
	public SpecializedIntSet(String label) {
		super();
		this.label = label;
	}
	
	/**
	 * Get the label
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * Set the label
	 * @param label
	 */
	public void setLabel(String label) {
		this.label = label;
	}

	/**
	 * Corrct implementation of the clone() method. By calling
	 * super.clone(), we can create a copy of the object and
	 * then subsequently set the instance variables for the superclass
	 * correctly.
	 * 
	 * @return a copy of this SpecializedIntSet
	 */
	@Override
	public SpecializedIntSet clone() {
		SpecializedIntSet copy = (SpecializedIntSet) super.clone();
		copy.label = this.label;
		return copy;
	}

	/**
	 * Basic hash code generated from Eclipse.
	 * 
	 * @return hash value
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	/**
	 * Standard recipe for equals() from Bloch
	 * 
	 * @return true if the objects are equal. False otherwise. As with the example in class, 
	 *         the commutativity is not preserved when comparing super and subclass methods.
	 */
	@Override
	public boolean equals(Object obj) {
		if(obj != null) {
			if(obj instanceof SpecializedIntSet) {
				if(!super.equals(obj)) {
					return false;
				}
				
				SpecializedIntSet other = (SpecializedIntSet) obj;
				return Objects.equals(this.label, other.label);
			}
		}
		
		return false;
	}
}
