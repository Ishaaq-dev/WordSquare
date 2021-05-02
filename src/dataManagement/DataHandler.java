package dataManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataHandler {
	private File wordFile;
	private Map<Character, LetterOfAlphabet> wordsMap;
	
	public DataHandler() {
		wordFile = new File("data/enable1.txt");
		wordsMap = new HashMap<Character, LetterOfAlphabet>();
		wordsMap = readData();
	}

	public Map<Character, LetterOfAlphabet> readData() {
		if (wordsMap.isEmpty()) {
			try {
				Scanner scanner = new Scanner(wordFile);
				while (scanner.hasNextLine()) {
					String word = scanner.nextLine().trim();
					addWordToWordsMap(word);
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return wordsMap;
	}
	
	public Map<Character, LetterOfAlphabet> getWordsMap() {
		return wordsMap;
	}
	
	private void addWordToWordsMap(String word) {
		char firstLetter = word.toUpperCase().charAt(0);
		if (!wordsMap.containsKey(firstLetter)) {
			wordsMap.put(firstLetter, new LetterOfAlphabet(firstLetter));
		}
		wordsMap.get(firstLetter).addWord(word);
	}
	
	public String toString() {
		String toString = "";
		for (Character character : wordsMap.keySet()) {
			toString += wordsMap.get(character).toString();
		}
		return toString;
	}
}
