package edu.gmu.cs.swe619.exercises.week10.exercise10B;

import java.util.Date;

public class Sub extends Super {
	private final Date date;
	
	public Sub() {
		date = new Date();
	}
	
	@Override
	public void overrideMe() {
		System.out.println(date);
	}
}
