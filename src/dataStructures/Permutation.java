package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
	private List<String> listOfWords;
	private String letters;
	private boolean populated;
	
	public Permutation(String letters) {
		if (letters != null) listOfWords = populateListOfWords(letters);
		this.letters = letters;
		populated = listOfWords == null ? false : true;
	}
	
	public List<String> getListOfWords() {
		return listOfWords;
	}
	
	public String getLetters() {
		return letters;
	}
	
	public boolean isPopulated() {
		return populated;
	}
	
	public void addWord(String word) {
		listOfWords.add(word);
	}
	
	public int getNumberOfWords() {
		return listOfWords.size();
	}
	
	public String getWord(int index) {
		return listOfWords.get(index);
	}
	
	public int getSizeOfWords() {
		return listOfWords.get(0).length();
	}
	
	public List<String> populateListOfWords(String letters) {
		List<String> list = new ArrayList<String>();
		double sizeOfWord = Math.sqrt(letters.length());
		if (sizeOfWord % 1 != 0) {
			System.out.println("Length of string inputted is not squarerootable");
			return null;
		} else {
			for (int i=0; i<letters.length(); i+=sizeOfWord) {
				String word = letters.substring(i, i + (int) sizeOfWord);
				list.add(word);
			}
			return list;	
		}
	}
	
	public boolean checkWordInList(String word) {
		boolean check = true;
		
		for (int i=0; i<listOfWords.size(); i++ ) {
			if (!listOfWords.contains(word)) {
				check = false;
				i = listOfWords.size();
			}
		}
		
		return check;
	}
	
	public boolean checkIndex(int index) {
		boolean check = false;
		if (populated) {
			try {
				String word = letters.substring(0, index + 1);
				if (word.length() % getSizeOfWords() == 0) check = true;
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("check index: index suuplied does not exist in string");
			}
		}
		return check;
	}
	
	public List<String> getCheckIndexWords(int index) {
		List<String> list = null;
		if(checkIndex(index)) {
			list = new ArrayList<String>();
			String word = letters.substring(0, index + 1);
			for (int i=0; i<word.length(); i+=getSizeOfWords()) {
				String str = word.substring(i, i + getSizeOfWords());
				list.add(str);
			}
		}
		
		return list;
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
