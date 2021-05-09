package dataManagement;

import java.util.LinkedList;
import java.util.List;

public class WordSquare {

	private List<String> wordSquare;
	
	
	public WordSquare() {
		wordSquare = new LinkedList<String>();
	}
	
	public List<String> getWordSquare() {
		return wordSquare;
	}
	
	public void addWord(String word) {
		wordSquare.add(word);
	}
	
	public String getWord(int index) {
		return wordSquare.get(index);
	}
	
	public int getLengthOfWord() {
		return wordSquare.get(0).length();
	}
	
	public int getSizeOfList() {
		return wordSquare.size();
	}
	
	public String toString() {
		String str = "";
		for (String word : wordSquare) {
			str += word + "\n";
		}
		return str + "\n";
	}
	
	public void pop() {
		wordSquare.remove(wordSquare.size() - 1);
	}
}
