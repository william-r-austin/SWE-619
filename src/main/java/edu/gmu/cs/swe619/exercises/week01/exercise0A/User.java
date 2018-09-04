package edu.gmu.cs.swe619.exercises.week01.exercise0A;

public class User {
	private String name;
	
	public User(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof User)) {
			return false;
		}
		
		return ((User) obj).name.equals(this.name);
	}

	public boolean eclipseGeneratedEquals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
