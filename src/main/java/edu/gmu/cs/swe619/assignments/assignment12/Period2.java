package edu.gmu.cs.swe619.assignments.assignment12;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Immutable class that uses defensive copying. In addition, we have provided a
 * correct readObject() method that prevents the serialization vulnerability
 * that the Period class is susceptible to.
 */
public final class Period2 implements Serializable {
	/**
	 * Generated serial version UID.
	 */
	private static final long serialVersionUID = -3538564838544445738L;

	/**
	 * Start date
	 */
	private Date start;

	/**
	 * End date
	 */
	private Date end;

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
	public Period2(Date start, Date end) {
		this.start = new Date(start.getTime());
		this.end = new Date(end.getTime());
		if (this.start.compareTo(this.end) > 0)
			throw new IllegalArgumentException(start + " after " + end);
	}

	/**
	 * readObject() method with defensive copying and validity checking
	 * 
	 * @param s
	 *            the object input strem to deserialize
	 * @throws IOException
	 *             if the stream is not valid
	 * @throws ClassNotFoundException
	 *             if we do not find a class for the deserialized object
	 * @throws InvalidObjectException
	 *             if the Period2 instance that we read is not valid
	 */
	private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
		s.defaultReadObject();

		// Defensively copy our mutable components
		start = new Date(start.getTime());
		end = new Date(end.getTime());

		// Check that our invariants are satisfied
		if (start.compareTo(end) > 0)
			throw new InvalidObjectException(start + " after " + end);
	}

	/**
	 * Get the start date
	 * 
	 * @return a copy of the period start date
	 */
	public Date start() {
		return new Date(start.getTime());
	}

	/**
	 * Get the end date
	 * 
	 * @return a copy of the period end date
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
