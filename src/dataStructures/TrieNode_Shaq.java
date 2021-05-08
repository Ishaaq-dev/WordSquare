package dataStructures;

import java.util.HashSet;
import java.util.Set;

public class TrieNode_Shaq {
	private String letter;
	private Set<TrieNode_Shaq> children;
	private boolean isWord;
	private TrieNode_Shaq foundNode;

	public TrieNode_Shaq(char letter) {
		this.letter = Character.toString(letter);
		children = new HashSet<TrieNode_Shaq>();
		isWord = false;
		foundNode = null;
	}

	public TrieNode_Shaq() {
		letter = "";
		children = new HashSet<TrieNode_Shaq>();
		isWord = false;
		foundNode = null;
	}

	public String getLetter() {
		return this.letter;
	}

	public Set<TrieNode_Shaq> getChildren() {
		return this.children;
	}

	public boolean getIsWord() {
		return this.isWord;
	}

	public TrieNode_Shaq getFoundNode()  {
		return this.foundNode;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}

	public void setChildren(HashSet<TrieNode_Shaq> children) {
		this.children = children;
	}

	public void addNodeToChildren(TrieNode_Shaq node) {
		children.add(node);
	}

	public void setIsWord(boolean isWord) {
		this.isWord = isWord;
	}

	public boolean checkChildrenContainLetter(char letter) {
		boolean found = false;
		for (TrieNode_Shaq node : children) {
			if (node.getLetter().equalsIgnoreCase(Character.toString(letter))) {
				found = true;
				foundNode = node;
			}
		}
		return found;
	}
}
