package org.curiousworks.lesson9;

public class Name {
	String firstName;
	String lastName;

	public Name(String line) {
		String[] split = line.split(",| ");
		firstName = split[0];
		lastName = split[1];
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
