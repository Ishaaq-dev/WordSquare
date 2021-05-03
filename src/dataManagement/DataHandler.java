package dataManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class DataHandler {
	private File wordFile;
	private Map<Character, LetterOfAlphabet> wordsMap;
	private int numberOfWords;
	
	public DataHandler() {
		wordFile = new File("data/enable1.txt");
		wordsMap = new HashMap<Character, LetterOfAlphabet>();
		readData();
		numberOfWords = calculateNumberOfWords();
	}

	public void readData() {
		if (wordsMap.isEmpty()) {
			try {
				Scanner scanner = new Scanner(wordFile);
				while (scanner.hasNextLine()) {
					String word = scanner.nextLine();
					addWordToWordsMap(word);
				}
				scanner.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Map<Character, LetterOfAlphabet> getWordsMap() {
		return wordsMap;
	}
	
	public int getNumberOfWords() {
		return numberOfWords;
	}
	
	private int calculateNumberOfWords() {
		int totalNumOfWords = 0;
		for (Character key : wordsMap.keySet()) {
			int num = wordsMap.get(key).getNumberOfWords();
			totalNumOfWords += num;
		}
		return totalNumOfWords;
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
	
	private HashSet<String> getHashSetOfWordsByLength(Character letter, int lengthOfWord) {
		HashSet<String> result = null;
		letter = Character.toUpperCase(letter);
		if (wordsMap.containsKey(letter)) result = wordsMap.get(letter).getHashSet(lengthOfWord);
		return result;
	}
	
	public Map<Character, HashSet<String>> generateWordMapForSquare(int sizeOfGrid, String letters) {
		Map<Character, HashSet<String>> wordMapForSquare = new HashMap<Character, HashSet<String>>();
		double squareRootLengthOfLetters = Math.sqrt(letters.length());
		if (sizeOfGrid != squareRootLengthOfLetters) {
			System.out.println("Size of grid specified: " + sizeOfGrid + "\n"
					+ "Squareroot of length of letters specified: " + squareRootLengthOfLetters + "\n"
					+ "Do not match.\n");
			return null;
		}
		
		String[] chars = letters.split("");		
		Stream.of(chars).distinct().forEach(letter -> {
			letter = letter.toUpperCase();
			wordMapForSquare.put(letter.charAt(0), getHashSetOfWordsByLength(letter.charAt(0), sizeOfGrid));
		});
		
		return wordMapForSquare; 
	}
}
