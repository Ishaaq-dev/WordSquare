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
	}
	
	public Map<Character, LetterOfAlphabet> readData() {
		if (wordsMap.isEmpty()) {
			try {
				Scanner scanner = new Scanner(wordFile);
				while (scanner.hasNextLine()) {
					String word = scanner.nextLine().trim();
					System.out.println(word.charAt(0));
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		return wordsMap;
	}
	
	private void addWordToWordsMap(String word) {
		char firstLetter = word.toUpperCase().charAt(0);
		if (!wordsMap.containsKey(firstLetter)) {
			wordsMap.put(firstLetter, new LetterOfAlphabet(firstLetter));
		}
	}
}
