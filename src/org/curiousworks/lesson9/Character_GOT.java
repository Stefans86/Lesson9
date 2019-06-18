package org.curiousworks.lesson9;

public class Character_GOT {
	Name character;
	String allegiance;
	String messageFile;

	public Character_GOT(String line) {
		String[] split = line.split(", ");
		character = new Name(line);
		allegiance = split[1];
		messageFile = split[2];

	}

	public Name getCharacter() {
		return character;
	}

	public void setCharacter(Name character) {
		this.character = character;
	}

	public String getAllegiance() {
		return allegiance;
	}

	public void setAllegiance(String allegiance) {
		this.allegiance = allegiance;
	}

	public String getMessageFile() {
		return messageFile;
	}

	public void setMessageFile(String messageFile) {
		this.messageFile = messageFile;
	}

}
