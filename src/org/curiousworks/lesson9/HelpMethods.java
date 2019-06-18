package org.curiousworks.lesson9;

import java.util.ArrayList;
import java.util.List;

public class HelpMethods extends FileHelper {
	// text from string file modified into array of lines
	public static String[] toLines() {
		String file = loadMetaData();
		String[] lines = file.split("\\r?\\n");
		return lines;
	}

	// creates list of instances of class Messages
	public static ArrayList<Message> createListOfMessages(String name) {
		String[] listDoc = toLines();
		String messageFile = null;
		for (int i = 1; i < listDoc.length; i++) {
			if (listDoc[i].contains(name)) {
				messageFile = new Character_GOT(listDoc[i]).getMessageFile();
			}
		}
		List<String> characterListMessageLines = loadMessages(messageFile);
		ArrayList<Message> listOfMessages = new ArrayList<Message>();
		for (int i = 1; i < characterListMessageLines.size(); i++) {
			if (characterListMessageLines.get(i).isBlank()) {
				break;
			} else {
				Message m = new Message(characterListMessageLines.get(i));
				listOfMessages.add(m);
			}

		}
		return listOfMessages;
	}

	// creates list of message contents of instances of a class Message
	public static ArrayList<String> createListOfMessageContent(String name) {
		ArrayList<String> listOfMessageContent = new ArrayList<String>();
		ArrayList<Message> messageList = createListOfMessages(name);
		for (int i = 0; i < messageList.size(); i++) {
			listOfMessageContent.add(messageList.get(i).messageContent);
		}
		return listOfMessageContent;
	}
}
