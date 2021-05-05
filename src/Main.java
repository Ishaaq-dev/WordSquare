//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import dataManagement.DataHandler;
import trie.Trie;

public class Main {

	public static void main(String[] args) {
		DataHandler dh = new DataHandler();
		Map<Character, HashSet<String>> map = dh.generateWordMapForSquare(4, "eeeeddoonnnsssrv");
		Set<Character> keys = map.keySet();
		for (Character characterKey : map.keySet()) {
			System.out.println(map.get(characterKey));
		}
		
		Object[] keysArray = keys.toArray();
		char letters[] = new char[keys.size()];
		
		for (int i=0; i<keys.size(); i++) {
			letters[i] = Character.toLowerCase((char) keysArray[i]);
		}
		
		int numberOfWords = 0;
		for (Character uniqueLetter : map.keySet()) {
			numberOfWords += map.get(uniqueLetter).size();
		}
		
		String dictionary[] = new String[numberOfWords];
		
		int counter = 0;
		for (Character uniqueLetter : map.keySet()) {
			for (String word : map.get(uniqueLetter)) {
				dictionary[counter] = word;
				counter++;
			}
		}
		
		Trie trie = new Trie();
		
		ArrayList<String> usuableWords = trie.getUsuableWords(dictionary, letters);
		
		for (String word : usuableWords) {
			System.out.println(word);
		}
		
		System.out.println("done");
	}

}

//eeeeddoonnnsssrv
//aaaeeeefhhmoonssrrrrttttw
