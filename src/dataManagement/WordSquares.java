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
	}
	
	public List<WordSquare> makeWordSquare() {
		for (String word : permutation.getListOfWords()) {
			WordSquare wordSquare = new WordSquare();
			wordSquare.addWord(word);
			wordSquareRecursive(1, wordSquare);
		}
		return wordSquares;
	}
	
	
	public boolean wordSquareRecursive(int index, WordSquare wordSquare) {
		boolean check = false;
		if (wordSquare.getSizeOfList() == wordSquare.getLengthOfWord()) {
			System.out.println(wordSquare.toString());
			wordSquares.add(wordSquare);
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
}
