package dataStructures;

import java.util.ArrayList;
import java.util.List;

public class Trie_Shaq{
	private TrieNode_Shaq rootNode;

	public Trie_Shaq() {
		this.rootNode = new TrieNode_Shaq();
	}

	public boolean findWord(String word) {
		TrieNode_Shaq node = rootNode;

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
}
