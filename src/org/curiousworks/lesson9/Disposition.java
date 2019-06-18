package org.curiousworks.lesson9;

import java.util.ArrayList;

public class Disposition {
	static final String[] happy = { "😄", "🙂", "😊", "😍" };
	static final String[] sad = { "😢", "😭", "😞", "👿" };
	static final String[] love = { "😍", "😘" };
	static int happiness;
	static int sadness;
	static int inLove;

	public static int isHappy(ArrayList<String> messagesContent) {
		happiness = 0;
		for (int t = 0; t < messagesContent.size(); t++) {

			String stringContent = messagesContent.get(t).replaceAll(", |\\[|\\]|\\.|\"", " ");
			String[] contentToWords = stringContent.split(" ");
			for (int j = 0; j < contentToWords.length; j++) {
				for (int k = 0; k < happy.length; k++) {

					if (contentToWords[j].contains(happy[k])) {
						happiness++;

					}

				}

			}

		}
		return happiness;
	}

	public static int isSad(ArrayList<String> messagesContent) {
		sadness = 0;
		for (int t = 0; t < messagesContent.size(); t++) {
			String stringContent = messagesContent.get(t).replaceAll(", |\\[|\\]|\\.|\"", " ");
			String[] contentToWords = stringContent.split(" ");
			for (int j = 0; j < contentToWords.length; j++) {
				for (int m = 0; m < sad.length; m++) {

					if (contentToWords[j].contains(sad[m])) {
						sadness++;

					}

				}

			}

		}
		return sadness;
	}

	public static int isInLove(ArrayList<String> messagesContent) {
		inLove = 0;
		for (int t = 0; t < messagesContent.size(); t++) {

			String stringContent = messagesContent.get(t).replaceAll(", |\\[|\\]|\\.|\"", " ");
			String[] contentToWords = stringContent.split(" ");
			for (int j = 0; j < contentToWords.length; j++) {
				for (int o = 0; o < love.length; o++) {

					if (contentToWords[j].contains(love[o])) {
						inLove++;

					}

				}

			}

		}
		return inLove;

	}
}