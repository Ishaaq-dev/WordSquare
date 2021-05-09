package dataManagement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import dataStructures.Permutation;

public class WordSquare {

	private Permutation permutation;
	private List<List<String>> wordSquare;
	
	public WordSquare(Permutation permutation) {
		this.permutation = permutation;
		wordSquare = new ArrayList<List<String>>();
	}
	
	public List<List<String>> makeWordSquare() {
		for (String word : permutation.getListOfWords()) {
			List<String> wordSquareList = new LinkedList<String>();
			wordSquareList.add(word);
			wordSquareRecursive(1, wordSquareList);
		}
		return wordSquare;
	}
	
	
	public boolean wordSquareRecursive(int index, List<String> wordSquareList) {
		boolean check = false;
		if (wordSquareList.size() == wordSquareList.get(0).length()) {
			print(wordSquareList);
			wordSquare.add(wordSquareList);
			return true;
		}
		String prefix = "";
		
		for (String wordForPrefix : wordSquareList) {
			prefix += wordForPrefix.charAt(index);
		}
		
		for (String wordFromPrefix : getWordsFromPrefix(prefix)) {
			wordSquareList.add(wordFromPrefix);
			wordSquareRecursive(index + 1, wordSquareList);
			wordSquareList.remove(wordSquareList.size() - 1);
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
	
	public void print(List<String> list) {
		for (String word : list) {
			System.out.println(word);
		}
		System.out.println();
	}
}
