package edu.gmu.cs.swe619.assignments.assignment12;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * This class uses serialization to try to exploit the Period2 class by 
 * creating references directly to private fields in the class. However,
 * the readObject() implementation provided prevents the attack from occurring.
 */
public class MutablePeriod2 {
	
	/**
	 * A Period2 instance
	 */
	public final Period2 period2;

	/**
	 * The start field for period2, to which we shouldn't have access
	 */
	public final Date start;

	/**
	 * The end field for period2, to which we shouldn't have access
	 */
	public final Date end;

	/**
	 * Constructor to create our Period2 object and attempt to initialize
	 * the start and end date fields
	 */
	public MutablePeriod2() {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bos);

			// Serialize a valid Period instance
			out.writeObject(new Period2(new Date(), new Date()));

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
			period2 = (Period2) in.readObject();
			start = (Date) in.readObject();
			end = (Date) in.readObject();
		} 
		catch (Exception e) {
			throw new AssertionError(e);
		}
	}
}
