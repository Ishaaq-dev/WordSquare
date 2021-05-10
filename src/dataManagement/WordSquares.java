package dataManagement;

import java.util.ArrayList;
import java.util.List;

import dataStructures.Permutation;

public class WordSquares {

	private Permutation permutation;
	private List<WordSquare> wordSquares;
	
	public WordSquares(Permutation permutation) {
		this.permutation = permutation;
		wordSquares = new ArrayList<WordSquare>();
		makeWordSquare();
	}
	
	public void makeWordSquare() {
		for (String word : permutation.getListOfWords()) {
			WordSquare wordSquare = new WordSquare();
			wordSquare.addWord(word);
			wordSquareRecursive(1, wordSquare);
		}
	}
	
	public List<WordSquare> getWordSqaures() {
		return wordSquares;
	}
	
	
	public boolean wordSquareRecursive(int index, WordSquare wordSquare) {
		boolean check = false;
		if (wordSquare.getSizeOfList() == wordSquare.getLengthOfWord()) {
			wordSquares.add(cloneWordSqaure(wordSquare));
			return true;
		}
		String prefix = "";
		
		for (String wordForPrefix : wordSquare.getWordSquare()) {
			prefix += wordForPrefix.charAt(index);
		}
		
		for (String wordFromPrefix : getWordsFromPrefix(prefix)) {
			wordSquare.addWord(wordFromPrefix);
			wordSquareRecursive(index + 1, wordSquare);
			wordSquare.pop();
		}
		
		return check;
	}
	
	public List<String> getWordsFromPrefix(String prefix) {
		List<String> wordsFromPrefix = new ArrayList<String>();
		for (String word : permutation.getListOfWords()) {
			if (word.startsWith(prefix)) wordsFromPrefix.add(word);
		}
		return wordsFromPrefix;
	}
	
	public String toString() {
		String toString = "";
		if (wordSquares.isEmpty()) toString += "No word squares can be generated.";
		else {
			toString += "WordSqaures:\n";
			for (WordSquare wordSquare : wordSquares) {
				toString += wordSquare.toString() + "\n";
			}
		}
		return toString;
	}
	
	private WordSquare cloneWordSqaure(WordSquare wordSquare) {
		WordSquare clone = new WordSquare();
		for (String word : wordSquare.getWordSquare()) {
			clone.addWord(word);
		}
		return clone;
	}
}
