package edu.gmu.cs.swe619.exercises.week01.exercise0A;

public class SpecialUser extends User {
	private int id;
	
	public SpecialUser(String name, int id) {
		super(name);
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof SpecialUser)) {
			return false;
		}
		
		return super.equals(obj) && ((SpecialUser) obj).id == this.id;
	}
	
	public boolean eclipseGeneratedEquals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		SpecialUser other = (SpecialUser) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
