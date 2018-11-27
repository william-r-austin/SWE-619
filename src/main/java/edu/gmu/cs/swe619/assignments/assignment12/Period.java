package edu.gmu.cs.swe619.assignments.assignment12;

import java.io.Serializable;
import java.util.Date;

/**
 * Immutable class that uses defensive copying. However, our tests will
 * show that this class is vulnerable, due to serialization.
 */
public final class Period implements Serializable {
	/**
	 * Generated serial version UID.
	 */
	private static final long serialVersionUID = 407911090257803173L;
	
	/**
	 * Start date
	 */
	private final Date start;
	
	/**
	 * End date
	 */
	private final Date end;

	/**
	 * @param start
	 *            the beginning of the period
	 * @param end
	 *            the end of the period; must not precede start
	 * @throws IllegalArgumentException
	 *             if start is after end
	 * @throws NullPointerException
	 *             if start or end is null
	 */
	public Period(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		if (this.start.compareTo(this.end) > 0) {
			throw new IllegalArgumentException(start + " after " + end);
		}
	}

	/**
	 * Get the start date
	 * @return  a copy of the period start date
	 */
	public Date start() {
		return new Date(start.getTime());
	}

	/**
	 * Get the end date
	 * @return  a copy of the period end date
	 */
	public Date end() {
		return new Date(end.getTime());
	}

	/**
	 * Abstraction function to show the period in a human-friendly format
	 */
	public String toString() {
		return start + " - " + end;
	}

	// Remainder of the class has been omitted
}