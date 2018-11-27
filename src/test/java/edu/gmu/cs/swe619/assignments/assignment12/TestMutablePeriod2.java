package edu.gmu.cs.swe619.assignments.assignment12;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class TestMutablePeriod2 {

	@Test
	public void testStartDateMutablePeriod() {
		MutablePeriod2 mp2 = new MutablePeriod2();
		Period2 p2 = mp2.period2;
		Date p2Start = mp2.start;

		Calendar cal = Calendar.getInstance();
		cal.setTime(p2Start);
		cal.set(Calendar.MONTH, 4); // May
		cal.set(Calendar.DAY_OF_MONTH, 5);
		cal.set(Calendar.YEAR, 1978);
		p2Start.setTime(cal.getTimeInMillis());

		SimpleDateFormat yearFormat = new SimpleDateFormat("MM/dd/yyyy");
		String todayFormat = yearFormat.format(new Date());
		
		// Start date unchanged
		Assert.assertEquals(todayFormat, yearFormat.format(p2.start()));
		
		// End date unchanged
		Assert.assertEquals(todayFormat, yearFormat.format(p2.end()));
		
		// Invariant is not violated
		int compareResult = p2.start().compareTo(p2.end());
		Assert.assertTrue(compareResult <= 0);
	}
	
	@Test
	public void testEndDateMutablePeriod() {
		MutablePeriod2 mp2 = new MutablePeriod2();
		Period2 p2 = mp2.period2;
		Date p2End = mp2.end;

		Calendar cal = Calendar.getInstance();
		cal.setTime(p2End);
		cal.set(Calendar.MONTH, 11); // December
		cal.set(Calendar.DAY_OF_MONTH, 3);
		cal.set(Calendar.YEAR, 1965);
		p2End.setTime(cal.getTimeInMillis());

		SimpleDateFormat yearFormat = new SimpleDateFormat("MM/dd/yyyy");
		String todayFormat = yearFormat.format(new Date());
		
		// Start date unchanged
		Assert.assertEquals(todayFormat, yearFormat.format(p2.start()));
		
		// End date unchanged
		Assert.assertEquals(todayFormat, yearFormat.format(p2.end()));
		
		// Invariant is not violated
		int compareResult = p2.start().compareTo(p2.end());
		Assert.assertTrue(compareResult <= 0);
	}
}
