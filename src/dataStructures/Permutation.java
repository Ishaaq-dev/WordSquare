package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	private List<String> listOfWords;
	private String letters;
	
	public Permutation(String letters) {
		listOfWords = new ArrayList<String>();
		this.letters = letters;
	}
	
	public List<String> getListOfWords() {
		return listOfWords;
	}
	
	public void addWord(String word) {
		listOfWords.add(word);
	}
	
	public int getNumberOfWords() {
		return listOfWords.size();
	}
	
	public int getSizeOfWords() {
		return listOfWords.get(0).length();
	}
	
	public boolean populateListOfWords() {
		double sizeOfWord = Math.sqrt(letters.length());
		if (sizeOfWord % 1 != 0) {
			System.out.println("Length of string inputted is not squarerootable");
			return false;
		} else {
			for (int i=0; i<letters.length(); i+=sizeOfWord) {
				String word = letters.substring(i, i + (int) sizeOfWord);
				addWord(word);
			}
			return true;	
		}
	}
	
	public String toString() {
		String toString = "";
		for (String word : listOfWords) {
			toString += word + ",";
		}
		toString += "\n";
		return toString;
	}
}
