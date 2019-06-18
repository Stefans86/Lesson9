package org.curiousworks.lesson9;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Results {

	public static void main(String[] args) {

		// Printing Daenerys messages

		ArrayList<Message> danylistOfMessages = HelpMethods.createListOfMessages("Daenerys");
		for (int i = 0; i < danylistOfMessages.size(); i++) {
			System.out.println("Daenerys to " + danylistOfMessages.get(i).reciever + " : "
					+ danylistOfMessages.get(i).messageContent);
		}

		// pop up that displays number of messages each character has sent

		String[] listDoc = HelpMethods.toLines();
		ArrayList<String> popDisplay = new ArrayList<String>();
		int numberOfMessages = 0;
		for (int i = 1; i < listDoc.length; i++) {
			Character_GOT character = new Character_GOT(listDoc[i]);
			ArrayList<Message> list = HelpMethods.createListOfMessages(character.character.getFirstName());
			numberOfMessages = list.size();
			String toDisplay = character.character.getFirstName() + " has sent " + numberOfMessages + " messages.";
			popDisplay.add(toDisplay);
		}

		String popMessage = popDisplay.toString().replaceAll(",|\\[|\\]", " \n ");
		JOptionPane.showMessageDialog(null, popMessage);

		// Tyrion disposition

		int happiness = 0;
		int sadness = 0;
		String messageFile = null;

		ArrayList<String> tyrionsMessageContent = HelpMethods.createListOfMessageContent("Tyrion");

		happiness = Disposition.isHappy(tyrionsMessageContent);
		sadness = Disposition.isSad(tyrionsMessageContent);

		if (happiness > sadness) {
			System.out.println("");
			System.out.println("Tyrion has a positive disposition. He is more happy than sad.");

		} else if (happiness < sadness) {
			System.out.println("");
			System.out.println("Tyrion has a negative disposition. He is more sad than happy.");

		} else {
			System.out.println("");
			System.out.println(" Tyrion has neutral disposition. He is as much happy as he is sad. ");
		}

		// character with the most positive and most negative disposition

		int happiest = 0;
		int sadest = 0;
		int happiestCharacter = 0;
		int sadestCharacter = 0;

		for (int j = 1; j < listDoc.length; j++) {
			Character_GOT character = new Character_GOT(listDoc[j]);
			ArrayList<String> characterMessageContent = HelpMethods
					.createListOfMessageContent(character.character.getFirstName());

			int h = Disposition.isHappy(characterMessageContent);
			int s = Disposition.isSad(characterMessageContent);
			if (h > happiest) {
				happiest = h;
				happiestCharacter = j;

			}
			if (s > sadness) {
				sadest = s;
				sadestCharacter = j;

			}

		}

		System.out.println("");
		System.out.println("The happiest chracter is  "
				+ new Character_GOT(listDoc[happiestCharacter]).getCharacter().getFirstName() + ".");

		System.out.println("The sadest chracter is  "
				+ new Character_GOT(listDoc[sadestCharacter]).getCharacter().getFirstName() + ".");

		// who loves who more

		ArrayList<Message> jonMessages = HelpMethods.createListOfMessages("Jon");
		ArrayList<Message> danyMessages = HelpMethods.createListOfMessages("Daenerys");
		ArrayList<String> danyMessageContentToJon = new ArrayList<String>();
		ArrayList<String> jonMessageContentToDaenerys = new ArrayList<String>();
		for (int i = 0; i < danyMessages.size(); i++) {

			if (danyMessages.get(i).reciever.contains("Jon")) {
				danyMessageContentToJon.add(danyMessages.get(i).messageContent);
			}

		}
		for (int j = 0; j < jonMessages.size(); j++) {
			if (jonMessages.get(j).reciever.contains("Daenerys")) {
				jonMessageContentToDaenerys.add(jonMessages.get(j).messageContent);

			}

		}
		int jonLovesDany = Disposition.isInLove(jonMessageContentToDaenerys);

		int danyLovesJon = Disposition.isInLove(danyMessageContentToJon);

		if (jonLovesDany > danyLovesJon) {
			System.out.println("");
			System.out.println("Jon loves Daenerys more than she loves him.");
		} else if (jonLovesDany < danyLovesJon) {
			System.out.println("");
			System.out.println("Daenerys loves Jon more than he loves her.");
		} else {
			System.out.println("");
			System.out.println("daenerys loves Jon as much as he loves her.");
		}

	}
}
