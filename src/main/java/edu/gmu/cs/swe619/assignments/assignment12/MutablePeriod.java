package edu.gmu.cs.swe619.assignments.assignment12;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * This class uses serialization to exploit the Period class by 
 * letting the client access object internals and corrupt the
 * state.
 */
public class MutablePeriod {
	/**
	 * A Period instance
	 */
	public final Period period;

	/**
	 * period's start field, to which we shouldn't have access
	 */
	public final Date start;

	/**
	 * period's end field, to which we shouldn't have access
	 */
	public final Date end;

	/**
	 * Constructor to create our Period object and initialize Date
	 * objects that correspond to the start and end fields.
	 */
	public MutablePeriod() {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bos);

			// Serialize a valid Period instance
			out.writeObject(new Period(new Date(), new Date()));

			/*
			 * Append rogue "previous object refs" for internal Date fields in
			 * Period. For details, see "Java Object Serialization
			 * Specification," Section 6.4.
			 */
			byte[] ref = { 0x71, 0, 0x7e, 0, 5 }; // Ref #5
			bos.write(ref); // The start field
			ref[4] = 4; // Ref # 4
			bos.write(ref); // The end field

			// Deserialize Period and "stolen" Date references
			ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
			period = (Period) in.readObject();
			start = (Date) in.readObject();
			end = (Date) in.readObject();
		} 
		catch (Exception e) {
			throw new AssertionError(e);
		}
	}
}