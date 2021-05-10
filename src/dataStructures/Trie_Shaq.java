package dataStructures;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Trie_Shaq{
	private TrieNode_Shaq rootNode;
	private Map<Character, Set<String>> dictionary;

	public Trie_Shaq() {
		this.rootNode = new TrieNode_Shaq();
		this.dictionary = new HashMap<Character, Set<String>>();
	}

	public boolean findWord(String word) {
		TrieNode_Shaq node = rootNode;
		word = word.toLowerCase();

		for (int i=0; i<word.length();i++) {
			char currentLetter = word.charAt(i);

			if(node.checkChildrenContainLetter(currentLetter)) {
				node = node.getFoundNode();
			} else {
				return false;
			}
		}
		return true;
	}

	public void insertWord(String word) {
		TrieNode_Shaq node = rootNode;
		word = word.toLowerCase();
		char firstLetter = word.charAt(0);
		if (!dictionary.containsKey(firstLetter))
			dictionary.put(firstLetter, new HashSet<String>());
		dictionary.get(firstLetter).add(word);

		for(int i=0; i<word.length(); i++) {
			char currentLetter = word.charAt(i);

			if(node.checkChildrenContainLetter(currentLetter)) {
				node = node.getFoundNode();
			} else {
				TrieNode_Shaq newNode = new TrieNode_Shaq(currentLetter);
				node.addNodeToChildren(newNode);
				node = newNode;
			}
		}
		node.setIsWord(true);
	}
	
	public Map<Character, Set<String>> getDictionary() {
		return dictionary;
	}
	
	public String dictionaryToString() {
		String toString = "";
		for (Character firstLetter : dictionary.keySet()) {
			toString += firstLetter + ":\n";
			for (String word : dictionary.get(firstLetter)) {
				toString += word + ",";
			}
			toString += "\n";
		}
		return toString;
	}
}
