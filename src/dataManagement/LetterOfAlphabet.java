package dataManagement;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LetterOfAlphabet {
	private final char letter;
	private Map<Integer, HashSet<String>> wordsMap;
	private int numberOfWords;
	
	public LetterOfAlphabet(char letter) {
		this.letter = Character.toLowerCase(letter);
		wordsMap = new HashMap<Integer, HashSet<String>>();
		numberOfWords = 0;
	}
	
	public Map<Integer, HashSet<String>> getWordsMap() {
		return wordsMap;
	}
	
	public int getNumberOfWords() {
		numberOfWords = calculateNumberOfWords();
		return numberOfWords;
	}
	
	private int calculateNumberOfWords() {
		int num = 0;
		for (Integer key : wordsMap.keySet()) {
			num += wordsMap.get(key).size();
		}
		return num;
	}
	
	public HashSet<String> getHashSet(int lengthOfWord) {
		if (wordsMap.containsKey(lengthOfWord)) {
			return wordsMap.get(lengthOfWord);
		} else {
			System.out.println("HashSet for length of word: " + lengthOfWord + " does not exist.\n");
			return null;
		}
	}
	
	public boolean addWord(String word) {
		int lengthOfWord = word.length();
		char firstLetter = word.toLowerCase().charAt(0);
		if (firstLetter != letter) {
			System.out.println("First letter of this object: " + letter + "\n" 
					+ "First letter of word: " + word + "\n"
					+ "Do not match.\n");
			return false;
		}
		if(!wordsMap.containsKey(lengthOfWord)) {
			wordsMap.put(lengthOfWord, new HashSet<String>());
		}
		wordsMap.get(lengthOfWord).add(word.toLowerCase());
		return true;
	}
	
	public String toString() {
		String toString = "Letter: " + letter + "\n";
		if(wordsMap.isEmpty()) {
			toString += "No words containing the letter: " + letter + "\n";
		} else {
			for (Integer key : wordsMap.keySet()) {
				toString += "All words with length of characters: " + key + "\n";
				for(String word : wordsMap.get(key)) {
					toString += word + "\n";
				}
				toString += "\n";
			}
		}
		return toString;
	}
}
