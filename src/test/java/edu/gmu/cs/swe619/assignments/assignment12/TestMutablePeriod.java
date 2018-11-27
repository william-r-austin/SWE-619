package edu.gmu.cs.swe619.assignments.assignment12;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

public class TestMutablePeriod {
		
	@Test
	public void testStartDateMutablePeriod() {
		MutablePeriod mp = new MutablePeriod();
		Period p = mp.period;
		Date pStart = mp.start;

		Calendar cal = Calendar.getInstance();
		cal.setTime(pStart);
		cal.set(Calendar.MONTH, 4); // May
		cal.set(Calendar.DAY_OF_MONTH, 5);
		cal.set(Calendar.YEAR, 1978);
		pStart.setTime(cal.getTimeInMillis());
	
		// Start date changed
		SimpleDateFormat yearFormat = new SimpleDateFormat("MM/dd/yyyy");
		Assert.assertEquals("05/05/1978", yearFormat.format(p.start()));
		
		// End date unchanged
		String todayFormat = yearFormat.format(new Date());
		Assert.assertEquals(todayFormat, yearFormat.format(p.end()));
		
		// Invariant is not violated
		int compareResult = p.start().compareTo(p.end());
		Assert.assertTrue(compareResult < 0);
	}
	
	@Test
	public void testEndDateMutablePeriod() {
		MutablePeriod mp = new MutablePeriod();
		Period p = mp.period;
		Date pEnd = mp.end;

		Calendar cal = Calendar.getInstance();
		cal.setTime(pEnd);
		cal.set(Calendar.MONTH, 11); // December
		cal.set(Calendar.DAY_OF_MONTH, 3);
		cal.set(Calendar.YEAR, 1965);
		pEnd.setTime(cal.getTimeInMillis());
	
		SimpleDateFormat yearFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		// Start date unchanged
		String todayFormat = yearFormat.format(new Date());
		Assert.assertEquals(todayFormat, yearFormat.format(p.start()));
		
		// End date changed
		Assert.assertEquals("12/03/1965", yearFormat.format(p.end()));
		
		// Invariant is violated!! (start > end)
		int compareResult = p.start().compareTo(p.end());
		Assert.assertTrue(compareResult > 0);
	}
	
	@Test
	public void testBothDatesMutablePeriod() {
		MutablePeriod mp = new MutablePeriod();
		Period p = mp.period;
		Date pStart = mp.start;
		Date pEnd = mp.end;

		Calendar cal = Calendar.getInstance();
		cal.setTime(pStart);
		cal.set(Calendar.MONTH, 4); // May
		cal.set(Calendar.DAY_OF_MONTH, 5);
		cal.set(Calendar.YEAR, 1978);
		pStart.setTime(cal.getTimeInMillis());
		
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(pEnd);
		cal2.set(Calendar.MONTH, 11); // December
		cal2.set(Calendar.DAY_OF_MONTH, 3);
		cal2.set(Calendar.YEAR, 1965);
		pEnd.setTime(cal2.getTimeInMillis());
		
		// Start date changed
		SimpleDateFormat yearFormat = new SimpleDateFormat("MM/dd/yyyy");
		Assert.assertEquals("05/05/1978", yearFormat.format(p.start()));
		
		// End date changed
		Assert.assertEquals("12/03/1965", yearFormat.format(p.end()));
		
		// Invariant is violated!! (start > end)
		int compareResult = p.start().compareTo(p.end());
		Assert.assertTrue(compareResult > 0);
	}
}