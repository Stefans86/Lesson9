package org.curiousworks.lesson9;

import java.util.ArrayList;
import java.util.List;

public class Message {
	String reciever;
	String messageContent;

	public Message(String line) {

		reciever = line.substring(0, line.indexOf(","));
		messageContent = line.substring(line.indexOf(",") + 1);

	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

}
